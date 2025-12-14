# ListIT

Description/overview 
ListIT is a simple program designed to help you organize your shopping and manage your money better. It solves the common problems of forgetting what to buy and overspending by combining a shopping list and an expense tracker in one easy-to-use tool. With the motto "List it, Track it, and Budget it," this application gives you a clear way to stay in control of your personal finances and daily needs.
The Shopping List feature helps you plan your trips to the store before you even leave your house. You can write down the items you need, specify how many you want, and estimate their prices. The program automatically adds up these costs to give you a total estimated bill, ensuring you know exactly how much money you need to prepare so there are no surprises at the checkout counter.
The Expense Tracker helps you stick to your budget by recording what you actually spend. You can log every purchase and group them into categories like Food, Bills, or Personal Care to see where your money is going. By setting a monthly budget at the start, the program tracks your spending and instantly shows you how much money you have left, helping you make smarter choices and avoid running out of cash.

OOP Concepts Applied 

	In our project, we applied the four main Object-Oriented Programming (OOP) Principles, 	
	Encapsulation, Inheritance, Polymorphism, and Abstraction. 

	Encapsulation - The project uses private fields in classes like Item and Expense along with
public getters and setters to protect data and allow controlled access. Input validation inside
methods such as addItem() also ensures that only valid values are stored.

Inheritance - Both ShopList and Expense extend ListITMain, allowing them to reuse
shared components such as the scanner and main program functions. This avoids duplication and demonstrates code reuse through inheritance.

Polymorphism - The Expense class overrides the toString() method to provide customized output when printing an expense. Polymorphism also appears when the same .sort() method behaves differently depending on the comparator used (sorting by name, category, price, or date).

Abstraction - The program separates functions into classes like ShopList, ExpenseTracker, Item, and Expense, each hiding complex logic behind simple method calls. Methods such as manageShoppingList() and sortExpenses() provide users with essential functionality without exposing internal processing details


Program Structure 

🔗Console-based Application Structure
📂JCLiK_ListIT (super final na)/
└── 📂JCLiK_ListIT/
    ├── 💸ExpenseTracker.java
    ├── 🛒Item.java
    ├── 📋ListITMain.java
    └── 📝ShopList.java

🔗💻JCLiK_ListIT/

💸ExpenseTracker.java — This class focuses on managing and tracking the user’s expenses. It includes methods to record new expenses, including details like monthly budget, category (e.g. food, household, personal care, and bills), date, and amount. It also includes methods to display a summary of expenses grouped by category or date. 
🛒Item.java — This class defines the structure of an individual item on the shopping list. It contains attributes such as name of the item, quantity of the item needed, and price. 
📋ListITMain.java — This is the main class of the application. It contains the main method, which serves as the starting point for the program. It handles the initial greeting, presents the main menu and manages the overall program flow based on the user input. 
📝ShopList.java — This class is responsible for managing the user’s shopping list. It includes methods to add new items to the shopping list, remove items from the shopping list, display the current shopping list, and update the name, quantity or price of items on the list. 


How to Run the Program 
 Requirements
   Java Development Kit (JDK) 8 or higher
   Command Prompt / Terminal or an IDE (VS Code)

How to Run 

1. Save the file as ‘ListITMain.java’
2. Open ‘Command Prompt / Terminal’
3. Go to the folder where the file is saved
4. Compile the program
‘ java ListITMain.java’
5. Run the program
   ‘java ListITMain’
6. Follow the on-screen instructions to use ListIT.




Sample output - khen
====================================================================================================
        Good Day! Welcome to ListIT, where you can List it, Track it, and Budget it!
                       Start tracking your expenses today and remember,
        "A budget is telling your money where to go instead of wondering where it went."
====================================================================================================

Want to start tracking your expenses and make a shopping list? 
Enter 1 if YES and 2 if NO: 1

Let me know first what I should call you.
Enter your nickname: Khen

Great! Hello, Khen. Let's start to list it, track it, and budget it!


===== MAIN MENU =====
1. Shopping List
2. Expense Tracker
3. Exit
Enter your choice: 1

Shopping List Options:
1. Add Item
2. View Items
3. Edit Item
4. Delete Item
5. Summary
6. Back to Home
Enter your choice: 1
Enter item name: Issy 

Enter quantity: 2
Enter estimated price per item(e.g. 20.00): 249
Item added: Issy
Quantity: 2
Price: 249.0

Shopping List Options:
1. Add Item
2. View Items
3. Edit Item
4. Delete Item
5. Summary
6. Back to Home
Enter your choice: 2
Your shopping list:
1. Issy
Quantity: 2
Price: 249.0
Total Estimated Cost: 498.0

