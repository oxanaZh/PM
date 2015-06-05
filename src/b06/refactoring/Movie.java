package b06.refactoring;

/**
 * Dokumentation der Klasse Movie.
 *
 * Die Movie-Klasse bildet einen Film ab.
 * Dieser Film besitzt einen Titel und einen Preisschl�ssel
 * @author Ruben Gees und Patrick Starzynski
 */
public class Movie {
    /**
     * Schl�ssel f�r Kinderfilme.
     */
    public static final int CHLDRNS = 2;
    /**
     * Schl�ssel f�r "normale" Filme.
     */
    public static final int REGULAR = 0;
    /**
     * Schl�ssel f�r neue Filme.
     */
    public static final int NEWRELEASE = 1;

    private String title;
    private int priceCode;

    /**
     * Konstruktor der Klasse Movie
     *
     * Im Konstruktor wird der Filmtitel und der
     * Preisschl�ssel definiert.
     * @param movieTitle Name des Filmes.
     * @param defaultPriceCode Preisschl�ssel des Filmes.
     */
    public Movie(final String movieTitle, final int defaultPriceCode) {
        this.title = movieTitle;
        this.priceCode = defaultPriceCode;
    }

    /**
     * Getter vom Filmnamen.
     *
     * @return Namen des Filmes.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter vom Preisschl�ssel.
     * @return Preisschl�ssel des Filmes.
     */
    public int getPriceCode() {
        return priceCode;
    }

}
