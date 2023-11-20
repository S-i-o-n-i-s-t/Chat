package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Привет", "Мир", "!", "Кирилл", "!");

        list.stream().filter(str -> str.length() > 4).filter(str -> str.contains("К")).forEach(System.out::println);

        Arrays.asList(1,10,3,7,5,1,10,3,7,5).stream().sorted().distinct().map(itemm -> "Число - " + itemm + ". Квадрат числа - " + itemm * itemm + ".").forEach(System.out::println);
    }
}
