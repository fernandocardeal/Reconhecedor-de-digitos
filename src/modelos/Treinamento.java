package modelos;


public class Treinamento {

    public static void main(String[] args) {

        Neuronio[] neuronios = { new Neuronio(), new Neuronio() };

        double[][] entradas = {
                { 1, 1, 1, 1, 1, -1, 1, 1, 1, 1 },
                { 1, -1, 1, 1, 1, 1, -1, -1, 1, -1 },
                { 1, -1, 1, 1, 1, -1, 1, 1, 1, 1 },
                { 1, -1, -1, 1, -1, 1, 1, -1, 1, 1 }
        };

        double[][] saidasEsperadas = {
                { 1, -1 },
                { -1, 1 },
                { 1, -1 },
                { -1, 1 }
        };

        RNA redeNeural = new RNA(neuronios, entradas, saidasEsperadas);
        redeNeural.realizarTreinamento();
    }
}