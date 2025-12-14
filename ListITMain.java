import java.util.Scanner; // Import Scanner for user input

public class ListITMain {

    // Scanner object used to read input from the user
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Infinite loop to keep showing the welcome screen
        while (true) {   
            // Display welcome banner
            System.out.println("=".repeat(100));
            System.out.println("\tGood Day! Welcome to ListIT, where you can List it, Track it, and Budget it!");
            System.out.println("\t               Start tracking your expenses today and remember,");
            System.out.println("\t\"A budget is telling your money where to go instead of wondering where it went.\"");
            System.out.println("=".repeat(100));

            // Ask the user if they want to start the program
            System.out.print("\nWant to start tracking your expenses and make a shopping list? \nEnter 1 if YES and 2 if NO: ");
            String answer = sc.nextLine(); // Read user input

            // If the user chooses YES
            if (answer.equals("1")) {
                System.out.printf("\nLet me know first what I should call you.");
                System.out.print("\nEnter your nickname: ");
                String name = sc.nextLine(); // Get user's nickname

                // Display greeting message
                System.out.println("\nGreat! Hello, " + name + ". Let's start to list it, track it, and budget it!\n");

                // MAIN MENU LOOP
                while (true) {
                    // Display main menu options
                    System.out.println("\n===== MAIN MENU =====");
                    System.out.println("1. Shopping List");
                    System.out.println("2. Expense Tracker");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");

                    int choice;

                    // Try-catch to handle invalid (non-numeric) input
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Enter a number.");
                        continue; // Return to the menu
                    }

                    // Perform action based on user choice
                    switch (choice) {
                        case 1:
                            // Open the Shopping List module
                            ShopList.manageShoppingList(sc); // Connected to ShopList class
                            break;

                        case 2:
                            // Open the Expense Tracker module
                            ExpenseTracker.manageExpenses(); // Connected to ExpenseTracker class
                            break;

                        case 3:
                            // Exit the program
                            System.out.println("\nThank you for using ListIT! Goodbye!");
                            return;

                        default:
                            // Handle invalid menu choice
                            System.out.println("Invalid choice. Try again.");
                    }
                }

            } else {
                // If the user chooses NO
                System.out.println("\nOh :( okay, bye. Have a good day!");
                return; // End the program
            }

        }

    }
}
