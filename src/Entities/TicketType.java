package Entities;

public enum TicketType {
    ECONOMY("Економ", 1000),
    BUSINESS("Бізнес", 5000),
    VIP("VIP", 10000);

    private final String type;
    private final int price;

    private TicketType(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }
}
