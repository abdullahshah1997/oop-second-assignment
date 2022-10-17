import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv in namn eller personnummer för att veta status för medlemskap.");
        String input = scan.nextLine();
        CustomerChecker customerChecker = new CustomerChecker();
        customerChecker.customerInfo("src/customers.txt",input);
    }
}
