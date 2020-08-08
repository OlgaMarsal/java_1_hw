import java.util.*;

public class MainHW4 {
    final int size = 3;
    char[][] map = new char[size][size];
    final char EMPTY = '•', player = 'x', computer = 'o', cpu2 = 'W', cpu3 = 'Z';
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public static void main(String[] args) {
        MainHW4 g = new MainHW4();
        g.newMap();
        g.printMap();

        while (true) {
            g.playerTurn();
            g.printMap();
            if (g.checkWin(g.player)) { System.out.println("Поздравляем! Вы победили!"); break; }
            if (g.isMapFull()) { System.out.println("Игра окончена. Ничья"); break; }

            g.aiTurn(g.computer);
            g.printMap();
            if (g.checkWin(g.computer)) { System.out.println("Игра окончена. Компьютер победил"); break; }
            if (g.isMapFull()) { System.out.println("Игра окончена. Ничья"); break; }
        }
    }

    void newMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    void printMap() {
        for (int i = 0; i < size + 1; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print("X");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(" " + (i + 1) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println(i + 1);
        }
        System.out.print(" Y ");
        for (int i = 1; i <= size; i++) System.out.print(i + "  ");
        System.out.println("O\n");
    }

    void playerTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход. Введите координаты X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            //System.out.println("Your enter coordinates: x = " + (x + 1) + ", y = " + (y + 1));
        } while (!isCellValid(x, y));
        map[y][x] = player;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        if (map[y][x] == EMPTY) return true;
        return false;
    }

    boolean checkWin(char c) {
        int countV;
        int countH;
        int countDiagonalA = 0;
        int countDiagonalB = 0;
        for (int i = 0; i <= size - 1; i++) {
            countH = 0;
            countV = 0;
            for (int j = 0; j <= size - 1; j++) {
                //tested horizontal check
                if (map[i][j] == c) {
                    countH++;
                    if (countH == size) return true;
                }

                //tested vertical check
                if (map[j][i] == c) {
                    countV++;
                    if (countV == size) return true;
                }
            }

            // tested diagonal A "\" check
            if (map[i][i] == c) {
                countDiagonalA++;
                if (countDiagonalA == size) return true;
            } else countDiagonalA = 0;

            // tested diagonal B "/" check
            if (map[i][size - 1 - i] == c) {
                countDiagonalB++;
                if (countDiagonalB == size) return true;
            } else countDiagonalB = 0;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

    void aiTurn(char c) {
        int x = 0, y = 0, countH = 0, countHNull = 0, countV = 0, countVNull = 0, countDiagonalA = 0, countDiagonalB = 0, countDANull = 0, countDBNull = 0;

        System.out.println("Компьютер походил [" + c +"]:");

        for (int i = 0; i < size; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < size; j++) {
                if (map[j][i] == c) countV++;
                else if (map[j][i] == EMPTY) countVNull++;
                if ((countV == size - 1) && (countVNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (map[k][i] == EMPTY) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }

                if (map[i][j] == c) countH++;
                else if (map[i][j] == EMPTY) countHNull++;
                if ((countH == size - 1) && (countHNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (map[i][k] == EMPTY) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }

            }

            if (map[i][i] == c) countDiagonalA++;
            else if (map[i][i] == EMPTY) countDANull++;
            if ((countDiagonalA == size - 1) && (countDANull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (map[j][j] == EMPTY) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            // good diagonal B "/" move
            if (map[i][size - 1 - i] == c) countDiagonalB++;
            else if (map[i][size - 1 - i] == EMPTY)  countDBNull++;
            if ((countDiagonalB == size - 1) && (countDBNull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (map[j][size - 1 - j] == EMPTY) {
                        map[j][size - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        countH = 0;
        countHNull = 0;
        countV = 0;
        countVNull = 0;
        countDiagonalA = 0;
        countDiagonalB = 0;
        countDANull = 0;
        countDBNull = 0;

        for (int i = 0; i < size; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < size; j++) {
                //good vertical move
                if (map[j][i] == player) countV++;
                else if (map[j][i] == EMPTY) countVNull++;
                if ((countV == size - 1) && (countVNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (map[k][i] == EMPTY) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }

                if (map[i][j] == player) countH++;
                else if (map[i][j] == EMPTY) countHNull++;
                if ((countH == size - 1) && (countHNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (map[i][k] == EMPTY) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }

            }

            if (map[i][i] == player) countDiagonalA++;
            else if (map[i][i] == EMPTY) countDANull++;
            if ((countDiagonalA == size - 1) && (countDANull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (map[j][j] == EMPTY) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            if (map[i][size - 1 - i] == player) countDiagonalB++;
            else if (map[i][size - 1 - i] == EMPTY)  countDBNull++;
            if ((countDiagonalB == size - 1) && (countDBNull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (map[j][size - 1 - j] == EMPTY) {
                        map[j][size - 1 - j] = c;
                        return;
                    }
                }
            }
        }


        if (!(size % 2 == 0)) {
            int center = (((size + 1) / 2) - 1);
            if (map[center][center] == EMPTY) {
                map[center][center] = c;
                return;
            }
        }

        if (map[0][0] == EMPTY) { map[0][0] = c; return; }
        if (map[0][map.length - 1] == EMPTY) { map[0][map.length - 1] = c; return; }
        if (map[map.length - 1][0] == EMPTY) { map[map.length - 1][0] = c; return; }
        if (map[map.length - 1][map.length - 1] == EMPTY) { map[map.length - 1][map.length - 1] = c; return; }

        do {
            x = r.nextInt(size);
            y = r.nextInt(size);
        } while (!isCellValid(x, y));
        map[y][x] = c;
        System.out.println("AI X: " + (x + 1) + " Y: " + (y + 1));
    }
}

