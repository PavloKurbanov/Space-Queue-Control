package ConsoleUI;

import Entities.Passenger;
import Entities.TicketType;
import Service.BoardingService;

import java.util.Scanner;

public class ConsoleUI {
    private final BoardingService service;
    private final Scanner scanner;

    public ConsoleUI(BoardingService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while(true) {
            System.out.println("\n--- КЕРУВАННЯ КОСМОПОРТОМ ---");
            System.out.println("1) Зареєструвати пасажира");
            System.out.println("2) Порахувати загальну вагу на кораблі");
            System.out.println("3) Загальний дохід від польоту");
            System.out.println("4) Показати список усіх пасажирів");
            System.out.println("0) Вийти");
            System.out.print("Виберіть опцію: ");
            switch (this.scanner.nextLine()) {
                case "1":
                    this.handleRegisterPassenger();
                    break;
                case "2":
                    System.out.println("Загальна вага на борту: " + this.service.calculateTotalWeight() + " кг.");
                    break;
                case "3":
                    System.out.println("Загальна вартість квитків: " + this.service.calculateTotalIncome() + " USD.");
                    break;
                case "4":
                    this.printPassengers(this.service.findAllPassengers());
                    break;
                case "0":
                    System.out.println("Програма завершена. Вдалого польоту!");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private void handleRegisterPassenger() {
        try {
            System.out.print("Введіть ім'я пасажира: ");
            String name = this.scanner.nextLine();
            System.out.print("Введіть вагу (кг): ");
            int weight = Integer.parseInt(this.scanner.nextLine());
            System.out.println("Виберіть тип квитка: 1) ECONOMY, 2) BUSINESS, 3) VIP");
            int typeChoice = Integer.parseInt(this.scanner.nextLine());
            TicketType type;
            switch (typeChoice) {
                case 1:
                    type = TicketType.ECONOMY;
                    break;
                case 2:
                    type = TicketType.BUSINESS;
                    break;
                case 3:
                    type = TicketType.VIP;
                    break;
                default:
                    System.out.println("Невірний тип. Призначено ECONOMY.");
                    type = TicketType.ECONOMY;
            }

            Passenger registered = this.service.registerPassenger(0, name, weight, type);
            System.out.println("Успішно зареєстровано: " + String.valueOf(registered));
        } catch (NoSeatsException e) {
            System.err.println("ПОМИЛКА РЕЄСТРАЦІЇ: " + e.getMessage());
        } catch (OverweightException e) {
            System.err.println("ПОМИЛКА ВАГИ: " + e.getMessage());
        } catch (NumberFormatException var8) {
            System.err.println("ПОМИЛКА: Введіть числове значення для ваги або типу квитка.");
        }

    }

    private void printPassengers(Passenger[] passengers) {
        if (passengers.length == 0) {
            System.out.println("На борту поки що немає пасажирів.");
        } else {
            System.out.println("Список пасажирів:");

            for(Passenger p : passengers) {
                System.out.println(p);
            }

        }
    }
}
