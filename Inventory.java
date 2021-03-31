
// Name(s): Jeremy Collins
// Course: ICS3UI
// Date: March 29,2021 - 
// Teacher: Mr. Dyck
// School: D2L
// Creation of Department store inventory. 
/////////////////////////////////////
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

class ItemInfo {
    Random rand = new Random();
    double price = (Math.round(Math.random() * 1000.0) / 100.0);
    int stock = rand.nextInt(100);
}

public class Inventory {
    public HashMap<String, ItemInfo> inventory = new HashMap<String, ItemInfo>();

    public void initialize() {
        try {
            Scanner scan = new Scanner(new FileReader("inventory.txt"));
            while (scan.hasNext()) {
                ItemInfo j = new ItemInfo();
                String key = scan.nextLine().trim();
                // System.out.println("Adding " + key + " to inventory");
                this.inventory.put(key, j);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("WHERE'S THE GOD DAMN INVENTORY.TXT");
            System.exit(-1);
        }
    }

    public double getPrice(String item) {
        return (this.inventory.get(item)).price;
    }

    public int getStock(String item) {
        return (this.inventory.get(item)).stock;
    }

    void addToCart(String item, int n) {
        (this.inventory.get(item)).stock -= n;
    }

    void returnFromCart(String item, int n) {
        (this.inventory.get(item)).stock += n;
    }

    public boolean isAvail(String item) {
        return this.inventory.containsKey(item);
    }
}