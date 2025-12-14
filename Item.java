//Item class represents one product or item record
class Item {
    private String itemName; // Stores the name of the item
    private int quantity; // Stores how many items
    private double price; // Stores the price of the item

    //Constructor: used to create an Item object
    public Item(String itemName, int quantity, double price) {
        this.itemName = itemName; // Assign item name
        this.quantity = quantity; // Assign quantity 
        this.price = price; // Assign price 
    }

    public String getItemName() { // Getter: returns the item name
        return itemName;
    }

    public void setItemName(String itemName) { // Setter: updates the quantity
        this.itemName = itemName;
    }

    public int getQuantity() { // Getter: returns the quantity
        return quantity;
    }

    public void setQuantity(int quantity) { //SetterL updates the quantity
        this.quantity = quantity;
    }

    public double getPrice() { // Getter: returns the price
        return price;
    }

    public void setPrice(double price) { // Setter: updates the price
        this.price = price;
    }
}
