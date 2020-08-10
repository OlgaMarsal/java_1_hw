package mainHW7;

public class MainHW7 {
    public static void main(String[] args) {
        System.out.println("List of cats:");
        Cat[] x = {new Cat("Murzik", 7), new Cat("Marsik", 5), new Cat("Barsik", 15)};
        Plate plate = new Plate(100);
        for (Cat c : x) {
            System.out.println(c);
        }
        System.out.println("\n" + plate);
        System.out.println("___");
        System.out.println("increase food by 100");
        plate.increaseFood(100);
        System.out.println(plate);
        System.out.println("___");
        System.out.println("Cats take food:");
        for (Cat c : x) {
            c.eat(plate);
            System.out.println(c);
            System.out.println(plate);
        }
    }
}
