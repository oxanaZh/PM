package b06.refactoring;

import java.util.*;


public class Customer {

    private String name;
    private List<Rental> rentalList = new ArrayList<Rental>();


    public Customer(String customerName) {
        this.name = customerName;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public String generateStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentalList) {
            double amount = AmountChecker.checkPriceCode(rental);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.NEWRELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

            totalAmount += amount;
        }

        result += "Amount owned is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    public String generateHtmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "<h1>Rental record for <b>" + getName() + "</b></h1>\n";
        for (Rental rental : rentalList) {
            double amount = AmountChecker.checkPriceCode(rental);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.NEWRELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "<p>" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "</p>\n";

            totalAmount += amount;
        }
        result += "<p>Amount owned is <b>" + String.valueOf(totalAmount) + "</b></p>\n";
        result += "<p>You earned <b>" + String.valueOf(frequentRenterPoints) + " frequent renter points</b></p>";
        return result;

    }

}




