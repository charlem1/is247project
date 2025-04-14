import Models.Customer;
import Models.RegularCustomer;
import Models.VIPCustomer;
import Services.CheckInService;
import Utils.ClubException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckInService checkInService = new CheckInService();

        System.out.println("Welcome to Club 6! - " + new Date());
        System.out.println("Enter your name;");
        String name = scanner.nextLine();

        System.out.println("Enter your age:");
        int age = scanner.nextLine();

        Customer customer;
        if (age >= 21) {
            customer = new VIPCustomer(name, age);
        } else {
            customer = new RegularCustomer(name, age);
        }

        System.out.println("Your entry number: " + (new Random().nextInt(100) + 1));

        checkInService.checkInCustomer(customer);

        System.out.println("Do you want to check out? (yes/no)");
        scanner.nextLine();
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            try {
                checkInService.checkOutCustomer(customer);
            } catch (ClubException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
