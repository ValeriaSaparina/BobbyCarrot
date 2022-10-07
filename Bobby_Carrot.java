import java.util.Scanner;
import java.util.Random;

public class Bobby_Carrot {

    public static void main(String[] args) {

        rules();

        final int HEIGHT = 10;
        final int WIDTH = 10;
        final int nCARROT = 10;
        char rabbit = '~';
        char carrot = 'C';
        char x = 'X';

        char[][] field = new char[WIDTH][HEIGHT];
        char[][] opened = new char[WIDTH][HEIGHT];

        // init field
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                field[i][j] = '_';
            }
        }
        int posW = 0;
        int posH = 0;
        field[posW][posH] = rabbit;


        // generate carrots
        Random r = new Random();
        int k = 0;
        while (k < nCARROT) {
            int w = r.nextInt(WIDTH);
            int h = r.nextInt(HEIGHT);
            if (field[w][h] != carrot) {
                field[w][h] = carrot;
                k++;
            }
        }

        printField(WIDTH, HEIGHT, field);


        boolean gameIsGoing = true;
        int score = 0;
        int pos = 0;
        Scanner sc = new Scanner(System.in);
        while (gameIsGoing) {

            String action = sc.next();
            switch (action) {
                case "d":
                    pos = posH + 1;
                    if (pos != HEIGHT) {
                        while (field[posW][pos] == x) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    } else {
                        while (pos == HEIGHT) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    }

                    if (field[posW][pos] == carrot) {
                        score++;
                    }
                    field[posW][posH] = x;
                    posH = pos;
                    field[posW][posH] = rabbit;
                    break;

                case "s":
                    pos = posW + 1;
                    if (pos != WIDTH) {
                        while (field[pos][posH] == x) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    } else {
                        while (pos == WIDTH) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    }

                    if (field[pos][posH] == carrot) {
                        score++;
                    }
                    field[posW][posH] = x;
                    posW = pos;
                    field[posW][posH] = rabbit;
                    break;

                case "w":
                    pos = posW - 1;
                    if (pos != -1) {
                        while (field[pos][posH] == x) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    } else {
                        while (pos == -1) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    }

                    if (field[pos][posH] == carrot) {
                        score++;
                    }
                    field[posW][posH] = x;
                    posW = pos;
                    field[posW][posH] = rabbit;
                    break;

                case "a":
                    pos = posH - 1;
                    if (pos != -1) {
                        while (field[posW][pos] == x) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    } else {
                        while (pos == -1) {
                            System.out.println("Измените ход");
                            action = sc.next();
                        }
                    }

                    if (field[posW][pos] == carrot) {
                        score++;
                    }
                    field[posW][posH] = x;
                    posH = pos;
                    field[posW][posH] = rabbit;
                    break;

            }

            System.out.println("Score: " + score);
            printField(WIDTH, HEIGHT, field);

        }


    }

    public static void printField(int w, int h, char[][] f) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rules() {
        System.out.println("\nWelcome to Bobby Carrot!\nRules:\n Press W for up\n Press D for right\n Press S for down\n Press A for left\n");
    }


}

