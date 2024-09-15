package org.betsmart.analytics.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTraverser {
	String path;

	public FileTraverser(String path) {
		super();
		this.path = path;
	}

	public void traverse() {
		File file = new File(path);
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

}
