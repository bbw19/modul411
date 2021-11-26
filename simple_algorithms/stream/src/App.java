import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class App {
    public static void main(String[] args) {
        double [] temp = { 13.5, 18.4, 19.6, 21.4, 17.6, 18.3 };

        // Schleife die Array auf Konsole ausgibt

        DoubleStream.of(temp)
                .boxed()
                .forEach(dbl -> System.out.println(dbl));

        // Gib höchste Temp in Konsole aus

        double max = DoubleStream.of(temp)
                .max()
                .getAsDouble();
        System.out.println(max);

        // Gib tiefste Temp in Konsole aus

        double min = DoubleStream.of(temp)
                .min()
                .getAsDouble();
        System.out.println(min);

        // Gib unterschied max/min Temp in Konsole aus

        System.out.println(max - min);

        // Über pfüfe ob Konsoleneingabe ein Palindrom ist

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Palindrome");

        String og = scanner.nextLine();
        String rev = new StringBuilder(og).reverse().toString();

        if (rev.equals(og)) {
            System.out.println("Is a palindrome");
        } else {
            System.out.println("Is not a palindrome");
        }
    }
}
