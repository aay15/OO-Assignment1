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
            case 1:      
                storeInventory.addMovie(createNewMovie());
            break;

            case 2:

            break;

            case 3:

            break;

            case 4:

            break;

            case 5:

            break;

            default: 
                System.out.println("Incorrect choice.");
                enterChoice();
                break;
        }
    }

    Movie createNewMovie() { 
        Movie movie = new Movie();
        System.out.println("Enter the SKU:");
        movie.setSku(sc.nextInt()); 
        System.out.println("Enter the quantity:");
        movie.setQuantity(sc.nextInt());
        System.out.println("Enter the price:");
        movie.setPrice(sc.nextFloat());
        System.out.println("Enter the title:"); 
        movie.setTitle(sc.next());

        return movie;
    }

}
