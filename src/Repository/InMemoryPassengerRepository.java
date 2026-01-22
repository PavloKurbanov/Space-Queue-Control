package Repository;

import Entities.Passenger;
import Entities.TicketType;

import java.util.Arrays;
import java.util.function.Predicate;

public class InMemoryPassengerRepository implements PassengerRepository {
    private static final int CAPACITY = 5;
    private static final int RESIZE_FACTORY = 2;
    private Passenger[] passengers = new Passenger[5];
    private int passengerCount;
    private int passengerId = 1;

    public Passenger save(Passenger passenger) {
        if (this.passengerCount == this.passengers.length) {
            this.passengers = (Passenger[]) Arrays.copyOf(this.passengers, this.passengers.length * 2);
        }

        passenger.setId(this.passengerId++);
        this.passengers[this.passengerCount++] = passenger;
        return passenger;
    }

    public Passenger[] findAll() {
        return (Passenger[])Arrays.copyOf(this.passengers, this.passengerCount);
    }

    public Passenger findById(int id) {
        for(int i = 0; i < this.passengerCount; ++i) {
            if (this.passengers[i].getId() == id) {
                return this.passengers[i];
            }
        }

        return null;
    }

    public Passenger[] findByType(TicketType type) {
        return this.result((passenger) -> passenger.getType() == type);
    }

    private Passenger[] result(Predicate<Passenger> passengerPredicate) {
        int count = 0;

        for(int i = 0; i < this.passengerCount; ++i) {
            if (passengerPredicate.test(this.passengers[i])) {
                ++count;
            }
        }

        Passenger[] predicate = new Passenger[count];
        int index = 0;

        for(int i = 0; i < this.passengerCount; ++i) {
            if (passengerPredicate.test(this.passengers[i])) {
                predicate[index++] = this.passengers[i];
            }
        }

        return predicate;
    }
}
