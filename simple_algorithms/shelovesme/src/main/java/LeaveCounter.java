import java.util.Random;

public class LeaveCounter {
    private Random random = new Random();

    public void run() {
        int runs = this.random.nextInt(10);
        int initial = this.random.nextInt(2);


        for (int i = 0; i < runs; i = i + 1) {
            if ((i + initial)  % 2 == 0) {
                System.out.println("Sie liebt mich!");
            } else {
                System.out.println("Sie liebt mich nicht!");
            }
        }
    }
}
