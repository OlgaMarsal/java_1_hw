import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.lang.Math;


public class MainHW3 {

    public static void main(String[] args) {
        System.out.println("HW3");
        GuessNumber();
    }

    public static void GuessNumber(){
        Scanner in = new Scanner(System.in);

        int a, n = (int)(Math.random()*10);
        System.out.println("Угадайте число от 0 до 9, у Вас есть 3 попытки.");
        for (int i = 0; i < 3; i++){
            System.out.println("Попытка " + (i+1) + ": ");
            a = in.nextInt();
            if (a < n) System.out.println("Число больше!");
            if (a > n) System.out.println("Число меньше!");
            if (a == n) {System.out.println("Вы угадали!");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                a = in.nextInt();
                if (a == 1) GuessNumber();
                else {System.out.println("Спасибо за игру!");
                    break;
                }
            }
        }

        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        a = in.nextInt();
        if (a == 1) GuessNumber();
        else {System.out.println("Спасибо за игру!");
        }
    }
}


