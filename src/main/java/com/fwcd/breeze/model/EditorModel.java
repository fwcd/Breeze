package com.fwcd.breeze.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fwcd.fructose.structs.ObservableList;

public class EditorModel {
	private final ObservableList<String> lines = new ObservableList<>();
	
	public ObservableList<String> getLines() { return lines; }
	
	public void open(Path file) {
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			List<String> readLines = new ArrayList<>();
			String line = reader.readLine();
			while (line != null) {
				readLines.add(line);
				line = reader.readLine();
			}
			lines.set(readLines);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public void save(Path file) {
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			for (String line : lines.get()) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
