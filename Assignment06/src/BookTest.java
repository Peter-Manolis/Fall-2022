public class BookTest {
    public static void main(String[] args) {
        //Creation of Author instances
        Author a1 = new Author("A1","a1@gmail.com","01/01/2001");
        Author a2 = new Author("A2","02/02/2002");

        //Creation of Book instances
        Book b1 = new Book(a1, "b1Title", 112.50, 3);
        Book b2 = new Book(a2, "b2Title", 100.00, 1);

        //Testing toString override
        String b1Result =b1.toString();
        String b2Result =b2.toString();
        System.out.println(b1); //Expected "a1Title(3rd) Edition, by A1 (a1@gmail.com), born 01/01/2001, available for $112.50"
        System.out.println(b1Result); //Expected "a1Title(3rd) Edition, by A1 (a1@gmail.com), born 01/01/2001, available for $112.50"
        System.out.println(b2); //Expected "a2Title(1st) Edition, by A2 (no email), born 02/02/2002, available for $100.00"
        System.out.println(b2Result); //Expected "a2Title(1st) Edition, by A2 (no email), born 02/02/2002, available for $100.00"

        //Testing getAuthor
        String b1Author = "A1 (a1@gmail.com), born 01/01/2001";
        String b2Author = "A2 (no email), born 02/02/2002";
        System.out.println(b1.getAuthor() + " | " + b1Author); //Expected "A1 (a1@gmail.com), born 01/01/2001 | A1 (a1@gmail.com), born 01/01/2001"
        System.out.println(b2.getAuthor() + " | " + b2Author); //Expected "A2 (no email), born 02/02/2002 | A2 (no email), born 02/02/2002"

        //Testing getTitle
        String b1Title = "b1Title";
        String b2Title = "b2Title";
        System.out.println(b1.getTitle() + " | " + b1Title); //Expected "b1Title | b1Title"
        System.out.println(b2.getTitle() + " | " + b2Title); //Expected "b2Title | b2Title"

        //Testing getPrice
        double b1Price = 112.50;
        double b2Price = 100.00;
        System.out.println(b1.getPrice() + " | " + b1Price); //Expected 112.50 | 112.5
        System.out.println(b2.getPrice() + " | " + b2Price); //Expected 100.00 | 100.0

        //Testing setPrice
        b1.setPrice(50.00);
        b2.setPrice(44);
        System.out.println(b1.getPrice() + " | " + b1Price); //Expected 50.00 | 112.5
        System.out.println(b2.getPrice() + " | " + b2Price); //Expected 44.00 | 100.0
        b1.setPrice(77.77);
        System.out.println(b1.getPrice() + " | " + b1Price); //Expected 77.77 | 100.0

        //Testing getEditionNumber
        int b1Edition = 3;
        int b2Edition = 1;
        System.out.println(b1.getEditionNumber() + " | " + b1Edition); //Expected 3rd | 3
        System.out.println(b2.getEditionNumber() + " | " + b2Edition); //Expected 1st | 1

        //Testing getAuthorName
        String a1Name = "A1";
        String a2Name = "A2";
        System.out.println(b1.getAuthorName() + " | " + a1Name); //Expected "A1 | A1"
        System.out.println(b2.getAuthorName() + " | " + a2Name); //Expected "A2 | A2"

        //Testing getAuthorDateOfBirth
        String a1DOB = "01/01/2001";
        String a2DOB = "02/02/2002";
        System.out.println(b1.getAuthorDateOfBirth() + " | " + a1DOB); //Expected "01/01/2001 | 01/01/2001"
        System.out.println(b2.getAuthorDateOfBirth() + " | " + a2DOB); //Expected "02/02/2002 | 02/02/2002"

        //Testing getAuthorEmail
        String a1Email = "a1@gmail.com";
        String a2Email = null;
        System.out.println(b1.getAuthorEmail() + " | " + a1Email); //Expected "a1@gmail.com | a1@gmail.com"
        System.out.println(b2.getAuthorEmail() + " | " + a2Email); //Expected "null | null"

        //Testing setEmail
        a1.setEmail("newA1@gmail.com");
        a2.setEmail("newA2@gmail.com");
        System.out.println(b1.getAuthorEmail() + " | " + a1Email); //Expected "newa1@gmail.com | a1@gmail.com"
        System.out.println(b2.getAuthorEmail() + " | " + a2Email); //Expected "newA2@gmail.com" | null"

        //Testing setName
        a1.setName("newA1");
        a2.setName("newA2");
        System.out.println(b1.getAuthorName() + " | " + a1Name); //Expected "newA1 | A1"
        System.out.println(b2.getAuthorName() + " | " + a2Name); //Expected "newA2 | A2"
    }
}