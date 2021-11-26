package einstieg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CapsLocker {

	public static void main(String[] args) {

		// Create file
		File file = new File("files/output.txt");

		try {
			// Create a buffered reader
			// to read each line from a file.
			BufferedReader in = new BufferedReader(new FileReader(file));

			// Read each line from the file and echo it to the screen.
			/*
			 * s = in.readLine(); while (s != null) { System.out.println("Read: " + s); s =
			 * in.readLine(); }
			 */
			// in functional mode

			in.lines()
					.forEach((line) -> System.out.println("line: " + line.toUpperCase()));

			// Close the buffered reader
			in.close();

		} catch (FileNotFoundException e1) {
			// If this file does not exist
			System.err.println("File not found: " + file);

		} catch (IOException e2) {
			// Catch any other IO exceptions.
			e2.printStackTrace();
		}
	}

}
