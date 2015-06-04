package b06.refactoring;

/**
 * Dokumentation der Klasse Rental.
 *
 * Die Rental-Klasse stellt die Bündelung der Informationen,
 * welcher Film für wielange vermietet wurde dar.
 * @author Ruben Gees und Patrick Starzynski
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    /**
     * Konstruktor der Klasse Rental.
     *
     * @param rentedMovie der Film der geliehen werden soll.
     * @param rentPeriod für wielange der Film geliehen werden soll.
     */
    public Rental(final Movie rentedMovie, final int rentPeriod) {
        this.movie = rentedMovie;
        this.daysRented = rentPeriod;
    }

    /**
     * Getter des Movie.
     *
     * @return Movie der geliehen wurde.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Getter der Tage.
     *
     * @return Tage die geliehen wurde.
     */
    public int getDaysRented() {
        return daysRented;
    }

}
