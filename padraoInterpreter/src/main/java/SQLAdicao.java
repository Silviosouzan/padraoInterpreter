public class SQLAdicao implements SQLExpressao {

    private double x;
    private double y;

    public SQLAdicao(NumeroSQL elementoEsquerda, NumeroSQL elementoDireita) {
        x = elementoEsquerda.getNumero();
        y = elementoDireita.getNumero();
    }

    public double interpretar() {
        return x + y;
    }
}