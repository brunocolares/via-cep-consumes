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
        ConsultaCep consultaCep = new ConsultaCep();
        Endereco endereco = consultaCep.buscaEndereco("35170250");
        System.out.println(endereco);
    }
}