package ca.bcit.comp2601.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walter chu & margaryta lvova
 * @version 1.0
 */
public class Bank
{
    public static final int MIN_BALANCE = 0;

    final Person                 CEO;
    final ArrayList<BankAccount> bankAccounts;

    public Bank(final Person CEO,
                final ArrayList<BankAccount> references)
    {
        this.CEO          = CEO;
        this.bankAccounts = references;
    }

    public Person getCEO()
    {
        return CEO;
    }

    public ArrayList<BankAccount> getReferences()
    {
        return bankAccounts;
    }

    public void addAccount(final BankAccount bankAccount)
    {
        bankAccounts.add(bankAccount);
    }

    public void removeAccount(final BankAccount bankAccount)
    {
        bankAccounts.remove(bankAccount);
    }

    /**
     * A method to get all account numbers in the bank.
     * @return returns an array list with all account numbers.
     */
    public ArrayList<String> getAllAccount()
    {
        final ArrayList<String> allAccountNumbers;
        allAccountNumbers = new ArrayList<>();

        for(final BankAccount account: bankAccounts)
        {
            allAccountNumbers.add(account.getAccountNumber());
        }

        return allAccountNumbers;
    }

    /**
     * A method to get bank account with the biggest balance.
     * @return returns a bank account.
     */
    public BankAccount getMaxAccount()
    {
        double biggestBalance;
        BankAccount accountWithTheBiggestBalance;

        biggestBalance = MIN_BALANCE;
        accountWithTheBiggestBalance = null;

        for(final BankAccount account: bankAccounts)
        {
            if(account.getBalanceUSD() > biggestBalance)
            {
                biggestBalance = account.getBalanceUSD();
                accountWithTheBiggestBalance = account;
            }
        }

        return accountWithTheBiggestBalance;
    }

    /**
     * A method to find an account that belongs to a specific client.
     * @param clientID Client's ID.
     * @return Returns a bank account that belongs to the client.
     */
    public BankAccount getAccountFor(final String clientID)
    {
        if(clientID == null || clientID.isBlank())
        {
            throw new IllegalArgumentException("Invalid client ID");
        }

        BankAccount accountForClient;
        accountForClient = null;

        for(final BankAccount account: bankAccounts)
        {
            if(account.getClient().getClientID().equalsIgnoreCase(clientID))
            {
                accountForClient = account;
            }
        }

        return accountForClient;
    }
}
