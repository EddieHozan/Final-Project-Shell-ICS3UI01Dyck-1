
// Name(s): Eddie Hozan, Jeremy Collins, Riyan Quresh, Andrew Liao
// Course: ICS3UI
// Date: March 29,2021 - 
// Teacher: Mr. Dyck
// School: D2L
// Brief Description of Program: * 
/////////////////////////////////////
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		boolean checker = true;
        while(checker) {
            Cashier cashier = new Cashier();
		    cashier.greeting();
            int emptyCart = -1;
            

            while (emptyCart == -1) {
                System.out.println("Please input what item you would like to buy!\n");
                emptyCart = cashier.buy();
            }

            while(true) {
                System.out.println("Please choose from the following actions: 'buy', 'return', 'check cart', or 'checkout'.\n"); 
                String sBuyOrReturn = scan.nextLine();
                if(sBuyOrReturn.equalsIgnoreCase("buy")) {
                    cashier.buy();
                }
                else if(sBuyOrReturn.equalsIgnoreCase("return")) {
                    cashier.remove();
                }
                else if(sBuyOrReturn.equalsIgnoreCase("check cart")) {
                    while(true) {
                        System.out.println("Please choose from the following options:\n" +  "1. Check the price of all items in your cart combined.\n" +
                        "2. Check the combined price of one item in your cart.\n" + 
                        "3. Check the unit price of one item in your cart.\n" + 
                        "4. List the items in your cart.\n" + 
                        "5. Go back to choose a different action.\n"); 
                        if(scan.hasNextInt()) {
                            int userChoice = Integer.parseInt(scan.nextLine());
                            if(userChoice == 1) {
                                cashier.currentPrice();
                                break;
                            }
                            if(userChoice == 2) {
                                System.out.println("Please input which item you would like to check:\n");
                                cashier.itemTotalPrice(scan.nextLine());
                                break;
                            }
                            if(userChoice == 3) {
                                System.out.println("Please input which item you would like to check the unit price to:\n");
                                cashier.unitPrice(scan.nextLine());
                                break;
                            }
                            if(userChoice == 4) {
                                cashier.printCart();
                                break;
                            }
                            if(userChoice == 5) {
                                break;
                            }
                            else {
                                System.out.println("Please pick one of the options.\n");
                            }
                        }
                        else {
                            String eatInput = scan.nextLine();
                            System.out.println("Please input integer option from 1-5 next time.\n");
                        }
                    }
                }
                else if(sBuyOrReturn.equalsIgnoreCase("checkout")) {
                    Receipt receipt = new Receipt(cashier.cart);
                    receipt.printReceipt(cashier.cart);
                    break;
                }
            }

            System.out.println("\nPlease input 'exit' to exit, or anything else to shop again: ");
            if(scan.next().trim().equalsIgnoreCase("exit")) {
                checker = false;
            }
	    }
        System.out.println("Thank you for shopping at [Fictional Grocery Store]!\n");
        scan.close();
    }
}
