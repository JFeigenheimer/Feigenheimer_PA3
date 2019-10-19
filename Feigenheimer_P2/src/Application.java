public class Application
{
    public static void monthlySavings(int i, double savings)
    {
        String month = "";
        switch(i)
        {
            case 0:
                month = "January:";
                break;
            case 1:
                month = "February:";
                break;
            case 2:
                month = "March:";
            case 3:
                month = "April:";
                break;
            case 4:
                month = "May:";
                break;
            case 5:
                month = "June:";
                break;
            case 6:
                month = "July:";
                break;
            case 7:
                month = "August:";
                break;
            case 8:
                month = "September:";
                break;
            case 9:
                month = "October:";
                break;
            case 10:
                month = "November:";
                break;
            case 11:
                month = "December:";
                break;
        }
        System.out.printf("%16s %.2f\n",month,savings);
    }
    public static void main(String[] args)
    {
        SavingsAccount Saver1 = new SavingsAccount(2000);
        SavingsAccount Saver2 = new SavingsAccount(3000);
        SavingsAccount.setAnnualInterestRate(.04);

        System.out.printf("%16s \n","Account 1:");
        for (int i = 0; i < 12; i++)
        {
            Saver1.setSavingsBalance(Saver1.calculateMonthlyInterest(Saver1.getAnnualInterestRate(),
                                     Saver1.getSavingsBalance()));
            monthlySavings( i,  Saver1.getSavingsBalance());
        }
        Saver1.modifyAnnualInterestRate(.05);
        Saver1.setSavingsBalance(Saver1.calculateMonthlyInterest(Saver1.getAnnualInterestRate(),
                                 Saver1.getSavingsBalance()));
        System.out.printf("%16s %.2f\n","5% January:", Saver1.getSavingsBalance());


        System.out.printf("\n%16s \n","Account 2:");
        for (int i = 0; i < 12; i++)
        {
            Saver2.setSavingsBalance(Saver2.calculateMonthlyInterest(Saver2.getAnnualInterestRate(),
                    Saver2.getSavingsBalance()));
            monthlySavings( i,  Saver2.getSavingsBalance());
        }

        Saver2.modifyAnnualInterestRate(.05);
        Saver2.setSavingsBalance(Saver2.calculateMonthlyInterest(Saver2.getAnnualInterestRate(),
                                 Saver2.getSavingsBalance()));
        System.out.printf("%16s %.2f\n","5% January:", Saver2.getSavingsBalance());
    }
}