import java.io.*;

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
        System.out.println("Sku: " + this.sku);
        System.out.println("Title: " + this.title);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Price: " + this.price);
    }

    public void increaseQuantityBy(int n) {
        quantity += n;
    }

    public void removeMovie() {
        quantity--;
    }
}
