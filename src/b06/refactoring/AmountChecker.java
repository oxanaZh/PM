package b06.refactoring;

/**
 * Dokumentation der Utility-Klasse Amountchecker.
 *
 * Der Amountchecker berechnet den Wert der entliehenen Filme.
 * @author Ruben Gees und Patrick Starzynski
 */
public final class AmountChecker {
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
                amount += 2;
                break;
            case Movie.NEWRELEASE:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.CHLDRNS:
                amount += 1.5;
                break;
            default:
                amount = 0;
        }
        return getAmount(rental, amount);
    }

    private static double getAmount(final Rental rental, final double amount) {
        double tempAmount = amount;
        if (rental.getMovie().getPriceCode() != Movie.NEWRELEASE) {
            if (rental.getDaysRented() > 2) {
                if (rental.getMovie().getPriceCode() == Movie.CHLDRNS) {
                    if (rental.getDaysRented() > 3) {
                        tempAmount += (rental.getDaysRented() - 3) * 1.5;
                    }
                } else {
                    if (rental.getMovie().getPriceCode() == Movie.REGULAR) {
                        tempAmount += (rental.getDaysRented() - 2) * 1.5;
                    }
                }
            }
        }
        return tempAmount;
    }

}
