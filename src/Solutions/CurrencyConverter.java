package Solutions;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    private static final String apiKey = "6fdeb1c0-9ca2-11ec-89cd-f9f8714170ad";
    private static final String url = "https://freecurrencyapi.net/api/v2/latest?apikey=" + apiKey + "&base_currency=";

    public static double convert(String from, String to) {
        try {
            String rates = getRates(from);
            JSONObject json = new JSONObject(rates);
            return json.getJSONObject("data").getDouble(to);
        }
        catch (JSONException e) {
            throw new IllegalArgumentException("The rate you provided isn't valid! Please enter valid currency codes!");
        }
    }

    private static String getRates(String code) {
        try {
            URL request = new URL(url + code);
            StringBuilder data = new StringBuilder();
            HttpURLConnection connection = (HttpURLConnection) request.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = reader.readLine();
                while (line != null) {
                    data.append(line);
                    line = reader.readLine();
                }
                reader.close();
                return data.toString();
            }
            else throw new Exception();
        }
        catch (Exception e) {
            return "0";
        }
    }

}