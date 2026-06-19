package modelos;

import java.util.Random;
import java.util.Arrays;

public class Neuronio {

    private double bias;
    private double[] sinapses;
    private final double TAXA_DE_APRENDIZAGEM = 0.5;
    private final int QUANTIDADE_DE_SINAPSES = 9;


    public Neuronio() {
        inicializarSinapses();
    }

    private final void inicializarSinapses() {
        Random random = new Random();
        this.bias = random.nextBoolean() ? 1 : -1;
        this.sinapses = new double[this.QUANTIDADE_DE_SINAPSES];
        for (int i = 0; i < this.sinapses.length; i++) {
            this.sinapses[i] = random.nextBoolean() ? 1 : -1;
        }
    }

    public double[] obterSinapses() {
        double[] sinapses = new double[this.sinapses.length + 1];
        sinapses[0] = bias;
        for (int i = 1; i < this.sinapses.length; i++) {
            sinapses[i] = this.sinapses[i];
        }
        return sinapses;
    }

    public double treinar(double[] entrada, double saidaEsperada) {
        double saida = bias * entrada[0];
        for (int i = 0; i < this.sinapses.length; i++) {
            saida += this.sinapses[i] * entrada[i + 1];
        }

        saida = calcularFuncaoDeAtivacao(saida);
        double erro = calcularErro(saida, saidaEsperada);
        double[] variacaoSinapses = calcularVariacaoDasSinapses(erro, entrada);

        System.out.println("Ativação: . . . " + saida);
        System.out.println("Saída esperada: " + saidaEsperada);
        System.out.println("Erro: . . . . . " + erro + "\n");

        System.out.println("Sinapses: . . . . . . . " + Arrays.toString(obterSinapses()));
        System.out.println("Variação das sinapses:  " + Arrays.toString(variacaoSinapses));
        atualizarSinapses(variacaoSinapses);
        System.out.println("Novas sinapses: . . . . " + Arrays.toString(obterSinapses()) + "\n");

        return erro;

    }

    public double calcularFuncaoDeAtivacao(double saida) {
        if (saida < 0) {
            return -1;
        }
        return 1; 
    }

    public double calcularErro(double saida, double saidaEsperada) {
        return saidaEsperada - saida;
    }

    public double[] calcularVariacaoDasSinapses(double erro, double[] entrada) {

        double[] variacaoSinapses = new double[this.sinapses.length + 1];
        for(int i = 0; i < variacaoSinapses.length; i++) {
            variacaoSinapses[i] = this.TAXA_DE_APRENDIZAGEM * erro * entrada[i];
        }
        return variacaoSinapses;
    }

    private void atualizarSinapses(double[] variacaoSinapses) {
        this.bias += variacaoSinapses[0];
        for(int i = 1; i < variacaoSinapses.length; i++) {
            this.sinapses[i - 1] += variacaoSinapses[i];  
        }
    }

}