public class AuthorTest {
    public static void main(String[] args) {
        //Creation of Author instances
        Author a1 = new Author("A1","a1@gmail.com","01/01/2001");
        Author a2 = new Author("A2","02/02/2002");

        //Testing toString override
        String a1Result = a1.toString();
        String a2Result = a2.toString();
        System.out.println(a1); //Expected "A1 (a@gmail.com), born 01/01/2001"
        System.out.println(a1Result); //Expected "A1 (a@gmail.com), born 01/01/2001"
        System.out.println(a2); //Expected "A2 (no email), born 02/02/2002"
        System.out.println(a2Result); //Expected "A2 (no email), born 02/02/2002"

        //Testing getDateOfBirth
        String a1DOB = "01/01/2001";
        String a2DOB = "02/02/2002";
        System.out.println(a1.getDateOfBirth() + " | " + a1DOB); //Expected "01/01/2001 | 01/01/2001"
        System.out.println(a2.getDateOfBirth() + " | " + a2DOB); //Expected "02/02/2002 | 02/02/2002"

        //Testing getName
        String a1Name = "A1";
        String a2Name = "A2";
        System.out.println(a1.getName() + " | " + a1Name); //Expected "A1 | A1"
        System.out.println(a2.getName() + " | " + a2Name); //Expected "A2 | A2"

        //Testing getEmail
        String a1Email = "a@gmail.com";
        String a2Email = null;
        System.out.println(a1.getEmail() + " | " + a1Email); //Expected "a@gmail.com | a@gmail.com"
        System.out.println(a2.getEmail() + " | " + a2Email); //Expected "null | null"

        //Testing setEmail
        a1.setEmail("newA1@gmail.com");
        a2.setEmail("newA2@gmail.com");
        System.out.println(a1.getEmail() + " | " + a1Email); //Expected "newA1@gmail.com | a@gmail.com"
        System.out.println(a2.getEmail() + " | " + a2Email); //Expected "newA2@gmail.com | null"

        //Testing setName
        a1.setName("newA1");
        a2.setName("newA2");
        System.out.println(a1.getName() + " | " + a1Name); //Expected "newA1 | A1"
        System.out.println(a2.getName() + " | " + a2Name); //Expected "newA2 | A2"
    }
}