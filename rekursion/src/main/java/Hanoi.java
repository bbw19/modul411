import java.util.Stack;

public class Hanoi {
    private static Stack<Integer> quelle = new Stack<Integer>();
    private static Stack<Integer> hilfe = new Stack<Integer>();
    private static Stack<Integer> ziel = new Stack<Integer>();

    private static void init(int n) {
        for (int i = 0; i < n; i++) {
            quelle.push(i);
        }
    }

    private static void show() {
        System.out.println(quelle);
    }

    private static void showSolution() {
        System.out.println(ziel);
    }

    private static void bewegen(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (n > 0) {
            bewegen(n-1, a, c, b);
            c.push(a.pop());
            bewegen(n-1, b, a, c);
        }
    }

    public static void main(String[] args) {
        init(3);
        show();
        bewegen(3, quelle, hilfe, ziel);
        showSolution();
    }
}
