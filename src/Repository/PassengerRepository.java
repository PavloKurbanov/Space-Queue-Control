package Repository;

import Entities.Passenger;
import Entities.TicketType;

public interface PassengerRepository {
    Passenger save(Passenger var1);

    Passenger[] findAll();

    Passenger findById(int var1);

    Passenger[] findByType(TicketType var1);
}
