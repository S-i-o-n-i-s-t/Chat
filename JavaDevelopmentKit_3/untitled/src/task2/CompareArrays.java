package task2;
    // Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
    // и false в противном случае. Массивы могут быть любого типа данных,
    // но должны иметь одинаковую длину и содержать элементы одного типа.
public class CompareArrays {
    public static  <T, V> boolean compareArrays(T[] massiv1, V[] massiv2){
        if (massiv1.length != massiv2.length){
            return false;
        }
        for (int i = 0; i < massiv1.length; i++){
            if (!massiv1[i].equals(massiv2[i])){
                return false;
            }
        }
        return true;
    }
}
