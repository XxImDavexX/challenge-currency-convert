import java.io.IOException;

public class TestChallengeCurrencyConvert {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConnectToExchangeRateApi connectToExchangeRateApi = new ConnectToExchangeRateApi();
        System.out.println(connectToExchangeRateApi.getCurrencyValue("mxn"));
    }
}
