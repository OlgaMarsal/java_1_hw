package mainHW6;

public class MainHW6 {
    public static void main(String[] args) {
        Cat cat = new Cat() {
            @Override
            void swim(int length) {

            }
        };
        cat.run(201);

        Dog dog = new Dog();
        dog.run(500);
        dog.swim(10);
    }
}

