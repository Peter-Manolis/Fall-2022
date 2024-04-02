import java.text.DecimalFormat;
import java.util.ArrayList;

/*
The purpose of this class is to create a better version of the Book class,hence BetterBook. It contains all the methods
present in the Book class, except are adapted with some changes. These changes are related to the Author of the book.
The author instance variable in BetterBook is an ArrayList, meaning BetterBooks can have multiple authors. The inflation
method increases the price of a better book by a multiple of 2 and the edition of the book 1. The authorList method
returns a string that represents the Oxford comma notation needed when many authors are present in the system.
Other than these two methods, all methods completely relate to the Book class.
 */
public class BetterBook {
        private String title;
        private ArrayList<Author> authors;
        private double price;
        private int editionNumber;

    public BetterBook(ArrayList<Author> authors, String title, double price, int editionNumber) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.editionNumber = editionNumber;
    }
    public void inflation(){ //Inflation method doubles the price and adds one to the edition number
        setEditionNumber(this.editionNumber + 1);
        setPrice(this.price * 2);;
    }


    public String getPrice() {
        return df2.format(price);
    }

    public String getTitle() {
        return title;
    }

    public String getEditionNumber() {
        return Book.numToEdition(editionNumber);
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String authorList(ArrayList<Author> authors){ //authorList makes a string to format the output of multiple Authors
        String authorString = "";

        for (int i =0; i < authors.size(); i++){
            if (getAuthorEmail(authors.get(i)) != null){
                if (i == authors.size()-2){
                    authorString += (getAuthorName(authors.get(i)) + " (" + getAuthorEmail(authors.get(i)) + ") and ");
                }
                else {
                    authorString += (getAuthorName(authors.get(i)) + " (" + getAuthorEmail(authors.get(i)) + "), ");
                }
            }
            else{
                if (i == authors.size()-2){
                    authorString += (getAuthorName(authors.get(i)) + " and ");
                }
                else {
                    authorString += (getAuthorName(authors.get(i)) + ",  ");
                }
            }
        }
        return authorString;

    }

    public String toString() {
        String bookInfo = null;
        bookInfo = this.title + " (" + Book.numToEdition(this.editionNumber) + " Edition), by " + authorList(this.authors) + " available for $" + df2.format(this.price);
        return bookInfo;
    }

    public String getAuthorName(Author author){
        return author.getName();
    }

    public String getAuthorEmail(Author author){
        return author.getEmail();
    }
    public String getAuthorDateOfBirth(Author author){
        return author.getDateOfBirth();
    }

    public static final DecimalFormat df2 = new DecimalFormat( "#.00" );

}

