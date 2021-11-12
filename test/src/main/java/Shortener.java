public class Shortener {
    public static void main(String[] args) {
        String string = "Hello my dear friend";
        Integer max = 11;

        System.out.println(Shortener(string, max));
    }
    public static String Shortener(String sentence, Integer max)
    {
        Integer original_lenght = sentence.length();

        String max_string = sentence.substring(0, max);

        for (int i = 0; i < max; i = i + 1) {

            String letter = Character.toString(max_string.charAt(max-(i+1)));

            if (letter.equals(" ")) {
                max_string = sentence.substring(0, max-(i+1));
                break;
            }
        }

        return max_string;
    }
}
