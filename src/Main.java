import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean runner = true;
        String customerData = "";
        File file = new File("src/customerVisits.txt");
        PrintWriter outstream = new PrintWriter(new BufferedWriter(new FileWriter("customerVisits.txt")));
        while(runner) {
            System.out.println("Skriv in namn eller personnummer för att veta status för medlemskap. " +
                    "Mata in x för att avsluta");
            String input = scan.nextLine();
            CustomerChecker customerChecker = new CustomerChecker();
            System.out.println(customerChecker.customerInfo("src/customers.txt", input.trim())[0]);
            if(customerChecker.customerInfo("src/customers.txt", input.trim())[0].equals(
                    "Personen är en nuvarande medlem.")){
                customerData+=customerChecker.customerInfo("src/customers.txt", input.trim())[1];
            }
            if(input.trim().equalsIgnoreCase("x")){
                break;
            }
        }
        outstream.print(customerData);
        outstream.close();
        }
    }
