package org.example;

public class Door {
    //region Переменные
    // Переменная наличия vs отсутствия выигрыша
    private final boolean object;
    // Переменная состояния - открыто/закрыто
    private boolean conditionDoor;
    //endregion
    // region Конструктор,геттеры, сеттеры
    public Door(boolean object) {
        this.object = object;
    }

    public boolean isObject() {
        return object;
    }
    public boolean isConditionDoor() {
        return conditionDoor;
    }
    /**
     * Метод "открыть/закрыть" дверь
     * @param conditionDoor Состояние в котором находится дверь
     */
    public void setConditionDoor(boolean conditionDoor) {
        this.conditionDoor = conditionDoor;
    }
    // endregion
}
