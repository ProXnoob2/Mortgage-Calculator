public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Rate of Interest: ", 1, 30);
        byte years = (byte) Console.readNumber("Period in Years: ", 1, 30);

        var mortgageCalculator =  new MortgageCalculator(principal,annualInterest, years);
        var mortgageReport =  new MortgageReport(mortgageCalculator);

        mortgageReport.printMortgage();
        mortgageReport.printPaymentSchedule();
    }
}