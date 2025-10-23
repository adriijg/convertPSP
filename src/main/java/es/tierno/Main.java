package es.tierno;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        String[] urlStrings = {"src/main/resources/entrada.jpg", "src/main/resources/salida.png"};
        String comando = "convert";

        Conversor conversor = new Conversor();
        conversor.ejecutar(comando, urlStrings);
    }
}