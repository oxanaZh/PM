package b06.refactoring;

public class AmountChecker {
    public AmountChecker() {
    }

    public static double checkPriceCode(Rental rental) {
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
        return getAmount(rental,amount);
    }

    private static double getAmount(Rental rental, double amount) {
        if (rental.getMovie().getPriceCode() != Movie.NEWRELEASE) {
            if (rental.getDaysRented() > 2) {
                if (rental.getMovie().getPriceCode() == Movie.CHLDRNS) {
                    if (rental.getDaysRented() > 3)
                        amount += (rental.getDaysRented() - 3) * 1.5;
                } else {
                    if (rental.getMovie().getPriceCode() == Movie.REGULAR)
                        amount += (rental.getDaysRented() - 2) * 1.5;
                }
            }
        }
        return amount;
    }
}