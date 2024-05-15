import ca.bcit.comp2601.bank.BankClient;
import ca.bcit.comp2601.bank.Date;
import ca.bcit.comp2601.bank.Name;
import ca.bcit.comp2601.bank.Person;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        final Name b1 = new Name("jOE", "smIth");

        System.out.println(b1.getFirst());
        System.out.println(b1.getLast());
        System.out.println(b1.getInitials());
        System.out.println(b1.getFullName());

        final Date d1 = new Date(2024, 1, 25);
        final Date d2 = new Date(2024, 5, 12);

        System.out.println(d1.getYYYYMMDD());
        System.out.println(d1.getDayOfTheWeek());
        System.out.println(d1.getMonth());
        System.out.println(d1.getFormattedDate());

        final Person p1 = new Person(b1, d1, null);
        final Person p2 = new Person(b1, d1, d2);

        System.out.println(p1.getDetails());
        System.out.println(p2.getDetails());

        final BankClient bc1 = new BankClient(b1, d1, d2, d2, "12345");

        System.out.println(bc1.getDetails());
    }
}
