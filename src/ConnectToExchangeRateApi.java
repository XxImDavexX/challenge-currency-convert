import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectToExchangeRateApi {

    DataCurrencies getCurrencyValue (String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        baseCurrency = baseCurrency.toUpperCase();
        targetCurrency = targetCurrency.toUpperCase();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/d4ac0b3e92e54d2031666139/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount ))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson( response.body(), DataCurrencies.class);

    }
}
