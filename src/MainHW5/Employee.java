package MainHW5;

import java.sql.SQLOutput;

public class Employee {
    String ФИО;
    String Должность;
    String Email;
    String Телефон;
    int Зарплата;
    int Возраст;

    public Employee(String ФИО, String Должность, String Email, String Телефон, int Зарплата, int Возраст) {
        this.ФИО = ФИО;
        this.Должность = Должность;
        this.Email = Email;
        this.Телефон = Телефон;
        this.Зарплата = Зарплата;
        this.Возраст = Возраст;
    }

    void info(){
        System.out.printf("ФИО %s Должность %s Email %s Телефон %s Зарплата %s Возраст %d\n", ФИО, Должность, Email, Телефон, Зарплата, Возраст);
    }

    int Возраст() {
        return Возраст;
    }
}


