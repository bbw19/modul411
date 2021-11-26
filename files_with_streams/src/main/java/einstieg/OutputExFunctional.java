package einstieg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OutputExFunctional {

	public static void main(String[] args) {
		// Create file
		File file = new File("files/output.txt");

		try {

			// press ctrl-z and ctrl-d (mac, linux) for termination
			// Use a Scanner to read in
			// Create a scanner to read each line from standard in.
			Scanner in = new Scanner(System.in);

			// Create a print writer on this file.
			PrintWriter out = new PrintWriter(new FileWriter(file));
			String s;

			System.out.print("Enter file text. ");
			System.out.println("[Type ctrl-z to stop.]");
			// Read each input line and echo it to the screen.
			while (in.hasNextLine()) {
				// while (i<=10) {
				s = in.nextLine();
				out.println(s);

			}

			// Close the buffered reader and the file print writer.
			in.close();
			out.close();

		} catch (IOException e) {
			// Catch any IO exceptions.
			e.printStackTrace();
		}
	}

}
