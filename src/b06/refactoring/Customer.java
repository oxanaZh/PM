package b06.refactoring;


import java.util.ArrayList;
import java.util.List;

/**
 * Dokumentation der Klasse Customer.
 * <p>
 * Die Klasse Customer repräsentiert den Kunden der Artikel ausleihen kann.
 *
 * @author Ruben Gees und Patrick Starzynski
 */
public class Customer {

    private String name;
    private List<Rental> rentalList = new ArrayList<>();

    /**
     * Der Konstruktor des Kunden.
     *
     * @param customerName der Name des Kunden
     */
    public Customer(final String customerName) {
        this.name = customerName;
    }

    /**
     * Getter für den Kundennamen.
     *
     * @return den Kundennamen.
     */
    public String getName() {
        return name;
    }

    /**
     * Leiht etwas aus.
     *
     * @param rental ein Rentalobjekt welches geliehen werden soll.
     * @see Rental
     */
    public void addRental(final Rental rental) {
        rentalList.add(rental);
    }

    /**
     * Generiert String zur Ausgabe.
     * <p>
     * Der String enthält den Kundennamen.
     * Welche Artikel mit welchem Wert und dem komulierten Gesamtwert.
     * Und die entsprechenden "RenterPoints".
     *
     * @return formatieren String mit den Informationen.
     */
    public String generateStatement() {
        double totalAmount = 0;
        int freqRentPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentalList) {

            double amount = AmountChecker.checkPriceCode(rental);
            freqRentPoints = getFreqRentPoints(freqRentPoints, rental);
            result += "\t" + rental.getMovie().getTitle()
                    + "\t" + amount + "\n";
            totalAmount += amount;
        }

        result += "Amount owned is " + totalAmount + "\n";
        result += "You earned " + freqRentPoints
                + " frequent renter points";

        return result;
    }

    private int getFreqRentPoints(final int freqRentPoints,
                                  final Rental rental) {
        int tempFrequentRenterPoints = freqRentPoints;
        tempFrequentRenterPoints++;
        // add bonus for a two day new release rental
        if (rental.getMovie().getPriceCode() == Movie.NEWRELEASE
                && rental.getDaysRented() > 1) {
            tempFrequentRenterPoints++;
        }
        return tempFrequentRenterPoints;
    }

    /**
     * Generiert Ausgabe in HTML-Format.
     * <p>
     * Der String enthält den Kundennamen.
     * Welche Artikel mit welchem Wert und dem komulierten Gesamtwert.
     * Und die entsprechenden "RenterPoints".
     *
     * @return formatierten String mit HTML-Tags.
     */
    public String generateHtmlStatement() {
        double totalAmount = 0;
        int freqRentPoints = 0;

        String result = "<h1>Rental record for <b>" + getName() + "</b></h1>\n";
        for (Rental rental : rentalList) {
            double amount = AmountChecker.checkPriceCode(rental);
            freqRentPoints = getFreqRentPoints(freqRentPoints, rental);
            result += "<p>" + rental.getMovie().getTitle()
                    + "\t" + amount + "</p>\n";
            totalAmount += amount;
        }
        result += "<p>Amount owned is <b>" + totalAmount + "</b></p>\n";
        result += "<p>You earned <b>" + freqRentPoints
                + " frequent renter points</b></p>";
        return result;

    }

}




