package org.example;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    //region Поля
    /**
     * Поле класса, для хранения информации о статистике игр
     */
    private Map<Integer, Integer> presenterMap = new HashMap<>();
    /**
     * Количество игр
     */
    private final int numberGame = 1000;
    // endregion
    // region Методы
    /**
     * Метод запуска серии игр
     */
    public void startGames(){
        for (int i = 0; i < numberGame; i++){
            Game game = new Game();
            game.round1();
            game.round2();
            if (game.round3()){
                presenterMap.put(i, 1);
            }
            else {
                presenterMap.put(i, 0);
            }
        }
    }
    /**
     * Метод для подсчета количества выигрышей, при условии, что игрок "поменял решение"
     * @return Результат
     */
    public int statisticGames(){
        return presenterMap.values().stream().mapToInt(Integer::valueOf).sum();
    }
    // endregion
}
