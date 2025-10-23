package es.tierno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversor implements LanzarComando {

    private static final String MSG_SCS = "Comando ejectuado";
    private static final String MSG_ERR = "Se necesita al menos dos URL para ejecutar";
    private static final int NUM_URL = 2;

    @Override
    public void ejecutar(String comando, String[] urls) throws IOException, InterruptedException {
        if (urls == null || urls.length < NUM_URL) {
            System.out.println(MSG_ERR);
            return;
        }

        List<String> cmd = new ArrayList<>();
        cmd.add(comando);
        cmd.addAll(Arrays.asList(urls));

        ProcessBuilder pb = new ProcessBuilder(cmd);
        Process proceso = pb.start();
        proceso.waitFor();

        System.out.println(MSG_SCS);
    }
}
