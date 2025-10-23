package es.tierno;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConversorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Conversor conversor;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        conversor = new Conversor();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testEjecutarConUrlsNulas() throws IOException, InterruptedException {
        String comando = "echo";
        String[] urls = null;

        conversor.ejecutar(comando, urls);

        assertTrue(outContent.toString().contains("Se necesita al menos dos URL para ejecutar"),
                "Debería imprimir mensaje de error si urls es null");
    }

    @Test
    void testEjecutarConUrlsInsuficientes() throws IOException, InterruptedException {
        String comando = "echo";
        String[] urls = {"entrada.jpg"};

        conversor.ejecutar(comando, urls);

        assertTrue(outContent.toString().contains("Se necesita al menos dos URL para ejecutar"),
                "Debería imprimir mensaje de error si urls tiene menos de NUM_URL elementos");
    }
}
