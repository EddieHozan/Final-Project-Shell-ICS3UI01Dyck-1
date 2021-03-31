
///////////////////////////////////////////////////////////////
// Name: Riyan Qureshi 
// Course: ICS3UI
// Date: 3/29/2021
// Teacher: Mr. Dyck
// School: WCI
///////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class Receipt {
    private ArrayList<String> sItemNames;
    private ArrayList<Double> dItemPrices;
    private double dGrandTotal;
    Cart cart;
    
    // constructor
    public Receipt(Cart cart) {
        sItemNames = new ArrayList<String>(cart.keySet());
        dItemPrices = new ArrayList<Double>();
        for (String key : cart.keySet()) {
            dItemPrices.add(cart.itemPrice(key));
        }
        for (int i = 0; i < dItemPrices.size(); i++) {
            dGrandTotal += dItemPrices.get(i);
        }
    }

    // Original beta receipt method 
    // Print receipt
    // void printReceipt() {
    //     System.out.println("Item:" + "\t" + "Cost:");
    //     /*int i = 0;
    //     for(String s: sItemNames){
    //       System.out.println(s +"\t"+dItemPrices.get(i));
    //       i++;
    //     }
    //     for(Double d: dItemPrices){
    //       System.out.println("$"+d);
    //     }*/
    //     System.out.println("-------------------");
    //     System.out.printf("Grand Total: $%.2f", dGrandTotal);
        
    //     /*
    //     for (int i = 0; i < sItemNames.size(); i++) {
    //       System.out.print("Item:\t");
    //       System.out.print(sItemNames.get(i));
    //       System.out.print("Cost:\t");
    //       System.out.print(dItemPrices.get(i));*/
    // }
    
    void printReceipt(Cart cart) {
        System.out.format("\n%-10s%-10s\n", "Item", "Cost");
        System.out.format("--------------------\n");
        int i = 0;
        for(String key : cart.keySet()) {
            System.out.format("%-10s%-1s%-9.2f\n", key, "$", dItemPrices.get(i));
            i++;
        }
        System.out.format("--------------------\n");
        System.out.format("Grand total: %.2f", dGrandTotal);
    }
}
    // Write Receipt
    // void writeReceipt() throws IOException {
    //     PrintWriter fileOut = new PrintWriter(new FileWriter("Receipt.txt"));
    //     for (int i = 0; i < sItemNames.size(); i++) {
    //         fileOut.println(sItemNames.get(i) + " = " + dItemPrices.get(i));
    //     }
    //     fileOut.close();
    // }
//}
//}