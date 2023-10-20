package task3;

public class Main {
    // Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
    // Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
    // а также переопределение метода toString(), возвращающее строковое представление пары.
    public static void main(String[] args) {
        Cat cat = new Cat();
        Pair<Cat, Integer> pair = new Pair<>(cat, 12);
        System.out.println(pair);
        System.out.println(pair.getFirst());
    }
}