import java.util.ArrayList;

public class BetterBookTest {
    public static void main(String[] args) {

        //Creation of Author instances
        Author a1 = new Author("A1", "a1@gmail.com", "01/01/2001");
        Author a2 = new Author("A2", "02/02/2002");
        Author a3 = new Author("A3", "a3@gmail.com", "03/03/2003");
        Author a4 = new Author("A4", "a4@gmail.com", "04/04/2004");

        //Creation of an ArrayList of Authors
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authors.add(a4);

        //Creation of BetterBook instance
        BetterBook bb1 = new BetterBook(authors,"bb1Title", 150.00, 3);

        //Testing toString override
        String bb1Result =bb1.toString();
        System.out.println(bb1Result); //Expected "bb1Title (3rd Edition), by A1 (a1@gmail.com), A2,  A3 (a3@gmail.com) and A4 (a4@gmail.com),  available for $150.00"
        System.out.println(bb1); //Expected "bb1Title (3rd Edition), by A1 (a1@gmail.com), A2,  A3 (a3@gmail.com) and A4 (a4@gmail.com),  available for $150.00"

        //Testing getPrice
        double bb1Price = 150.00;
        System.out.println(bb1.getPrice() + " | " + bb1Price); //Expected 150.00 | 150.0

        //Testing getTitle
        String bb1Title = "bb1Title";
        System.out.println(bb1.getTitle() + " | " + bb1Title); //Expected "bb1Title | bb1Title"

        //Testing getEditionNumber
        int bb1Edition = 3;
        System.out.println(bb1.getEditionNumber() + " | " + bb1Edition); //Expected 3rd | 3

        //Testing getAuthors
        System.out.println(bb1.getAuthors() + " | " + authors); //Expected [A1 (a1@gmail.com), born 01/01/2001, A2 (no email), born 02/02/2002, A3 (a3@gmail.com), born 03/03/2003, A4 (a4@gmail.com), born 04/04/2004] | [A1 (a1@gmail.com), born 01/01/2001, A2 (no email), born 02/02/2002, A3 (a3@gmail.com), born 03/03/2003, A4 (a4@gmail.com), born 04/04/2004]

        //Testing setEditionNumber
        bb1.setEditionNumber(7);
        System.out.println(bb1.getEditionNumber() + " | " + bb1Edition); //Expected 7th | 3

        //Testing setPrice
        bb1.setPrice(300.00);
        System.out.println(bb1.getPrice() + " | " + bb1Price); //Expected 300.00 | 150.0

        //Testing getAuthorName
        String a1Name = "A1";
        String a2Name = "A2";
        System.out.println(bb1.getAuthorName(a1) + " | " + a1Name); //Expected "A1 | A1"
        System.out.println(bb1.getAuthorName(a2) + " | " + a2Name); //Expected "A2 | A2"

        //Testing getAuthorDateOfBirth
        String a1DOB = "01/01/2001";
        String a2DOB = "02/02/2002";
        System.out.println(bb1.getAuthorDateOfBirth(a1) + " | " + a1DOB); //Expected "01/01/2001 | 01/01/2001"
        System.out.println(bb1.getAuthorDateOfBirth(a2) + " | " + a2DOB); //Expected "02/02/2002 | 02/02/2002"

        //Testing getAuthorEmail
        String a1Email = "a1@gmail.com";
        String a2Email = null;
        System.out.println(bb1.getAuthorEmail(a1) + " | " + a1Email); //Expected "a1@gmail.com | a1@gmail.com"
        System.out.println(bb1.getAuthorEmail(a2) + " | " + a2Email); //Expected "null | null"

        //Testing setAuthorEmail
        a1.setEmail("newA1@gmail.com");
        a2.setEmail("newA2@gmail.com");
        System.out.println(bb1.getAuthorEmail(a1) + " | " + a1Email); //Expected "newa1@gmail.com | a1@gmail.com"
        System.out.println(bb1.getAuthorEmail(a2) + " | " + a2Email); //Expected "newA2@gmail.com" | null"

        //Testng setAuthorName
        a1.setName("newA1");
        a2.setName("newA2");
        System.out.println(bb1.getAuthorName(a1) + " | " + a1Name); //Expected "newA1 | A1"
        System.out.println(bb1.getAuthorName(a2) + " | " + a2Name); //Expected "newA2 | A2"

        //Testing inflation (double the price and increase edition number by 1)
        bb1.inflation();
        System.out.println(bb1); //Expected "bb1Title (8th Edition), by newA1 (newa1@gmail.com), newA2 (newA2@gmail.com),  A3 (a3@gmail.com) and A4 (a4@gmail.com),  available for $600.00"
        System.out.println(bb1.getPrice()); //Expected 600.00
        System.out.println(bb1.getEditionNumber()); //Expected 8th


    }
}
