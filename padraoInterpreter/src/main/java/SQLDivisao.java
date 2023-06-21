public class SQLDivisao implements SQLExpressao {

    private double x;
    private double y;

    public SQLDivisao(NumeroSQL elementoEsquerda, NumeroSQL elementoDireita) {
        x = elementoEsquerda.getNumero();
        y = elementoDireita.getNumero();
    }

    public double interpretar() {
        return x / y;
    }
}

