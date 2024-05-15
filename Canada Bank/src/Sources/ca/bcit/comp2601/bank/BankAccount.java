package ca.bcit.comp2601.bank;

/**
 * @author walter chu & margaryta lvova
 * @version 1.0
 */
public class BankAccount
{
    final  BankClient client;
    final  String     accountNumber;
    final  Date       accountOpened;
    final  Date       accountClosed;
    int               pin;
    double            balanceUSD;

    public BankAccount(final BankClient client,
                       final String     accountNumber,
                       final Date       accountOpened,
                       final Date       accountClosed,
                       final int        pin,
                       final double     balanceUSD)
    {
        if(accountNumber.matches("^[a-zA-Z]{7}$"))
        {
            this.accountNumber = accountNumber;
        }
        else
        {
            throw new IllegalArgumentException("The account number must be 7 letters.");
        }

        this.client        = client;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.pin           = pin;
        this.balanceUSD    = balanceUSD;
    }

    public BankClient getClient()
    {
        return client;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public Date getAccountOpened()
    {
        return accountOpened;
    }

    public Date getAccountClosed()
    {
        return accountClosed;
    }

    public int getPin()
    {
        return pin;
    }

    public double getBalanceUSD()
    {
        return balanceUSD;
    }

    public void withdraw(final double amountUsd)
    {
        if(this.balanceUSD >= amountUsd)
        {
            this.balanceUSD = this.balanceUSD - amountUsd;
        }
        else
        {
            System.out.println("There are not enough funds in the account to withdraw $" + amountUsd + ".");
        }
    }

    public void withdraw(final double amountUsd,
                         final int pinToMatch)
    {
        if(pinToMatch == this.pin)
        {
            if(this.balanceUSD >= amountUsd)
            {
                this.balanceUSD = this.balanceUSD - amountUsd;
            }
            else
            {
                System.out.println("There are not enough funds in the account to withdraw $" + amountUsd + ".");
            }
        }
        else
        {
            System.out.println("The wrong pin was provided.");
        }
    }
}
