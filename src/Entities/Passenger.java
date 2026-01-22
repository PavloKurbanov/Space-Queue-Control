package Entities;

public class Passenger {
    private int id;
    private final String name;
    private final int weight;
    private TicketType type;

    public Passenger(int id, String name, int weight, TicketType type) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public TicketType getType() {
        return this.type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public String toString() {
        return String.format("ID: %-3d | Ім'я: %-5s | Вага: %-5s | Тип: %-6s | Вартість: %-5d", this.id, this.name, this.weight, this.type.getType(), this.type.getPrice());
    }
}
