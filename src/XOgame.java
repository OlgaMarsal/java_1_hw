import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.*;

public class XOgame {
    //переменные final обозначают CAPSLOOK (константы)
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    //сканировать системный ввод
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //задавать размер самостоятельно но убрать в переменной final
//        System.out.println("input SIZE");
//        SIZE = sc.nextInt();
//        System.out.println("input DOTS-TO_WIN");
//        DOTS_TO_WIN = sc.nextInt();
        initMap();
        printMap();

        while (true){
            humanTurn();
            printMap();
            if(checkWinLines(DOT_X)){
                System.out.println("Ты победил!");
                break;
            }
            if(isFull()){
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if(checkWinLines(DOT_O)){
                System.out.println("Компьютер победил!");
                break;
            }
            if(isFull()){
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap () {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //метод ход человека
    public static void humanTurn(){
        int x, y;

        do {
            System.out.println("Input X, Y ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y,x));

        map[y][x] = DOT_X;
    }

    //метод проверки
    public static boolean isCellValid(int y, int x){
        if(x < 0 || y < 0 || x>=SIZE || y>=SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

//компьютер
    public static void aiTurn(){
        int x, y;
// Попытка победить самому
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
// Сбить победную линии противника, если осталось 1 ход для победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

// Сбить победную линии противника, если осталось 2 хода для победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN - 1) &&
                            Math.random() < 0.5) { //  фактор случайности, чтобы сбивал не все время первый попавшийся путь.
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }


// Сходить в произвольную не занятую ячейку
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y,x));

        map[y][x] = DOT_O;
    }

    public static boolean isFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    //условие победы
//    public static boolean checkWin(char c){
//        if(map[0][0] == c && map[0][1] == c && map[0][2] == c) {return true; }
//        if(map[1][0] == c && map[1][1] == c && map[1][2] == c) {return true; }
//        if(map[2][0] == c && map[2][1] == c && map[2][2] == c) {return true; }
//
//        if(map[0][0] == c && map[1][0] == c && map[2][0] == c) {return true; }
//        if(map[0][1] == c && map[1][1] == c && map[2][1] == c) {return true; }
//        if(map[0][2] == c && map[1][2] == c && map[2][2] == c) {return true; }
//
//        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) {return true; }
//        if(map[0][2] == c && map[1][1] == c && map[2][0] == c) {return true; }
//
//        return false;
//    }
    static boolean checkLine(int cy, int cx, int vy, int vx, char dot){
        if (cx + vx * (DOTS_TO_WIN - 1) > SIZE - 1 || cy + vy * (DOTS_TO_WIN - 1) > SIZE - 1 || cy + vy * (DOTS_TO_WIN - 1) <0) {
            return false;
        }
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] !=dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines (char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0,1, dot) || checkLine(i, j, 1, 0, dot) || checkLine(i,j,1,1,dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot, int dotsToWin) {
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 ||
                cy + vy * (dotsToWin - 1) < 0) {
            return false;
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin) ||
                        checkLine(i, j, 1, 0, dot, dotsToWin) ||
                        checkLine(i, j, 1, 1, dot, dotsToWin) ||
                        checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }


}
