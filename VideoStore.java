import java.util.*;

public class VideoStore {
    
    static Scanner sc = new Scanner(System.in);
    
    private Inventory storeInventory;

    public static void main(String[] args) {    
        VideoStore store = new VideoStore();
        displayMenu();
        store.enterChoice();
    }

    static void displayMenu() {
        System.out.println("Video Store Inventory Menu");
        System.out.println("1. Add Movie");
        System.out.println("2. Remove Movie");
        System.out.println("3. Find Movie by SKU");
        System.out.println("4. Display inventory");
        System.out.println("5. Quit the Program");
    }
      
    void enterChoice() {
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: //Add movie     
                storeInventory.addMovie(createNewMovie());
            break;

            case 2: //Remove movie
                storeInventory.removeMovieBySku(requestSku());
            break;

            case 3: //Display movie
                storeInventory.displayMovieBySku(requestSku());
            break;

            case 4: //Display inventory
            
            break;

            case 5: //Quit program

            break;

            default: 
                System.out.println("Incorrect choice.");
                enterChoice();
                break;
        }
    }

    private Movie createNewMovie() { 
        
        int sku, quantity;
        float price;
        String title;

        sku = requestSku();
        System.out.println("Enter the quantity:");
        quantity = sc.nextInt();
        System.out.println("Enter the price:");
        price = sc.nextFloat();
        System.out.println("Enter the title:"); 
        title = sc.next();

        Movie movie = new Movie(sku, quantity, price, title);

        return movie;
    }

    private int requestSku() {
        System.out.println("Enter the SKU:");    
        return sc.nextInt();
    }

}
