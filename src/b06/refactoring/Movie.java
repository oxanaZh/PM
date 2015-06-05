package b06.refactoring;

/**
 * Dokumentation der Klasse Movie.
 *
 * Die Movie-Klasse bildet einen Film ab.
 * Dieser Film besitzt einen Titel und einen Preisschlüssel
 * @author Ruben Gees und Patrick Starzynski
 */
public class Movie {
    /**
     * Schlüssel für Kinderfilme.
     */
    public static final int CHLDRNS = 2;
    /**
     * Schlüssel für "normale" Filme.
     */
    public static final int REGULAR = 0;
    /**
     * Schlüssel für neue Filme.
     */
    public static final int NEWRELEASE = 1;

    private String title;
    private int priceCode;

    /**
     * Konstruktor der Klasse Movie
     *
     * Im Konstruktor wird der Filmtitel und der
     * Preisschlüssel definiert.
     * @param movieTitle Name des Filmes.
     * @param defaultPriceCode Preisschlüssel des Filmes.
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
     * Getter vom Preisschlüssel.
     * @return Preisschlüssel des Filmes.
     */
    public int getPriceCode() {
        return priceCode;
    }

}
