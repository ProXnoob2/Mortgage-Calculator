import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator mortgageCalculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();
        String finalFormattedMortgage = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE\n------------");
        System.out.println("Monthly Payment: " +finalFormattedMortgage);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("Payment Schedule\n--------------------");
        for(double balance: mortgageCalculator.getBalances())
            System.out.println(currency.format(balance));
    }
}
