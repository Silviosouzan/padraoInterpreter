import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class SQLInterpretadorExpressoes implements SQLExpressao {

    private SQLExpressao interpretadorInicial;

    public SQLInterpretadorExpressoes(String contexto) {

        Stack<SQLExpressao> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilhaInterpretadores.push(new NumeroSQL(Double.parseDouble(elemento)));
            } else if (elemento.equals("+")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                NumeroSQL elementoEsquerda = (NumeroSQL) pilhaInterpretadores.pop();
                NumeroSQL elementoDireita = new NumeroSQL(Double.parseDouble(iterator.next()));
                SQLAdicao interpretador = new SQLAdicao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new NumeroSQL(interpretador.interpretar()));
            } else if (elemento.equals("-")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                NumeroSQL elementoEsquerda = (NumeroSQL) pilhaInterpretadores.pop();
                NumeroSQL elementoDireita = new NumeroSQL(Double.parseDouble(iterator.next()));
                SQLSubtracao interpretador = new SQLSubtracao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new NumeroSQL(interpretador.interpretar()));
            } else if (elemento.equals("*")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                NumeroSQL elementoEsquerda = (NumeroSQL) pilhaInterpretadores.pop();
                NumeroSQL elementoDireita = new NumeroSQL(Double.parseDouble(iterator.next()));
                SQLMultiplicacao interpretador = new SQLMultiplicacao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new NumeroSQL(interpretador.interpretar()));
            } else if (elemento.equals("/")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                NumeroSQL elementoEsquerda = (NumeroSQL) pilhaInterpretadores.pop();
                NumeroSQL elementoDireita = new NumeroSQL(Double.parseDouble(iterator.next()));
                SQLDivisao interpretador = new SQLDivisao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new NumeroSQL(interpretador.interpretar()));
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorInicial = pilhaInterpretadores.pop();
    }

    public double interpretar() {
        return interpretadorInicial.interpretar();
    }
}

