import java.text.DecimalFormat;
/*
The Book class takes 4 instance variables title of type String, price of type Double, editionNumber of type int, and
author of type Author. Each instance of a Book needs all 4 variables. The numToEdition method makes the edition number
be returned as a string with the correct ending at the end. The Book class also has getters and setters for the 4
instance variables. The last thing the Book class provieds is an override of the toString to display the following
format:
"Big Java: Late Objects (2nd Edition), by Cay Horstmann (cay@horstmann.com), born6/16/1959, available for $112.50"
 */
public class Book {
    private String title;
    private double price;
    private int editionNumber;
    private Author author;
    public static String numToEdition(int editionNumber){
        if (editionNumber % 10 == 1 && editionNumber % 100 != 11) {
            return editionNumber + "st";
        } else if (editionNumber % 10 == 2 && editionNumber % 100 != 12) {
            return editionNumber + "nd";
        } else if (editionNumber % 10 == 3 && editionNumber % 100 != 13) {
            return editionNumber + "rd";
        } else {
            return editionNumber + "th";
        }
    }

    public Book(Author author, String title, double price, int editionNumber) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.editionNumber = editionNumber;
    }

    public String getPrice() {
        return df2.format(price);
    }

    public String getTitle() {
        return title;
    }

    public String getEditionNumber() {
        return numToEdition(editionNumber);
    }

    public Author getAuthor() {
        return author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        String bookInfo = null;
        bookInfo = this.title + " (" + numToEdition(this.editionNumber) + " Edition), by " + author.toString() + ", available for $" + df2.format(this.price);
        return bookInfo;
    }

    public String getAuthorName(){
        return author.getName();
    }
    public String getAuthorDateOfBirth(){
        return author.getDateOfBirth();
    }
    public String getAuthorEmail(){
        return author.getEmail();
    }
    public static final DecimalFormat df2 = new DecimalFormat( "#.00" );

}
