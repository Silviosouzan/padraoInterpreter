import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SQLInterpretadorExpressoesTest {

    @Test
    void deveCalcularExpressaoSoma() {
        SQLInterpretadorExpressoes interpretador = new SQLInterpretadorExpressoes("6 + 2");
        assertEquals(8.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoSubtracao() {
        SQLInterpretadorExpressoes interpretador = new SQLInterpretadorExpressoes("6 - 2");
        assertEquals(4.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoMultiplicacao() {
        SQLInterpretadorExpressoes interpretador = new SQLInterpretadorExpressoes("6 * 2");
        assertEquals(12.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoDivisao() {
        SQLInterpretadorExpressoes interpretador = new SQLInterpretadorExpressoes("6 / 2");
        assertEquals(3.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoCombinada() {
        SQLInterpretadorExpressoes interpretador = new SQLInterpretadorExpressoes("10 / 2 * 3 + 1 - 4");
        assertEquals(12.0, interpretador.interpretar());
    }

    @Test
    void deveRetornarExcecaoElementoInvalido() {
        try {
            SQLInterpretadorExpressoes interpretador = new SQLInterpretadorExpressoes("2 ^ 2");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Expressão com elemento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoInvalida() {
        try {
            SQLInterpretadorExpressoes interpretador = new SQLInterpretadorExpressoes("2 +");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Expressão inválida", e.getMessage());
        }
    }

}
