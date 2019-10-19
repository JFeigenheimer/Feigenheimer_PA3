public class SavingsAccount
{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }

    public static void modifyAnnualInterestRate(double annualInterestRate)
    {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate)
    {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public double getSavingsBalance()
    {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }

    public double calculateMonthlyInterest(double annualInterestRate, double savingsBalance)
    {
        double savings = savingsBalance;
        savings += ((savings * annualInterestRate) / 12);

        return savings;
    }
}
