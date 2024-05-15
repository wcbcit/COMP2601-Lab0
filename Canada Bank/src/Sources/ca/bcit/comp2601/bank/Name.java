package ca.bcit.comp2601.bank;

/**
 * The name class represents a person's name.
 * It contains instance variables to store the first name and last name.
 * It contains getters for the first name and last name.
 * It contains a method to return the capitalized initials of the name.
 * It contains a method to return the full name with the first letters capitalized.
 *
 * @author walter chu & margaryta lvova
 * @version 1.0
 */
public class Name
{
    public static final int MAX_LENGTH_NAME      = 44;
    public static final int LETTER_TO_CAPITALIZE = 0;
    public static final int START_OF_SUBSTRING   = 1;

    private final String first;
    private final String last;

    public Name(final String first,
                final String last)
    {
        if(first == null ||
           first.isBlank() ||
           first.length() > MAX_LENGTH_NAME ||
           first.toLowerCase().contains("admin".toLowerCase()))
        {
            throw new IllegalArgumentException("That first name is not valid.");
        }
        else if(last == null ||
                last.isBlank() ||
                last.length() > MAX_LENGTH_NAME ||
                last.toLowerCase().contains("admin".toLowerCase()))
        {
            throw new IllegalArgumentException("That last name is not valid.");
        }
        else
        {
            this.first = first;
            this.last  = last;
        }
    }

    /**
     * The first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * The last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLast()
    {
        return last;
    }

    /**
     * The capitalized initials of the person.
     *
     * @return The capitalized initials of the person.
     */
    public String getInitials()
    {
        return (first.charAt(LETTER_TO_CAPITALIZE) + "." + last.charAt(LETTER_TO_CAPITALIZE) + ".").toUpperCase();
    }

    /**
     * The full name of the person, with the first letters capitalized.
     *
     * @return The full name of the person, with the first letters capitalized.
     */
    public String getFullName()
    {
        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(first.toUpperCase().charAt(LETTER_TO_CAPITALIZE));
        builder.append(first.toLowerCase().substring(START_OF_SUBSTRING));
        builder.append(" ");
        builder.append(last.toUpperCase().charAt(LETTER_TO_CAPITALIZE));
        builder.append(last.toLowerCase().substring(START_OF_SUBSTRING));

        return builder.toString();
    }
}
