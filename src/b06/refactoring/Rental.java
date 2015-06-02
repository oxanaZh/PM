package b06.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Rental {

    public Movie movie;
    public int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

}
