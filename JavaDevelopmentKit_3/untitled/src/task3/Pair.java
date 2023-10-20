package task3;
    // Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
    // Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
    // а также переопределение метода toString(), возвращающее строковое представление пары.

public class Pair <T, V>{
    private T type1;
    private V type2;

    public Pair(T type1, V type2) {
        this.type1 = type1;
        this.type2 = type2;
    }

    public T getFirst(){
        return type1;
    }
    public V getSecond(){
        return type2;
    }


    @Override
    public String toString() {
        return "type1 = " + type1 + "\n" +
                "type2 = " + type2;

    }
}
