package b06.refactoring;

/**
 * Dokumentation der Utility-Klasse Amountchecker.
 *
 * Der Amountchecker berechnet den Wert der entliehenen Filme.
 * @author Ruben Gees und Patrick Starzynski
 */
public final class AmountChecker {

    private static final int THREE = 3;
    private static final int TWO = 2;
    private static final double ONE_POINT_FIVE = 1.5;

    private AmountChecker() {

    }

    /**
     * Liefert anhand des Preiscodes des Filmes den entsprechenden Wert zurück.
     * @param rental was geliehen wurde.
     * @return den Wert des entliehenen Filmes.
     */
    public static double checkPriceCode(final Rental rental) {
        double amount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += TWO;
                break;
            case Movie.NEWRELEASE:
                amount += rental.getDaysRented() * THREE;
                break;
            case Movie.CHLDRNS:
                amount += ONE_POINT_FIVE;
                break;
            default:
                amount = 0;
        }
        return getAmount(rental, amount);
    }

    private static double getAmount(final Rental rental, final double amount) {
        double tempAmount = amount;
        if (rental.getMovie().getPriceCode()
                != Movie.NEWRELEASE
                && rental.getDaysRented() > TWO) {
            return getAmountChldrns(rental, amount);
        }
        return tempAmount;

    }
    private static double getAmountChldrns(final Rental rental,
                                           final double amount) {
        double tempAmount = amount;
        if (rental.getMovie().getPriceCode() == Movie.CHLDRNS
                && rental.getDaysRented() > THREE) {
            tempAmount += (rental.getDaysRented() - THREE) * ONE_POINT_FIVE;
            return tempAmount;
        }
        return getAmountRegular(rental, amount);
    }

    private static double getAmountRegular(final Rental rental,
                                           final double amount) {
        double tempAmount = amount;
        if (rental.getMovie().getPriceCode() == Movie.REGULAR) {
            tempAmount += (rental.getDaysRented() - TWO) * ONE_POINT_FIVE;
            return tempAmount;
        }
        return tempAmount;
    }

}
