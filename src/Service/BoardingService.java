package Service;

import Entities.Passenger;
import Entities.SpaceShip;
import Entities.TicketType;

public interface BoardingService {
    SpaceShip registerSpace(String var1, int var2, int var3);

    Passenger registerPassenger(int var1, String var2, int var3, TicketType var4);

    double calculateTotalWeight();

    double calculateTotalIncome();

    Passenger[] findAllPassengers();
}
