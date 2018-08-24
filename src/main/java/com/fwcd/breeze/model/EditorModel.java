package com.fwcd.breeze.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fwcd.breeze.utils.TwoWay;
import com.fwcd.fructose.Observable;

public class EditorModel {
	private final TwoWay<Observable<String>> text = new TwoWay<>(() -> new Observable<>(""));
	
	public TwoWay<Observable<String>> getText() { return text; }
	
	public void open(Path file) {
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			StringBuilder buffer = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				buffer.append(line);
				line = reader.readLine();
			}
			text.getRequested().set(buffer.toString());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public void save(Path file) {
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write(text.getActual().get());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
