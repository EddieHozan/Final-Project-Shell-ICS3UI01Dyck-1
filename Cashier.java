
// Name: Eddie Hozan
// Course: ICS3UI
// Date: March 29,2021
// Teacher: Mr. Dyck
// School: D2L
// Brief Description of Class: A 'cashier' will walk the user through the steps, ask them to input the things they want to buy/return and add that info to their cart. Cashier will also return the user their receipt.

import java.util.*;
import java.lang.Math;

public class Cashier {
    // Variables
    int nAddItem, nOption, nRemoveQuantity, nItemQuantity;

    String sRemove, sTextInput, sItemChoice;

    Cart cart = new Cart();// Create a cart object
    Inventory inventory;
    Scanner scan = new Scanner(System.in);

    // Greeting method
    void greeting() {
        this.inventory = this.cart.inventory;
        System.out.println("\nHello, welcome to the store! \n");
        inventory.initialize();
    }

    // Buying method
    public int buy() {
        System.out.print("Enter which item you would like to purchase: \n");
        String sTextInput = scan.nextLine().trim(); // Item choice
        String sItemChoice = sTextInput.toLowerCase().trim();
        System.out.println();
        boolean bAvailable = inventory.isAvail(sItemChoice);
        if (bAvailable) {
            int nAvailStock = inventory.getStock(sItemChoice);
            double dItemPrice = inventory.getPrice(sItemChoice);
            System.out.format("Enter the quantity of this item. There is %d in stock, and the unit price is $%.2f:\n", nAvailStock,
                    dItemPrice);
            while(true) {
                if(scan.hasNextInt()) {
                    int nItemQuantity = Math.abs(Integer.parseInt(scan.nextLine())); 
                    if (nItemQuantity > nAvailStock) {
                    System.out.format(
                            "There is not enough of that item in stock! Please enter a number less than or equal to %d:\n", nAvailStock);     
                    } 
                    else {
                        System.out.format("Added %d of %s to your cart!\n", nItemQuantity,     sItemChoice);
                        cart.add(sItemChoice, nItemQuantity);
                        return 1;
                    }
                }
                else {
                    String nom = scan.nextLine();
                    System.out.println("Please input an integer.\n");
                }
            }
        }   
        else {
            System.out.println("This item does not exist!\n");
            return -1;
        }
    }

    // Removing method
    public boolean remove() {
        while(true) {
            System.out.print("Which item do you want to remove?\n");
            String sRemove = scan.nextLine();

            if (cart.isInCart(sRemove)) {
                System.out.format("How much of this item would you like to remove? You have %d in your cart.\n", cart.qtyInCart(sRemove));
                while(true) {
                    if(scan.hasNextInt()) {
                        int nRemoveQuantity = Math.abs(Integer.parseInt(scan.nextLine()));
                        if(nRemoveQuantity <= cart.qtyInCart(sRemove)) {    
                            cart.takeFromCart(sRemove, nRemoveQuantity);
                            System.out.format("Removed %d of %s from your cart! You now have %d in your cart.\n", nRemoveQuantity, sRemove, cart.qtyInCart(sRemove));
                            return true;
                        }
                        else {
                            System.out.format("You do not have enough of that item in your cart! Please input a number less than or equal to %d.\n", cart.qtyInCart(sRemove));
                        }
                    }
                    else {
                        String nom = scan.nextLine();
                        System.out.println("Please input an integer.\n");
                    }
                }
            }
            
            else {
                System.out.println("This item is not in your cart!\n");
            }
        }
    }
    
    void currentPrice() {
        System.out.format("The current price of all %d items in your cart is $%.2f.\n", cart.itemsInCart(), cart.currentPrice());
    }

    void itemTotalPrice(String item) {
        if(cart.isInCart(item)) {
            System.out.format("The price of all %d of %s in your cart is $%.2f.\n", cart.qtyInCart(item), item, cart.itemPrice(item));
        }
        else {
            System.out.print("That item is not in your cart!\n");
        }
    }

    void printCart() {
        cart.printCart();
    }

    void unitPrice(String item) {
        if(inventory.isAvail(item)) {
            System.out.printf("The unit price of the item is: $%.2f.\n", inventory.getPrice(item));
        }
        else {
            System.out.println("This item does not exist.\n");
        }
    }
}