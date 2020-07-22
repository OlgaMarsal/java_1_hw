public class MainHW2 {
    public static void main(String[] args) {
        System.out.println("HW2");
        System.out.println("Задание 1.");
        changeArray1();
        System.out.println("\n\nЗадание 2.");
        createArray1();
        System.out.println("\n\nЗадание 3.");
        changeArray2();
        System.out.println("\n\nЗадание 4.");
        createArray2();
    }

    static void changeArray1() {
        int[] arr = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("ДО: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.print("\nПОСЛЕ:  ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void createArray1() {
        int[] arr = new int[8];

        for (int i = 0, n = 0; i < arr.length; i++, n += 3) {
            arr[i] = n;
            System.out.print(arr[i] + " ");
        }
    }

    static void changeArray2() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.print("ДО: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.print("\nПОСЛЕ:  ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
            System.out.print(arr[i] + " ");
        }
    }

    static void createArray2() {
        int length = 5;

        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int n = 0; n < length; n++) {
                if ((i == n) || (i == length - 1 - n)) {
                    arr[i][n] = 1;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int n = 0; n < length; n++) {
                System.out.print(arr[i][n] + " ");
            }
            System.out.println();
        }
    }
}