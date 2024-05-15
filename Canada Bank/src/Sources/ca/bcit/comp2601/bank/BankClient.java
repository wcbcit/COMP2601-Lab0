package ca.bcit.comp2601.bank;

/**
 * @author walter chu & margaryta lvova
 * @version 1.0
 */
public class BankClient extends Person
{
    final Date joinedBank;
    final String clientID;

    public BankClient(final Name name,
                      final Date dateBorn,
                      final Date dateDied,
                      final Date joinedBank,
                      final String clientID)
    {
        super(name, dateBorn, dateDied);

        this.joinedBank = joinedBank;
        this.clientID   = clientID;
    }

    public Date getJoinedBank()
    {
        return joinedBank;
    }

    public String getClientID()
    {
        return clientID;
    }

    @Override
    public String getDetails()
    {
        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(this.name.getFullName());
        builder.append(" client #" + this.clientID);
        builder.append(" (");

        if(this.isAlive())
        {
            builder.append("alive");
        }
        else
        {
            builder.append("not alive");
        }

        builder.append(") joined the bank on " + joinedBank.getDayOfTheWeek().toLowerCase() + ", " + this.joinedBank.getFormattedDate() + ".");

        return builder.toString();
    }
}
