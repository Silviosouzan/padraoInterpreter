public class EscolaSQL {

    public static String formula = "nota1 * 2 + nota2";

    public static double calcularNota(double nota1, double nota2) {
        String expressao;
        expressao = formula.replace("nota1", Double.toString(nota1));
        expressao = expressao.replace("nota2", Double.toString(nota2));
        SQLExpressao interpretador = new SQLInterpretadorExpressoes(expressao);
        return interpretador.interpretar();
    }
}