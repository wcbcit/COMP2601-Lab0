package ca.bcit.comp2601.bank;

/**
 * @author walter chu & margaryta lvova
 * @version 1.0
 */
public class Person
{
    final Name name;
    final Date dateBorn;
    final Date dateDied;

    public Person(final Name name,
                  final Date dateBorn,
                  final Date dateDied)
    {
        if(dateDied == null)
        {
            this.dateDied = null;
        }
        else if(Integer.parseInt(String.format("%04d%02d%02d", dateDied.getYear(), dateDied.getMonth(), dateDied.getDay())) <
                Integer.parseInt(String.format("%04d%02d%02d", dateBorn.getYear(), dateBorn.getMonth(), dateBorn.getDay())))
        {
            throw new IllegalArgumentException("The date of death cannot be less than the date born.");
        }
        else
        {
            this.dateDied = dateDied;
        }

        this.name     = name;
        this.dateBorn = dateBorn;
    }

    public Name getName()
    {
        return name;
    }

    public Date getDateBorn()
    {
        return dateBorn;
    }

    public Date getDateDied()
    {
        return dateDied;
    }

    public String getDetails()
    {
        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(this.name.getFullName());
        builder.append(" (");

        if(this.isAlive())
        {
            builder.append("alive");
        }
        else
        {
            builder.append("died " + this.dateDied.getDayOfTheWeek().toLowerCase() + ", " + this.dateDied.getFormattedDate());
        }

        builder.append(") was born on " + dateBorn.getDayOfTheWeek().toLowerCase() + ", " + this.dateBorn.getFormattedDate() + "!");

        return builder.toString();
    }

    public boolean isAlive()
    {
        return this.dateDied == null;
    }
}
