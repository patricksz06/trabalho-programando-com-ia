import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CEPService {
    public static String getAddress(String cep) {
        try {
            String apiURL = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(apiURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            JSONObject json = new JSONObject(content.toString());
            return json.getString("logradouro") + ", " + json.getString("bairro") + ", " + json.getString("localidade") + " - " + json.getString("uf");
        } catch (Exception e) {
            return "Endereço não encontrado.";
        }
    }
}
