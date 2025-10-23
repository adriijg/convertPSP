package es.tierno;

import java.io.IOException;

public interface LanzarComando {
    public void ejecutar(String comando, String[] urls) throws IOException, InterruptedException;
}
