import java.io.IOException;
import java.util.Scanner;

public class TestChallengeCurrencyConvert {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        double amount;
        String baseCurrency;
        String targetCurrency;
        System.out.println("Insert your code currency : ");
        baseCurrency = keyboard.next();
        System.out.println("Enter the currency code you want to convert to : ");
        targetCurrency = keyboard.next();
        System.out.println("Insert the amount of " + baseCurrency + " : ");
        amount = keyboard.nextDouble();
        ConnectToExchangeRateApi connectToExchangeRateApi = new ConnectToExchangeRateApi();
        Currencies currencies = new Currencies(connectToExchangeRateApi.getCurrencyValue(baseCurrency, targetCurrency, amount));
        currencies.setAmount(amount);
        System.out.println(currencies);
    }
}
