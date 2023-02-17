package com.coderscampus.assignment;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// execute fileReader
		new FileService().fileReader();
		// execute fileWriter
		new FileService().writeFile();

	}

}
