/*The Author class takes 3 instance variables, dateOfBirth, name, and email. all three of these instance variables are
of type String. There are two constructors for each Author, one requires all three variables to be used and the other
requires just name and dateOfBirth. The author class also has getters and setters present for each of the three
variables. The last thing the author class does is override the toString method to fit the following format:
"Cay Horstmann (cay@horstmann.com), born 6/16/1959"
or if the author has no email then:
"Ada Lovelace (no email), born 12/10/1815"

 */
public class Author {
    private String dateOfBirth;
    private String name;
    private String email;

    public Author (String name, String dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    public Author (String name, String email, String dateOfBirth){
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        String authorInfo = null;
        if (this.email == null){
            authorInfo = this.name + " (no email), born " + this.dateOfBirth;
        }
        else {
            authorInfo = this.name + " (" + this.email + "), born " + this.dateOfBirth;
        }
        return authorInfo;
    }
}
