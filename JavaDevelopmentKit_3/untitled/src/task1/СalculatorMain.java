package task1;
    //Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
    // Параметры этих методов – два числа разного типа (но необязательно разного между собой), над которыми должна быть произведена операция.
public class СalculatorMain {
    public static void main(String[] args) {
        float fl = 1.5f;
        double dob = 3.5;
        System.out.println(Сalculator.sum(fl, dob));
        System.out.println(Сalculator.multiply(fl, dob));
        System.out.println(Сalculator.divide(fl, dob));
        System.out.println(Сalculator.subtract(fl, dob));
    }


}
