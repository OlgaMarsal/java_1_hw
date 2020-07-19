public class MainHW {
    public static void main(String[] args) {

        System.out.println("Задание 2. Переменные");
        int year = 2020;
        short y = 16;
        long l = 6464L;
        float f = 0.32f;
        double g = 320.32;
        boolean tf = true;
        char c1 = 'r';
        String st = "Ольга";

        System.out.println("int = " + year);
        System.out.println("short = " + y);
        System.out.println("long = " + l);
        System.out.println("float = " + f);
        System.out.println("double = " + g);
        System.out.println("char = " + c1);
        System.out.println("string = " + st);

        int n = 8;
        int m = 9;

        float a = 2;
        float b = 4;
        float c = 6;
        float d = 8;

        float v = r3(a, b, c, d);

        float r = (c / d);

        r = a * (b + (c / d));
        System.out.println("r=" + r);

        System.out.println(r4(n, m));

        r5(n);

        System.out.println(r6(n));

        r7(st);

        r8(year);
    }

    public static float r3(float a, float b, float c, float d) {
        System.out.println("\nЗадание 3.");
        return (b + (c / d));
    }

    public static boolean r4(int n, int m) {
        System.out.println("\nЗадание 4.");
        int sum = n + m;
        if (sum >= 10 && sum <= 20) {
            return true;
         } else {
            return false;
        }
    }

    public static void r5(int n){
        System.out.println("\nЗадание 5.");
        if (n >= 0) {
            System.out.println("Число " + n + " положительное");
        }
        else {
            System.out.println("Число " + n + " отрицательное");
        }
    }

    public static boolean r6(int n) {
        System.out.println("\nЗадание 6.");
        if (n < 0) {return true;}
        {return false;}
    }

    public static void r7(String name) {
        System.out.println("\nЗадание 7.");
        System.out.println("Привет, " + name + "!");
    }

    public static void r8(int year) {
        System.out.println("\nЗадание 8.");
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) System.out.println(year + " г. не високосный");
        else System.out.println(year + " г. високосный");
    }
}