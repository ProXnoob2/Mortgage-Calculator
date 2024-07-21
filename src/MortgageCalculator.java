public class MortgageCalculator {
    private final byte TOTAL_MONTHS = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(
            int principal,
            float annualInterest,
            byte years
    ){
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPaymentsInMonths = getNumberOfPaymentsInMonths();

        double mortgage =
                principal
                        *(monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPaymentsInMonths))
                        /(Math.pow(1 + monthlyInterest, numberOfPaymentsInMonths) - 1);

        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade){
        float monthlyInterest = getMonthlyInterest();
        short numberOfPaymentsInMonths = getNumberOfPaymentsInMonths();

        double balance =
                principal
                        *((Math.pow(1+monthlyInterest,numberOfPaymentsInMonths))
                        -(Math.pow(1+monthlyInterest, numberOfPaymentsMade)))
                        /((Math.pow(1+monthlyInterest, numberOfPaymentsInMonths))-1);

        return balance;
    }

    public double[] getBalances(){
        var balances = new double[getNumberOfPaymentsInMonths()];
        for(short month = 1; month <= balances.length; month++)
            balances[month-1] = calculateBalance(month);
        return balances;
    }

    private short getNumberOfPaymentsInMonths() {
        return (short) (years * TOTAL_MONTHS);
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / TOTAL_MONTHS;
    }
}
