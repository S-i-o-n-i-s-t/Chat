package task2;

    // Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
    // и false в противном случае. Массивы могут быть любого типа данных,
    // но должны иметь одинаковую длину и содержать элементы одного типа.

public class Task2 {
    public static void main(String[] args) {
        String[] massiv1 = {"1", "2", "3"};
        String[] massiv2 = {"1", "2", "3"};
        Number[] massiv3 = {1, 2, 3};
        System.out.println(CompareArrays.compareArrays(massiv1, massiv2));
        System.out.println(CompareArrays.compareArrays(massiv3, massiv1));
    }
}
