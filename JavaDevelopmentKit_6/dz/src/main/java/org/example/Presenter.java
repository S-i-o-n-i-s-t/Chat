package org.example;

import java.util.ArrayList;
import java.util.List;

public class Presenter extends Conditions{
    /**
     * список дверей
     */
    private List<Door> doorList;

    /**
     * @return "Геттер"
     */
    public List<Door> getDoorList() {
        return doorList;
    }
    // region методы
    /**
     * Ведущий подготавливает двери для игры, и прячет за одной из них выигрыш
     */
    public void createDoors(){
        int winning = playerBet();
        doorList = new ArrayList<>();
        for (int i = 0; i < getNumberDoors(); i++){
            if (i == winning){
                doorList.add(new  Door(true));
//                System.out.println("Выигрыш за дверью номер - " + i);
            }
            else {
                doorList.add(new  Door(false));
            }
        }
    }

    /**
     * Ведущий "открывает" указанную дверь
     * @param numDoor открытие двери
     */
    public void openDoor(int numDoor){
        doorList.get(numDoor).setConditionDoor(true);
    }
    // endregion
}
