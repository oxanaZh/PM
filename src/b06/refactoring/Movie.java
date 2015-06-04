package b06.refactoring;

public class Movie {

    public static final int CHLDRNS = 2;
    public static final int REGULAR = 0;
    public static final int NEWRELEASE = 1;

    public String title;
    public int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

}
