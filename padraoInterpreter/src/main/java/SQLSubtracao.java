public class SQLSubtracao implements SQLExpressao {

    private double x;
    private double y;

    public SQLSubtracao(NumeroSQL elementoEsquerda, NumeroSQL elementoDireita) {
        x = elementoEsquerda.getNumero();
        y = elementoDireita.getNumero();
    }

    public double interpretar() {
        return x - y;
    }
}
