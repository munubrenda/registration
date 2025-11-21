import java.util.ArrayList;
import java.util.Scanner;

public class InteractiveConsoleRegistration {

    static class User {
        int id;
        String name;
        String mobile;
        String gender;
        String dob;
        String address;

        User(int id, String name, String mobile, String gender, String dob, String address) {
            this.id = id;
            this.name = name;
            this.mobile = mobile;
            this.gender = gender;
            this.dob = dob;
            this.address = address;
        }
    }

    static ArrayList<User> database = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Interactive Registration Console Form");

        while (true) {
            System.out.println("\n1. Fill Registration Form");
            System.out.println("2. View Saved Records");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = getInt();

            switch (choice) {
                case 1:
                    interactiveForm();
                    break;
                case 2:
                    showRecords();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void interactiveForm() {
        System.out.println("\n Registration Form");

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobile = input.nextLine();

        System.out.println("Select Gender:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.print("Enter choice: ");
        int genderChoice = getInt();
        String gender = (genderChoice == 1) ? "Male" : "Female";

        System.out.println("\n-Enter Date of Birth-");
        System.out.print("Day: ");
        int d = getInt();

        System.out.print("Month: ");
        int m = getInt();

        System.out.print("Year: ");
        int y = getInt();

        String dob = d + "-" + m + "-" + y;

        System.out.print("Enter Address: ");
        String address = input.nextLine();

        System.out.print("Accept Terms and Conditions?: ");
        String t = input.nextLine();

        if (!t.equalsIgnoreCase("Y")) {
            System.out.println("You must accept the terms to proceed.");
            return;
        }

        int id = database.size() + 1;
        User user = new User(id, name, mobile, gender, dob, address);
        database.add(user);

        System.out.println("Registration Successful!");
    }

    public static void showRecords() {
        if (database.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\n-Saved Records-");

        System.out.printf("%-5s %-15s %-10s %-12s %-15s %-20s\n",
                "ID", "Name", "Gender", "DOB", "Mobile", "Address");
        System.out.println("--------------------------------------------------------------------------");

        for (User u : database) {
            System.out.printf("%-5d %-15s %-10s %-12s %-15s %-20s\n",
                    u.id, u.name, u.gender, u.dob, u.mobile, u.address);
        }
    }

    public static int getInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}
