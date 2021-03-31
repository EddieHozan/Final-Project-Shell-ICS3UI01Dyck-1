
///////////////////////////////////////////////////////////////
// Name: Riyan Qureshi 
// Course: ICS3UI
// Date: 3/29/2021
// Teacher: Mr. Dyck
// School: WCI
///////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.io.*;

public class Receipt {
    private ArrayList<String> sItemNames;
    private ArrayList<Double> dItemPrices;
    private double dGrandTotal;
    Cart cart;
    
    // constructor
    public Receipt(Cart cart) {
        sItemNames = new ArrayList<String>(cart.size());
        dItemPrices = new ArrayList<Double>();
        for (String key : cart.keySet()) {
            dItemPrices.add(cart.itemPrice(key));
        }
        for (int i = 0; i < dItemPrices.size(); i++) {
            dGrandTotal += dItemPrices.get(i);
        }
    }

    // Print receipt
    public void printReceipt() {
        System.out.println("Item:" + "\t" + "Cost:");
        for (int i = 0; i < sItemNames.size(); i++) {
            System.out.println(sItemNames.get(i) + "\t" + dItemPrices.get(i));
        }
        System.out.println("Grand Total: " + dGrandTotal);
    }

    // Write Receipt
    public void writeReceipt() throws IOException {
        PrintWriter fileOut = new PrintWriter(new FileWriter("Receipt.txt"));
        for (int i = 0; i < sItemNames.size(); i++) {
            fileOut.println(sItemNames.get(i) + " = " + dItemPrices.get(i));
        }
        fileOut.close();
    }
}