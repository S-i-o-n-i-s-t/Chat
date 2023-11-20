package org.example;

import java.util.Random;

public class Conditions {
    /**
     * Количество "дверей"
     */
    private final int numberDoors = 3;

    /**
     * Метод выбора двери
     * @return Указывает какую дверь выбрать
     */
    public int playerBet(){
        Random random = new Random();
        return random.nextInt(0, numberDoors);
    }

    /**
     * @return Геттер
     */
    public int getNumberDoors() {
        return numberDoors;
    }
}
