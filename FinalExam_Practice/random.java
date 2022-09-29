package FinalExam_Practice;

import java.util.Random;

public class random {
    public static void main(String[] args) {
        Random rd = new Random();

        for (int i = 1; i <= 3; i++) {
            String task = i+") "+ (rd.nextInt(4)+1);
            System.out.println(task);
        }
    }
}
