package org.betsmart.analytics.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTraverser {
	File file;

	public FileTraverser(File file) {
		super();
		this.file = file;
	}

	public void traverse() {
		PlayerExtractor csv = new PlayerExtractor();
		try (Scanner in = new Scanner(file)) {
			// skip first line
			in.nextLine();
			while (in.hasNextLine()) {
				String s = in.nextLine();
				csv.extract(s);
			}
			csv.cleanup();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
