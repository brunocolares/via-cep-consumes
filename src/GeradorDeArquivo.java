import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter fileWriter = new FileWriter(endereco.cep()+".json");
        String enderecoJSON = gson.toJson(endereco);
        fileWriter.write(enderecoJSON);
        fileWriter.close();
    }
}
