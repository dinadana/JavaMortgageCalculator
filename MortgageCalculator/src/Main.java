import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* Input:
        Principal between 1k to 1m
        Annual interest rate greater than 0 and less then or equals to 30
        Period (years) between 1 and 30
        Output:
        Mortgage
        NOTE: Use math.pow
        OUR EQUATION: P=principal, r=monthlyInterest
         */

        final byte monthsInYear = 12;
        final byte percent = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;
        Scanner scanner = new Scanner(System.in);


        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <=1_000_000)
                break;
            System.out.print("Enter a value between 1,000 and 1,000,000 - ");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if(annualInterest >=1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / percent / monthsInYear;
                break;
            }
            System.out.print("Enter a value between 1 and 30 - ");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte period = scanner.nextByte();
            if (period >= 1 && period <= 30) {
                numberOfPayments = period * monthsInYear;
                break;
            }
            System.out.print("Enter a value between 1 and 30 - ");
        }


        double mortgage = principal*(monthlyInterest*Math.pow(1+monthlyInterest, numberOfPayments))/(Math.pow(1+monthlyInterest, numberOfPayments)-1);

        //NumberFormat to get result in currency format
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);
    }
}