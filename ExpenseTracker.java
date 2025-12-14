import java.util.*;

class Expense extends ListITMain { // Inherits from ListITMain (if required by your project)
    private String name; // Name of the expense (e.g., Burger)
    private String category; // Category of expense (Food, Bills, etc.)
    private double price; // Amount spent
    private String date; // Date of expense (yyyy-mm-dd)

    public Expense(String name, String category, double price, String date) {
        this.name = name; // Assign expense name
        this.category = category; // Assign category
        this.price = price; // Assign price
        this.date = date; // Assign date
    }

    // getter methhods
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return name + " | " + category + " | Php" + String.format("%.2f", price) + " | " + date;
    }
}

public class ExpenseTracker {

    private static ArrayList<Expense> expenses = new ArrayList<>(); // Stores all expenses
    private static double monthlyBudget = 0.0; // User's monthly budge
    private static Scanner sc = new Scanner(System.in);

    // =============================
    //              MAIN
    // =============================
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== HOME =========="); // Home Menu
            System.out.println("1. Manage Expenses");
            System.out.println("2. Exit Program");
            System.out.print("Enter choice: ");

            int homeChoice;

            try {
                homeChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input."); // If input is not a number
                continue;
            }

            if (homeChoice == 1) {
                manageExpenses(); // go to expense menu
            } else if (homeChoice == 2) {
                System.out.println("Exiting program..."); // exit message
                break;
            } else {
                System.out.println("Invalid choice."); // wrong option
            }
        }
    }

    // =============================
    //           MAIN MENU
    // =============================
    public static void manageExpenses() {

        System.out.print("\nEnter your monthly budget: Php");
        try {
            monthlyBudget = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Budget set to Php0.00.");
            monthlyBudget = 0; // default budget
        }

        while (true) {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Sort Expenses");
            System.out.println("4. View Totals per Category");
            System.out.println("5. Show Remaining Budget");
            System.out.println("6. Back to Home");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1 -> addExpense(); // Add new expense
                case 2 -> viewExpenses(); // Show all expenses
                case 3 -> sortExpenses(); // Sort expenses
                case 4 -> categoryTotals(); // Show totals per category
                case 5 -> remainingBudget(); // Go back to home
                case 6 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // =============================
    //         ADD EXPENSE
    // =============================
    private static void addExpense() {
        System.out.print("Enter expense name: "); //Nagastos mo
        String name = sc.nextLine();

        System.out.println("\nSelect Category:"); 
        System.out.println("1. Food");
        System.out.println("2. Household");
        System.out.println("3. Personal Care");
        System.out.println("4. Bills");
        System.out.print("Enter: ");

        int c;
        try {
            c = Integer.parseInt(sc.nextLine()); // Read Category choice
        } catch (NumberFormatException e) {
            c = 0; // default if invalid
        }

        String category = switch (c) {
            case 1 -> "Food";
            case 2 -> "Household";
            case 3 -> "Personal Care";
            case 4 -> "Bills";
            default -> "Other";
        };

        System.out.print("Enter price: Php"); 
        double price;
        try {
            price = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price. Set to Php0.00.");
            price = 0;
        }

        System.out.print("Enter date (yyyy-mm-dd): ");
        String date = sc.nextLine();

        expenses.add(new Expense(name, category, price, date)); // Save expense
        System.out.println("Expense added successfully!"); // confirmation
    }

    // =============================
    //        VIEW EXPENSES
    // =============================
    private static void viewExpenses() {
        if (expenses.isEmpty()) { // check if list is empty
            System.out.println("\nNo expenses recorded yet.");
            return;
        }

        System.out.println("\n===== ALL EXPENSES =====");
        for (int i = 0; i < expenses.size(); i++) { // loop through expenses
            System.out.println((i + 1) + ". " + expenses.get(i)); 
        }
    }

    // =============================
    //         SORT EXPENSES
    // =============================
    private static void sortExpenses() {
        System.out.println("\nSort by:");
        System.out.println("1. Item Name");
        System.out.println("2. Category");
        System.out.println("3. Price");
        System.out.println("4. Date Purchased");
        System.out.print("Enter: ");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine()); // read sort choice
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        switch (choice) {
            case 1 -> expenses.sort(Comparator.comparing(Expense::getName));
            case 2 -> expenses.sort(Comparator.comparing(Expense::getCategory));
            case 3 -> expenses.sort(Comparator.comparingDouble(Expense::getPrice));
            case 4 -> expenses.sort(Comparator.comparing(Expense::getDate));
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("Sorted successfully!");
        viewExpenses();
    }

    // =============================
    //     TOTAL PER CATEGORY
    // =============================
    private static void categoryTotals() {
        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses found.");
            return;
        }

        Map<String, Double> totals = new HashMap<>(); // Stores totals per category

        for (Expense e : expenses) { // loop each expense
            totals.put(e.getCategory(), totals.getOrDefault(e.getCategory(), 0.0) + e.getPrice());
        }

        System.out.println("\n===== CATEGORY TOTALS =====");
        for (String cat : totals.keySet()) { // display totals
            System.out.println(cat + ": Php" + String.format("%.2f", totals.get(cat)));
        }
    }

    // =============================
    //      REMAINING BUDGET
    // =============================
    private static void remainingBudget() {
        double spent = 0;

        for (Expense e : expenses) { // Add all prices
            spent += e.getPrice();
        }

        double remaining = monthlyBudget - spent; //Compute remaining budget

        System.out.println("\n===== BUDGET STATUS =====");
        System.out.println("Monthly Budget: Php" + monthlyBudget);
        System.out.println("Total Spent:    Php" + String.format("%.2f", spent));
        System.out.println("Remaining:      Php" + String.format("%.2f", remaining));
    }
}
