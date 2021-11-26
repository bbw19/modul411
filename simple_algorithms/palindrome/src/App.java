import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        PalindromeFinder pal = ((val) -> new StringBuilder(val).reverse().toString());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Palindrome");

        String og = scanner.nextLine();
        String rev = pal.compare(og);

        if (rev.equals(og)) {
            System.out.println("Is a palindrome");
        } else {
            System.out.println("Is not a palindrome");
        }
    }

}
