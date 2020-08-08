package mainHW6;

class Dog extends Animal {
    private final int maxRunLength = 500;
    private final int maxSwimLength = 10;


    @Override
    void run(int length) {
        if ((length >= 0) && (length <= maxRunLength)) {
            System.out.println("run: true");
        }
    }

    @Override
    void swim(int length) {
        if ((length >= 0) && (length <= maxSwimLength)) {
            System.out.println("swim: true");
        } else {
            System.out.println("swim: false");
        }
    }

}