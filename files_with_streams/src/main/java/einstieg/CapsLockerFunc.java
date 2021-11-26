package einstieg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class CapsLockerFunc {

	public static void main(String[] args) {

		// Create file
		File file = new File("files/wiesel.txt");

		try {
			// Create a buffered reader
			// to read each line from a file.
			BufferedReader in = new BufferedReader(new FileReader(file));

			// in functional as lambda expression mode make a stream and an output
//			in.lines().forEach((line) -> System.out.println("line: " +
//			 line.toUpperCase()));
			// in functional as method reference mode make a stream and an output
			//in.lines().forEach(System.out::println);

			in.lines()
					.filter(s -> s.length() > 20)
					.sorted(Comparator.comparingInt(String::length).reversed())
					.limit(10)
					.forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));

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
