package task1;
    //Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
    // Параметры этих методов – два числа разного типа (но необязательно разного между собой), над которыми должна быть произведена операция.
public class Сalculator {
        public static <T extends Number, V extends Number> Number sum(T num1, V num2){
        return num1.doubleValue() + num2.doubleValue();
    }
    public static <T extends Number, V extends Number> Number multiply(T num1, V num2){
        return num1.doubleValue() * num2.doubleValue();
    }
    public static <T extends Number, V extends Number> Number divide(T num1, V num2){
        if (num2.doubleValue() != 0) {
            return num1.doubleValue() / num2.doubleValue();
        }
        return null;
    }
    public static <T extends Number, V extends Number> Number subtract(T num1, V num2){
        return num1.doubleValue() - num2.doubleValue();
    }
}
