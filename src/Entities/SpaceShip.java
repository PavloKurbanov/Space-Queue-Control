package Entities;

public class SpaceShip {
    private final String name;
    private final int maxSeats;
    private final int maxWeightCapacity;

    public SpaceShip(String name, int maxSeats, int maxWeightCapacity) {
        this.name = name;
        this.maxSeats = maxSeats;
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxSeats() {
        return this.maxSeats;
    }

    public int getMaxWeightCapacity() {
        return this.maxWeightCapacity;
    }

    public String toString() {
        return String.format("Корабель: %-5s | Максимальна вмісткість: %-5d | Вага: %-5d", this.name, this.maxSeats, this.maxWeightCapacity);
    }
}
