import java.io.*;
import java.util.ArrayList;

public class Inventory implements Serializable{

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
}
