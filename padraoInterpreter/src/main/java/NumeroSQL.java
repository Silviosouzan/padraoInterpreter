public class NumeroSQL implements SQLExpressao {

    private double numero;

    public NumeroSQL(double numero) {
        this.numero = numero;
    }

    public double interpretar() {
        return numero;
    }

    public double getNumero() {
        return this.numero;
    }
}