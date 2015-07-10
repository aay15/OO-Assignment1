import java.util.*;
import java.io.*;

public class VideoStore {
    
    static Scanner sc = new Scanner(System.in);
    
    private Inventory storeInventory = new Inventory();

    public static void main(String[] args) {

        VideoStore store = new VideoStore();

        //read in inventory
        try {
            FileInputStream fis = new FileInputStream("inventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            store.storeInventory.movieList = (ArrayList<Movie>)ois.readObject(); 

        } catch (FileNotFoundException e) {
            //do nothing if not found...
            //System.out.println("Cannot find datafile.");
        } catch (IOException e) {
            System.out.println("Problem with file input.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found on input from file.");
        } 
        
        store.enterChoice();

        //Serialize to output
        try {
            FileOutputStream fos = new FileOutputStream("inventoryFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(store.storeInventory.movieList);
            fos.close();
        } catch (IOException e) {
            System.out.println("Problem with file output");
        }
    }

    static void displayMenu() {
        System.out.println();
        System.out.println("Video Store Inventory Menu");
        System.out.println("--------------------------");
        System.out.println("1. Add Movie");
        System.out.println("2. Remove Movie");
        System.out.println("3. Find Movie by SKU");
        System.out.println("4. Display inventory");
        System.out.println("5. Quit the Program");
        System.out.println();

    }
      
    private void enterChoice() {
        displayMenu();
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: //Add movie     
                storeInventory.addMovie(createNewMovie());
                enterChoice();
                break;

            case 2: //Remove movie
                storeInventory.removeMovieBySku(requestSku());
                enterChoice();
                break;

            case 3: //Display movie
                storeInventory.displayMovieBySku(requestSku());
                enterChoice();
                break;

            case 4: //Display inventory
                storeInventory.displayInventory();
                enterChoice();
                break;

            case 5: //Quit program
                System.out.println("Exit selected");
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
        sc.nextLine();
        title = sc.nextLine();

        Movie movie = new Movie(sku, quantity, price, title);

        return movie;
    }

    private int requestSku() {
        System.out.println("Enter the SKU:");    
        return sc.nextInt();
    }

}
