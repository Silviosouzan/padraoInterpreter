import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoSQLTest {

    @Test
    void deveCalcularExpressaoComFormula() {
        AlunoSQL aluno = new AlunoSQL();
        aluno.setNota1(2.0);
        aluno.setNota2(5.0);

        assertEquals(9.0, aluno.calcularNota());
    }

}