package einstieg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OutputExample {

	public static void main(String[] args) {
		// Create file
		File file = new File("files/output.txt");

		try {
			// Create a buffered reader to read each line from standard in.
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
			BufferedReader in = new BufferedReader(isr);
			// Create a print writer on this file.
			PrintWriter out = new PrintWriter(new FileWriter(file));
			String s;
			System.out.print("Enter file text. ");
			System.out.println("[Type ctrl-d (unix) ctrl-z (win) to stop.]");
			int i=0;
			// Read each input line and echo it to the screen.
			while ((s = in.readLine()) != null)  {
			//  while (i<=10) {
				s = in.readLine();
				out.println(s);
				i++;
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
