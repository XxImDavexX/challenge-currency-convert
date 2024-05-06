import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TestChallengeCurrencyConvert {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        double amount;
        String baseCurrency="";
        String targetCurrency="";
        MenuCurrency menuCurrency = new MenuCurrency();
        boolean loop = true;
        int option = 0;
        while (loop) {
            System.out.println("------------ MENU ------------");
            System.out.println("""
                1. Convert USD to MXN.
                2. Convert MXN to USD.
                3. Convert EUR to MXN.
                4. Convert MXN to EUR.
                5. Convert USD to EUR.
                6. Convert EUR to USD.
                7. Select this option if you need insert different currencies.
                8. Show all code currencies (If you don't know the currency codes, take a look at this table).
                9. EXIT.
                """);
            System.out.println("Select a option: ");
            option = keyboard.nextInt();
            switch (option){
                case 1:
                    baseCurrency = "usd";
                    targetCurrency = "mxn";
                    break;
                case 2:
                    baseCurrency = "mxn";
                    targetCurrency = "usd";
                    break;
                case 3:
                    baseCurrency = "eur";
                    targetCurrency = "mxn";
                    break;
                case 4:
                    baseCurrency = "mxn";
                    targetCurrency = "eur";
                    break;
                case 5:
                    baseCurrency = "usd";
                    targetCurrency = "eur";
                    break;
                case 6:
                    baseCurrency = "eur";
                    targetCurrency = "usd";
                    break;
                case 7:
                    System.out.println("Insert your code currency : ");
                    baseCurrency = keyboard.next();
                    System.out.println("Enter the currency code you want to convert to : ");
                    targetCurrency = keyboard.next();
                    break;
                case 8:
                    System.out.println("Look up yours code currencies in the next table ---->");
                    System.out.println(menuCurrency.showMenuCurrency());
                    break;
                case 9:
                    loop = false;
                    break;
            }
            if(option != 8 && option != 9) {
                System.out.println("Insert the amount of " + baseCurrency + " : ");
                amount = keyboard.nextDouble();
                ConnectToExchangeRateApi connectToExchangeRateApi = new ConnectToExchangeRateApi();
                Currencies currencies = new Currencies(connectToExchangeRateApi.getCurrencyValue(baseCurrency, targetCurrency, amount));
                currencies.setAmount(amount);
                System.out.println(currencies);
            }

        }
        System.out.println("------------ PROGRAM FINISHED ------------ ");





    }
}
