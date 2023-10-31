package dz;

public class Main
    // Создать справочник сотрудников
    // Необходимо:
    // Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
    // Табельный номер
    // Номер телефона
    // Имя
    // Стаж
    // Добавить метод, который ищет сотрудника по стажу (может быть список)
    // Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    // Добавить метод, который ищет сотрудника по табельному номеру
    // Добавить метод добавление нового сотрудника в справочник
{
    public static void main(String[] args)throws Exception{
        Employee employee = new Employee();
        // Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
        employee.createListEmployee();
//        for (Employee item: employee.getListEmployee()) {
//            System.out.println(item);
//        }
        System.out.println("_________________________");
        // Добавить метод, который ищет сотрудника по стажу (может быть список)
        // employee.searchExperience(3);
            for (Employee item: employee.searchExperience(3)) {
                System.out.println(item);
            }
        System.out.println("_________________________");
        // Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
        employee.searchPchoneNumber("Елена");
        for (Integer item: employee.getListPhoneNumber()) {
            System.out.println(item);
        }
        System.out.println("_________________________");
        // Добавить метод, который ищет сотрудника по табельному номеру
        System.out.println(employee.searchId(5));
        System.out.println("_________________________");
        // Добавить метод добавление нового сотрудника в справочник
        employee.addEmployee();
//        for (Employee item: employee.getListEmployee()) {
//            System.out.println(item);
//        }
    }
}