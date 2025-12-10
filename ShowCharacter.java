//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890

/**
 * Represents a character in a show.
 *
 * @author Mr. Murphy
 * @version December 2025
 */
public class ShowCharacter
{
    private String firstName;
    private String lastName;
    private String showTitle;
    private String actorName;
    
    /**
     * Constructs a ShowCharacter.
     * 
     * @param firstName character's first name
     * @param lastName character's last name
     * @param showTitle title of the show
     * @param actorName actor that played the character
     */
    public ShowCharacter(String firstName, String lastName, String showTitle, String actorName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.showTitle = showTitle;
        this.actorName = actorName;
    }
    
    public int compareTo(ShowCharacter character){
        return toString().compareTo(character.toString());
    }
    
    /**
     * Returns a string representing a ShowCharacter.
     * 
     * @return string representing a ShowCharacter
     */
    public String toString() {
        return firstName + " " + lastName + " in " + showTitle + ", played by " + actorName;
    }
}
