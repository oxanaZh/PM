package b06.refactoring;

public class Movie {

    public static final int chldrns = 2;
    public static final int regular = 0;
    public static final int new_rel = 1;

    public String tit;
    public int priceCode;

    public Movie(String tit, int priceCode) {
        this.tit = tit;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return tit;
    }

    public int getPriceCode() {
        return priceCode;
    }

}
