package org.example;

import java.util.HashMap;
import java.util.Set;

//        Создать свой Java Maven или Gradle проект;
//        Самостоятельно реализовать прикладную задачу;
//        Сохранить результат в HashMap<шаг теста, результат>
//        Вывести на экран статистику по победам и поражениям
        // автомобиль равновероятно размещён за любой из трёх дверей;
        // ведущий знает, где находится автомобиль;
        // ведущий в любом случае обязан открыть дверь с козой (но не ту, которую выбрал игрок) и предложить игроку изменить выбор;
        // если у ведущего есть выбор, какую из двух дверей открыть (то есть, игрок указал на верную дверь, и за обеими оставшимися дверями — козы), он выбирает любую из них с одинаковой вероятностью.
public class Main {
    public static void main(String[] args) {
//        Game game = new Game();
//        int item = 1;
//        for (int i = 0; i < 10; i++){
//            game.round1();
//            game.round2();
//            if (game.round3()){
//                System.out.println("Урааа!!! Победааа!!! номер - " + item);
//                item++;
//                System.out.println("");
//            }
//            else {
//                System.out.println("(((((((((((((((((((((((((((( - ");
//                System.out.println("");
//            }
//
//        }
        Statistics statistics = new Statistics();
        statistics.startGames();
        System.out.println(statistics.statisticGames());

    }
}























