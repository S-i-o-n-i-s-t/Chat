package dz;

import java.util.*;

public class Employee {
    // region Переменные
    // Количество сотрудников
    private final int QUANTITY  = 100;
    // Табельный номер
    private int id;
    // Номер телефона
    private int phoneNumber;
    // Имя
    private String name;
    // Стаж
    private int experience;
    private List<Integer> listPhoneNumber;
    private final String[] COLLECTION_NAME = {"Василий", "Петр", "Елена", "Ольга", "Вятчеслав", "Томара", "Максим", "Иван", "Надежда", "Владимир"};
    Random random = new Random();
    private final List<Employee> listEmployee = new ArrayList<>();
    // endregion
    // region Геттеры
    public int getId() {
        return id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
    public List<Employee> getListEmployee() {
        return listEmployee;
    }
    public List<Integer> getListPhoneNumber() {
        return listPhoneNumber;
    }

    //endregion
    // region Конструктор
    public void autoCreatePhoneNumber() {
        phoneNumber = random.nextInt(10000, 99999);
    }

    public void autoCreateName() {
        name = COLLECTION_NAME[random.nextInt(0, COLLECTION_NAME.length)];
    }

    public void autoCreateStartDate() {
        experience = random.nextInt(0, COLLECTION_NAME.length);
    }
    public Employee() {
    }
    public Employee(int id) {
        this.id = id;
        autoCreatePhoneNumber();
        autoCreateName();
        autoCreateStartDate();
    }
    // endregion
    // Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
    public void createListEmployee(){
        for (int i = 0; i < QUANTITY; i++){
            addEmployee();
        }
    }
    // Добавить метод, который ищет сотрудника по стажу (может быть список)
    public List<Employee> searchExperience(int search){
        List<Employee> listSort = new ArrayList<>();
        for (Employee item: listEmployee) {
            if (item.getExperience() == search){
                listSort.add(item);
            }
        }
        return listSort;
    }
    // Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    public void searchPchoneNumber(String name){
        listPhoneNumber = new ArrayList<>();
        for (Employee item: listEmployee) {
            if (item.getName().equals(name)){
                listPhoneNumber.add(item.getPhoneNumber());
            }
        }
    }

    // Добавить метод, который ищет сотрудника по табельному номеру
    public Employee searchId(int id){
        for (Employee item: listEmployee) {
            if (item.getId() == id){
                return item;
            }
        }return null;
    }

    // Добавить метод добавление нового сотрудника в справочник
    public void addEmployee(){
        listEmployee.add(new  Employee(listEmployee.size()+1));
    }



    @Override
    public String toString() {
        return "{" +
                "id = " + id +
                ", Experience = " + phoneNumber +
                ", name = '" + name + '\'' +
                ", startDate = " + experience +
                '}';
    }
}
