import java.util.ArrayList;

public class LaRousse {
    public static void main(String[] args) {
        System.out.println(LaRousse(45,19));
    }
    public static int LaRousse(int A, int B) {

        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();
        ArrayList<Integer> Z = new ArrayList<Integer>();

        X.add(A);
        Y.add(B);

        int Xcount = 0;
        while (X.get(Xcount) > 0) {

            if (X.get(Xcount) % 2 != 0) {
                Z.add(Y.get(Xcount));
                X.add( (X.get(Xcount) - 1) / 2 );
            } else {
                Z.add(0);
                X.add( X.get(Xcount) / 2 );
            }

            Y.add(Y.get(Xcount) * 2);

            Xcount = Xcount + 1;
        }
        int sum = 0;
        for (int i = 0; i < Z.size(); i = i + 1) {
            sum = sum + Z.get(i);
        }

        return sum;
    }
}
