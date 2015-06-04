package b06.refactoring;

import java.util.*;


public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String generateStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double amount = 0;
            switch (rental.getMovie().getPriceCode()) {
            case Movie.regular:
                amount += 2;
                break;
            case Movie.new_rel:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.chldrns:
                amount += 1.5;
        }

        if (rental.getMovie().getPriceCode() != Movie.new_rel) {
            if (rental.getDaysRented() > 2) {
                if (rental.getMovie().getPriceCode() == Movie.chldrns){
                    if( rental.getDaysRented() > 3 )
                        amount+=(rental.getDaysRented()-3)*1.5;
                }else{
                if( rental.getMovie().getPriceCode() == Movie.regular )
                    amount+=(rental.getDaysRented()-2)*1.5;
                }
            }
        }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.new_rel && rental.getDaysRented() > 1)
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
        for (Rental rental : rentals) {
            double amount = 0;
            switch (rental.getMovie().getPriceCode()) {
            case Movie.regular:
                amount += 2;
                break;
            case Movie.new_rel:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.chldrns:
                amount += 1.5;
            }

            if (rental.getMovie().getPriceCode() != Movie.new_rel) {
                if (rental.getDaysRented() > 2) {
                    if (rental.getMovie().getPriceCode() == Movie.chldrns){
                        if( rental.getDaysRented() > 3 )
                            amount+=(rental.getDaysRented()-3)*1.5;
                    }else{
                    if( rental.getMovie().getPriceCode() == Movie.regular )
                        amount+=(rental.getDaysRented()-2)*1.5;
                    }
                }
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.new_rel && rental.getDaysRented() > 1)
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




