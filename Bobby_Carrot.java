import java.util.Scanner;
import java.util.Random;

public class Bobby_Carrot {

    public static void main(String[] args) {

        final int HEIGHT = 10;
        final int WIDTH = 10;
        final int nCARROT = 10;

        char[][] field = new char[WIDTH][HEIGHT];
        char[][] opened = new char[WIDTH][HEIGHT];

        // init field
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                field[i][j] = '_';
            }
        }

        // generate carrots
        Random r = new Random();
        int k = 0;
        while (k < nCARROT) {
            int w = r.nextInt(WIDTH);
            int h = r.nextInt(HEIGHT);
            if (field[w][h] != 'C') {
                field[w][h] = 'C';
                k++;
            }
        }

        printField(WIDTH, HEIGHT, field);

    }

    public static void printField(int w, int h, char[][] f) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
    }

}

