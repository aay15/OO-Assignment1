import java.util.Hashtable;

public class Inventory{

    Hashtable<String, Movie>movieInventory = new Hashtable<String, Movie>();

    public void addMovie(Movie movie) {

        String movieTitle = movie.getTitle();

        if(movieInventory.containsKey(movieTitle)) {
            Movie oldMovie = movieInventory.get(movieTitle);

        } else {
            movieInventory.put(movieTitle, movie);
        }
    }
}
