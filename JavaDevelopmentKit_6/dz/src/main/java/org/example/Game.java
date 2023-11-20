package org.example;

public class Game {
    //region Поля
    private Player player = new Player();
    private Presenter presenter = new Presenter();
    //endregion
    // region Методы
    /**
     * "Раудн 1"
     * "Ведущий" создает список дверей для игры
     * Игрок делает ставку на "нужную" дверь
     */
    public void round1(){
        presenter.createDoors();
        presenter.openDoor(player.getNumberDoors());
    }

    /**
     * "Раудн 2" - "Ведущий" "открывает" одну из оставшихся дверей, за которой нет выигрыша
     */
    public void round2(){
        int bet = presenter.playerBet();
        while (bet == player.getNumberDoors() || presenter.getDoorList().get(bet).isObject()){
            bet = presenter.playerBet();
        }
        presenter.openDoor(bet);
    }

    /**
     * Проверяем, есть ли выигрыш за оставшейся, закрытой дверью
     * @return результат того, победил, или проиграл "игрок" при условии что он поменяет изначальное решение
     */
    public boolean round3(){
        for (Door item: presenter.getDoorList()) {
//            System.out.println("Открытие двери - " + item.isConditionDoor());
//            System.out.println("Есть ли выигрыш - " + item.isObject());
            if (!item.isConditionDoor() && item.isObject()){
                return true;

            }
        }
        return false;
    }
    // endregion
}
