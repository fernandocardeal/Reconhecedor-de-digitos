package modelos;

import java.util.Arrays;
import java.util.ArrayList;

public class RNA {

    private Neuronio[] neuronios;
    private double[][] entradas;
    private double[][] saidasEsperadas;
    private ArrayList<Double> erros;

    public void definirEntradas(double[][] entradas) {
        this.entradas = entradas;
    }

    public void definirSaidasEsperadas(double[][] saidasEsperadas) {
        this.saidasEsperadas = saidasEsperadas;
    }

    public RNA(Neuronio[] neuronios, double[][] entradas, double[][] saidasEsperadas) {
        this.neuronios = neuronios;
        this.entradas = entradas;
        this.saidasEsperadas = saidasEsperadas;
        this.erros = new ArrayList<>();
    }

    public void realizarTreinamento() {
        System.out.println("\n===== INICIANDO TREINAMENTO =====\n");
        for (int i = 0; i < this.entradas.length; i++) {
            for (int j = 0; j < this.neuronios.length; j++) {
                System.out.println("Treinando vetor (" + i + ") " + Arrays.toString(entradas[i]) + " para o neurônio " + j + "\n");
                this.erros.add(neuronios[j].treinar(this.entradas[i], this.saidasEsperadas[i][j]));

            }
        }
        System.out.println("Erro médio quadrático da época: " + calcularErroMedioQuadratico());
    }

    public double calcularErroMedioQuadratico() {
        double erroMedioQuadratico = 0;
        for(int i = 0; i < this.erros.size(); i++) {
            erroMedioQuadratico += this.erros.get(i) * this.erros.get(i);
        }
        erroMedioQuadratico = erroMedioQuadratico / this.erros.size();
        return erroMedioQuadratico;
    }
}
