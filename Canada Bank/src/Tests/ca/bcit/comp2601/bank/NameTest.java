package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author walter chu & margaryta lvova
 * @version 1.0
 */
class NameTest
{
    Name n1;
    Name n2;

    @BeforeEach
    void setUp()
    {
        n1 = new Name("tiGER", "wooDS");
        n2 = new Name("eLoN", "MuSk");
    }

    @AfterEach
    void tearDown()
    {
        n1 = null;
        n2 = null;
    }

    @Test
    void getFirst()
    {
        assertEquals("tiGER", n1.getFirst());
        assertEquals("eLoN", n2.getFirst());
    }

    @Test
    void getLast()
    {
        assertEquals("wooDS", n1.getLast());
        assertEquals("MuSk", n2.getLast());
    }

    @Test
    void getInitials()
    {
        assertEquals("T.W.", n1.getInitials());
        assertEquals("E.M.", n2.getInitials());
    }

    @Test
    void getFullName()
    {
        assertEquals("Tiger Woods", n1.getFullName());
        assertEquals("Elon Musk", n2.getFullName());
    }

    @Test
    public void constructorThrowsWithNullFirstName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name(null, "wooDS");
        });

        String expectedMessage = "That first name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithEmptyFirstName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("", "wooDS");
        });

        String expectedMessage = "That first name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithWhitespaceFirstName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name(" ", "wooDS");
        });

        String expectedMessage = "That first name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithAdminInFirstName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("admin", "wooDS");
        });

        String expectedMessage = "That first name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithLongFirstName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeee", "wooDS");
        });

        String expectedMessage = "That first name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithNullLastName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("tigER", null);
        });

        String expectedMessage = "That last name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithEmptyLastName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("tigER", "");
        });

        String expectedMessage = "That last name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithWhitespaceLastName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("tigER", " ");
        });

        String expectedMessage = "That last name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsAdminInLastName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("tigER", "admin");
        });

        String expectedMessage = "That last name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void constructorThrowsWithLongLastName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            Name name = new Name("tigER", "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeee");
        });

        String expectedMessage = "That last name is not valid.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }
}