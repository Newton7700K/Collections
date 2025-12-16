//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890

/**
 * Represents a character in a show.
 *
 * @author Mr. Murphy
 * @version December 2025
 */
public class ShowCharacter implements Comparable<ShowCharacter>
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
    
    public String getLastName(){
        return lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getActorName(){
        return actorName;
    }
    
    public String getShowTitle(){
        return showTitle;
    }
    
    public boolean equals(ShowCharacter character){
        return toString().equals(character.toString());
    }
    
    public int compareTo(ShowCharacter character){
        if(!lastName.equals(character.getLastName())){
            return this.lastName.compareTo(character.lastName);
        } else if (!firstName.equals(character.getFirstName())) {
            return this.firstName.compareTo(character.firstName);
        } else if (!actorName.equals(character.getActorName())) {
            return this.actorName.compareTo(character.actorName);
        } else if (!showTitle.equals(character.getShowTitle())) {
            return this.showTitle.compareTo(character.showTitle);
        } else {
            return 0;
        }
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
