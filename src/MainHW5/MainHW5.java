package MainHW5;

public class MainHW5 {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Иванов Иван Иванович", "Директор", "IvanovII@company.ru", "999-99-99", 2000000, 45);
        employeesArray[1] = new Employee("Васильева Василиса Васильевна", "Бухглатер", "VasilevaVV@company.ru", "999-99-98", 50000, 35);
        employeesArray[2] = new Employee("Окунев Окунь Окуневич", "Дизайнер", "OkunevOO@company.ru", "999-99-97", 150000, 21);
        employeesArray[3] = new Employee("Зубов Зуб Зубович", "Охранник", "ZubovZZ@company.ru", "999-99-96", 30000, 65);
        employeesArray[4] = new Employee("Потрясающая Потряс Потрясовна", "Заместитель", "PotryasaushayaPP@company.ru", "999-99-98", 50000, 36);

        for (Employee x : employeesArray) if (x.Возраст() > 40) x.info();
        }
    }

