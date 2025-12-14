import java.util.ArrayList; // Import ArrayList to store shopping items
import java.util.Scanner;   // Import Scanner for user input

// ShopList class handles all shopping list operations
class ShopList extends ListITMain {

    // ArrayList to store Item objects
    private static ArrayList<Item> ShopList = new ArrayList<>();

    // Main menu for shopping list features
    public static void manageShoppingList(Scanner sc) {
        while (true) {
            // Display shopping list menu
            System.out.println("\nShopping List Options:");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Edit Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Summary");
            System.out.println("6. Back to Home");
            System.out.print("Enter your choice: ");

            int ListChoice = sc.nextInt(); // Read user choice
            sc.nextLine(); // Clear input buffer

            // Perform action based on user choice
            switch (ListChoice) {
                case 1:
                    addItem(sc); // Add a new item
                    break;
                case 2:
                    viewItems(); // View all items
                    break;
                case 3:
                    editItem(sc); // Edit an existing item
                    break;
                case 4:
                    deleteItem(sc); // Delete an item
                    break;
                case 5:
                    viewSummary(); // View shopping summary
                    break;
                case 6:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a new item to the shopping list
    private static void addItem(Scanner sc) {

        // Ask for item name
        System.out.print("Enter item name: ");
        String itemName = sc.nextLine();
    
        // Ask for quantity with validation
        int quantity = 0;
        while (true) {
            System.out.print("\nEnter quantity: ");
            try {
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity > 0) break;
                else
                    System.out.println("Quantity must be positive numbers.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for quantity.");
            }
        }

        // Ask for price with validation
        double price = 0;
        while (true) {
            System.out.print("Enter estimated price per item(e.g. 20.00): ");
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price >= 0) break;
                else System.out.println("Price cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for price.");
            }
        }
        
        // Create Item object and add it to the list
        Item item = new Item(itemName, quantity, price);
        ShopList.add(item);

        // Display confirmation message
        System.out.println("Item added: " + itemName + 
                           "\nQuantity: " + quantity + 
                           "\nPrice: " + price); 
    }

    // Method to display all items in the shopping list
    private static void viewItems() {
        if (ShopList.isEmpty()) {
            // If list is empty
            System.out.println("Your shopping list is empty.");
        } else {
            System.out.println("Your shopping list:");
            double totalCost = 0.0;

            // Loop through all items
            for (int i = 0; i < ShopList.size(); i++) {
                Item item = ShopList.get(i);
                double subtotal = item.getQuantity() * item.getPrice();
                totalCost += subtotal;

                // Display item details
                System.out.println((i + 1) + ". " + item.getItemName() +
                                   "\nQuantity: " + item.getQuantity() +
                                   "\nPrice: " + item.getPrice()); 
            }

            // Display total estimated cost
            System.out.println("Total Estimated Cost: " + totalCost); 
        }
    }

    // Method to edit an existing item
    private static void editItem(Scanner sc) {
        viewItems();

        // Stop if list is empty
        if (ShopList.isEmpty()) {
            return;
        }

        // Ask which item to edit
        System.out.print("Enter the number of the item to edit: ");
        try {
            int index = Integer.parseInt(sc.nextLine()) - 1; // Convert to 0-based index

            if (index >= 0 && index < ShopList.size()) {
                Item item = ShopList.get(index);
                System.out.println("Editing: " + item.getItemName());

                // Edit options
                System.out.println("What do you want to edit?");
                System.out.println("1. Name");
                System.out.println("2. Quantity");
                System.out.println("3. Price");
                System.out.print("Enter choice: ");

                int editChoice = sc.nextInt();
                sc.nextLine(); // Clear buffer

                switch (editChoice) {
                    case 1: 
                        // Edit item name
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        item.setItemName(newName);
                        break;

                    case 2:
                        // Edit item quantity
                        int newQuantity = 0;
                        while (true) {
                            System.out.print("Enter new quantity: ");
                            try {
                                newQuantity = Integer.parseInt(sc.nextLine());
                                if (newQuantity > 0) break;
                                else System.out.println("Quantity must be positive.");
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number.");
                            }
                        }
                        item.setQuantity(newQuantity);
                        break;

                    case 3:
                        // Edit item price
                        double newPrice = 0.0;
                        while (true) {
                            System.out.print("Enter new price: ");
                            try {
                                newPrice = Double.parseDouble(sc.nextLine());
                                if (newPrice >= 0) break;
                                else System.out.println("Price cannot be negative.");
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number.");
                            }
                        }
                        item.setPrice(newPrice);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        return;
                }

                // Confirm update
                System.out.println("Item updated.");

            } else {
                System.out.println("Invalid number.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Method to delete an item from the list
    private static void deleteItem(Scanner sc) {
        viewItems();

        // Stop if list is empty
        if (ShopList.isEmpty()) {
            return;
        }

        // Ask which item to delete
        System.out.print("Enter the number of item to delete: ");
        try {
            int index = Integer.parseInt(sc.nextLine()) - 1;

            if (index >= 0 && index < ShopList.size()) {
                Item removedItem = ShopList.remove(index);
                System.out.println("Item deleted: " + removedItem.getItemName());
            } else {
                System.out.println("Invalid number.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Method to show summary of shopping list
    private static void viewSummary() {
        int totalItems = 0;
        double totalCost = 0.0;

        // Calculate total quantity and cost
        for (Item item : ShopList) {
            totalItems += item.getQuantity();
            totalCost += item.getQuantity() * item.getPrice();
        }

        // Display summary
        System.out.println("Summary: ");
        System.out.println("Total Items Added: " + totalItems);
        System.out.println("Total Estimated Cost: " + String.format("%.2f", totalCost));
    }
}
