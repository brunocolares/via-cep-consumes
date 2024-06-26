import com.google.gson.Gson;
import modelos.Endereco;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String cep;
        System.out.println("Digite o CEP desejado: ");
        cep = sc.nextLine();
        String enderecoURI = "http://viacep.com.br/ws/"+cep+"/json";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoURI))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String respostaJSON = response.body();
            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(respostaJSON, Endereco.class);
            System.out.println(endereco);

            FileWriter file = new FileWriter("endereco.json");
            file.write(respostaJSON);
            file.close();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}