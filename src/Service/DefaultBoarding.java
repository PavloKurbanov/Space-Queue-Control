package Service;

import Entities.Passenger;
import Entities.SpaceShip;
import Entities.TicketType;
import Repository.PassengerRepository;

public class DefaultBoarding implements BoardingService {
    private final PassengerRepository passengerRepository;
    private final SpaceShip spaceShip;

    public DefaultBoarding(PassengerRepository repository, SpaceShip ship) {
        this.passengerRepository = repository;
        this.spaceShip = ship;
    }

    public SpaceShip registerSpace(String name, int maxSeats, int maxWeightCapacity) {
        return new SpaceShip(name, maxSeats, maxWeightCapacity);
    }

    public Passenger registerPassenger(int id, String name, int weight, TicketType type) {
        int total = this.passengerRepository.findAll().length;
        if (total >= this.spaceShip.getMaxSeats()) {
            throw new NoSeatsException("На кораблі " + this.spaceShip.getName() + " не має місця");
        } else if (this.calculateTotalWeight() + (double)weight > (double)this.spaceShip.getMaxWeightCapacity()) {
            throw new OverweightException("Перевантаження! Максимум:" + this.spaceShip.getMaxWeightCapacity());
        } else {
            Passenger newPassenger = new Passenger(id, name, weight, type);
            return this.passengerRepository.save(newPassenger);
        }
    }

    public double calculateTotalWeight() {
        Passenger[] passengers = this.passengerRepository.findAll();
        int total = 0;

        for(Passenger passenger : passengers) {
            total += passenger.getWeight();
        }

        return (double)total;
    }

    public double calculateTotalIncome() {
        Passenger[] passengers = this.passengerRepository.findAll();
        int price = 0;

        for(Passenger passenger : passengers) {
            price += passenger.getType().getPrice();
        }

        return (double)price;
    }

    public Passenger[] findAllPassengers() {
        return this.passengerRepository.findAll();
    }
}



