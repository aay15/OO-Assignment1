import java.io.*;
import java.text.*;

public class Movie implements Serializable {
    private int sku;
    private String title;
    private int quantity;
    private float price;

    public Movie(int sku, int quantity, float price, String title) {
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

   public int getQuantity() {
        return quantity;
    }

    public void displayMovie() {
        DecimalFormat priceForm = new DecimalFormat ("$#0.00");
        System.out.println();
        System.out.println("Sku: " + this.sku);
        System.out.println("Title: " + this.title);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Price: " + priceForm.format(this.price));
    }
    public void displayLine() {
        DecimalFormat priceForm = new DecimalFormat ("$#0.00");
        
        System.out.printf("%-10s", this.sku);
        System.out.printf("%-8s", this.quantity);
        System.out.printf("%-10s", priceForm.format(this.price));
        System.out.printf("%-20s", this.title);
        System.out.println();
    }

    public void increaseQuantityBy(int n) {
        quantity += n;
    }

    public void removeMovie() {
        quantity--;
    }
}
