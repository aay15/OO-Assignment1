import java.util.ArrayList;
import java.text.*;

public class Inventory{

    ArrayList<Movie> movieList = new ArrayList<Movie>();

    public void addMovie(Movie movie) {

        boolean matchFound = false;
        
        for(Movie currMovie : movieList){
            if(currMovie.getSku() == movie.getSku()){
                matchFound = true;
                currMovie.increaseQuantityBy(movie.getQuantity());
                break;
            }
        }

        if(!matchFound) {
            movieList.add(movie);
        }
    }

    public void removeMovieBySku(int sku) {
       
        boolean skuFound = false;

        for(Movie currMovie : movieList) {        
            if(currMovie.getSku() == sku) {
                skuFound = true;
                currMovie.removeMovie();
                
                if(currMovie.getQuantity() <= 0) {
                    movieList.remove(currMovie);
                }
            } 
        }
        
        if(!skuFound) {
            System.out.println("Movie not found by sku.");
        } 
    }

    public void displayMovieBySku(int sku) {
        
        boolean skuFound = false;

        for(Movie currMovie : movieList) {
            if(currMovie.getSku() == sku) {
                skuFound = true;
                currMovie.displayMovie(); 
                break;
            }
        }

        if(!skuFound) {
            System.out.println("Movie not found by sku.");
        }
    }

    public void displayInventory() {
        //DecimalFormat priceForm = new DecimalFormat (#00.)
        //DecimalFormat skuForm =
        //DecimalFormat 

        for (int i = 0; i < movieList.size(); i++)
            movieList.get(i).displayMovie();
    }
}
