package mainHW6;

abstract class Cat extends Animal {
    private final int maxRunLength = 200;

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= maxRunLength)) {
            System.out.println("run: true");
        } else {
            System.out.println("run: false");
        }
    }
}