Shopping List Options:
1. Add Item
2. View Items
3. Edit Item
4. Delete Item
5. Summary
6. Back to Home
Enter your choice: 3
Your shopping list:
1. Issy
Quantity: 2
Price: 249.0
Total Estimated Cost: 498.0
Enter the number of the item to edit: 1
Editing: Issy
What do you want to edit?
1. Name
2. Quantity
3. Price
Enter choice: 2
Enter new quantity: 3
Item updated.

Shopping List Options:
1. Add Item
2. View Items
3. Edit Item
4. Delete Item
5. Summary
6. Back to Home
Enter your choice: 4
Your shopping list:
1. Issy
Quantity: 3
Price: 249.0
Total Estimated Cost: 747.0
Enter the number of item to delete: 1
Item deleted: Issy

Shopping List Options:
1. Add Item
2. View Items
3. Edit Item
4. Delete Item
5. Summary
6. Back to Home
Enter your choice: 5
Summary: 
Total Items Added: 0
Total Estimated Cost: 0.00

Shopping List Options:
1. Add Item
2. View Items
3. Edit Item
4. Delete Item
5. Summary
6. Back to Home
Enter your choice: 6

===== MAIN MENU =====
1. Shopping List
2. Expense Tracker
3. Exit
Enter your choice: 2

Enter your monthly budget: Php5000

===== EXPENSE TRACKER =====
1. Add Expense
2. View Expenses
3. Sort Expenses
4. View Totals per Category
5. Show Remaining Budget
6. Back to Home
Enter choice: 1
Enter expense name: Daily Essentials

Select Category:
1. Food
2. Household
3. Personal Care
4. Bills
Enter: 3
Enter price: Php1200
Enter date (yyyy-mm-dd): 2025-12-14
Expense added successfully!

===== EXPENSE TRACKER =====
1. Add Expense
2. View Expenses
3. Sort Expenses
4. View Totals per Category
5. Show Remaining Budget
6. Back to Home
Enter choice: 2

===== ALL EXPENSES =====
1. Daily Essentials | Personal Care | Php1200.00 | 2025-12-14

===== EXPENSE TRACKER =====
1. Add Expense
2. View Expenses
3. Sort Expenses
4. View Totals per Category
5. Show Remaining Budget
6. Back to Home
Enter choice: 3

Sort by:
1. Item Name
2. Category
3. Price
4. Date Purchased
Enter: 1
Sorted successfully!

===== ALL EXPENSES =====
1. Daily Essentials | Personal Care | Php1200.00 | 2025-12-14

===== EXPENSE TRACKER =====
1. Add Expense
2. View Expenses
3. Sort Expenses
4. View Totals per Category
5. Show Remaining Budget
6. Back to Home
Enter choice: 4

===== CATEGORY TOTALS =====
Personal Care: Php1200.00

===== EXPENSE TRACKER =====
1. Add Expense
2. View Expenses
3. Sort Expenses
4. View Totals per Category
5. Show Remaining Budget
6. Back to Home
Enter choice: 5

===== BUDGET STATUS =====
Monthly Budget: Php5000.0
Total Spent:    Php1200.00
Remaining:      Php3800.00

===== EXPENSE TRACKER =====
1. Add Expense
2. View Expenses
3. Sort Expenses
4. View Totals per Category
5. Show Remaining Budget
6. Back to Home
Enter choice: 6

===== MAIN MENU =====
1. Shopping List
2. Expense Tracker
3. Exit
Enter your choice: 3

Thank you for using ListIT! Goodbye!

Author and Acknowledgement - lizeth
	This project, ListIT, was created by Group 3 as part of a learning activity to apply and
understand core programming and OOP concepts. The group extends sincere thanks to the
instructor, Sir Juriel Comia, for his guidance as well as to everyone who provided support and feedback during the development process. Their help made the successful completion of this project possible.
Other Sections you may include: - jona
*    Future Enhancements
The ListIT application, currently a console-based tool for managing shopping lists and tracking expenses, holds considerable potential for future enhancements. One significant improvement would be the development of a graphical user interface (GUI), offering a more intuitive and user-friendly experience compared to the command-line interface. Beyond the GUI, existing features can be expanded. The ShopList could incorporate features like price comparison across stores or automatic list sorting based on store layout. The ExpenseTracker could benefit from functionalities such as recurring expense tracking, financial goal setting, and integration with bank accounts for automated transaction recording. Furthermore, the application could leverage data analysis to provide users with personalized spending insights and budgeting recommendations, transforming it from a simple tracking tool into a comprehensive personal finance management system.

