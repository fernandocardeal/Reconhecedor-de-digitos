package modelos;

public class Treinamento {

    public static void main(String[] args) {

        Neuronio[] neuronios = { new Neuronio(), new Neuronio() };

        double[][] entradas = {
                { 1, 1, 1, 1, 1, -1, 1, 1, 1, 1 },
                { 1, -1, 1, 1, 1, 1, -1, -1, 1, -1 },
                { 1, -1, 1, 1, 1, -1, 1, 1, 1, 1 },
                { 1, -1, -1, 1, -1, 1, 1, -1, 1, 1 },
                { 1, 1, 1, -1, -1, 1, -1, 1, 1, 1 }

        };

        double[][] testeEntrada = {
                { 1, 1, 1, -1, -1, 1, -1, 1, 1, 1 }
        };
        double[][] testeSaida = {
            {-1, 1}
        };

        double[][] saidasEsperadas = {
                { 1, -1 },
                { -1, 1 },
                { 1, -1 },
                { -1, 1 },
                { -1, 1 },
                { -1, 1 }

        };

        RNA redeNeural = new RNA(neuronios, entradas, saidasEsperadas);
        for (int i = 0; i < 1000; i++) {
            redeNeural.realizarTreinamento();
        }
        redeNeural.definirEntradas(testeEntrada);
        redeNeural.definirSaidasEsperadas(testeSaida);
        redeNeural.realizarTreinamento();
    }
}