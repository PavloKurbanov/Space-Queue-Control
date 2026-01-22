import ConsoleUI.ConsoleUI;
import Entities.SpaceShip;
import Repository.InMemoryPassengerRepository;
import Repository.PassengerRepository;
import Service.BoardingService;
import Service.DefaultBoarding;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    PassengerRepository repository = new InMemoryPassengerRepository();
    BoardingService service = new DefaultBoarding(repository, new SpaceShip("Корабель", 2, 200));
    ConsoleUI consoleUI = new ConsoleUI(service);
    consoleUI.run();
}
