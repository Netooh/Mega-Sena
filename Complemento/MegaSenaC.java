package Aula01; // Define o pacote onde a classe está localizada.

import java.util.Random; // Importa a classe Random para gerar números aleatórios.
import java.util.Scanner; // Importa a classe Scanner para leitura de dados do usuário.

public class MegaSenaC{ // Declaração da classe principal MegaSena.

    public static void main(String[] args) { // Método principal onde a execução do programa começa.
        asciiart(); // Chama o método asciiart para imprimir uma arte ASCII no console.
        System.out.println("\n\n------------------------------------------------");
        System.out.println("                    |CARTELA|"); // Imprime um cabeçalho para a cartela.
        int[][] cartao = criarCartao(6, 10); // Cria uma matriz de 6x10 para representar a cartela de números.
        System.out.println("------------------------------------------------");
        imprimirCartao(cartao); // Imprime a cartela gerada.
        System.out.println("------------------------------------------------");
        
        // Obtém as dezenas escolhidas pelo jogador e as dezenas sorteadas aleatoriamente.
        int[] dezenasEscolhidas = obterDezenasDoJogador(), dezenasSorteadas = obterDezenasSorteadas();
        
        System.out.println("\n-----------------------------------------------");
        System.out.print("                |NÚMEROS ESCOLHIDOS|\n ");
        imprimeNumerosEscolhidos(dezenasEscolhidas); // Imprime os números escolhidos pelo jogador.
        System.out.println("\n------------------------------------------------");
        System.out.println("                  |CARTELA MARCADA|");
        System.out.println("------------------------------------------------");
        imprimirCartao(cartao, dezenasEscolhidas); // Imprime a cartela marcando os números escolhidos pelo jogador.
        System.out.println("\n-------------------------------------------------");
        System.out.print("                |NÚMEROS SORTEADOS|\n ");
        imprimeNumerosEscolhidos(dezenasSorteadas); // Imprime os números sorteados.
        System.out.println("\n-------------------------------------------------");
        System.out.println("                 |RESULTADO FINAL|\n ");
        conferirNumeros(dezenasEscolhidas, dezenasSorteadas); // Verifica quantos números o jogador acertou.

    }

    // Método para criar a cartela de números, preenchendo-a de 1 a 60.
    public static int[][] criarCartao(int lin, int col) {
        int[][] cartao = new int[lin][col]; // Cria uma matriz 2D com o tamanho especificado.
        for (int iL = 0, num = 1; iL < cartao.length; iL++) { // Itera sobre as linhas da matriz.
            for (int iC = 0; iC < cartao[iL].length; iC++) { // Itera sobre as colunas da matriz.
                cartao[iL][iC] = num; // Atribui o número à posição atual da matriz.
                num++; // Incrementa o número para a próxima posição.
            }
        }
        return cartao; // Retorna a matriz preenchida.
    }

    // Método para obter 6 números sorteados aleatoriamente, garantindo que não se repitam.
    public static int[] obterDezenasSorteadas() {
        Random rd = new Random(); // Cria uma instância da classe Random.
        int[] sorteados = new int[6]; // Cria um array para armazenar os 6 números sorteados.
        int num = 0; // Variável para armazenar o número sorteado.

        for (int i = 0; i < sorteados.length; i++) { // Itera para gerar 6 números.

            while (true) {
                num = rd.nextInt(60) + 1; // Gera um número aleatório entre 1 e 60.
                boolean numeroJaGerado = false; // Variável para verificar se o número já foi gerado.
                for (int l = 0; l < i; l++) { // Verifica se o número já foi sorteado anteriormente.
                    if (sorteados[l] == num) { 
                        numeroJaGerado = true; 
                        break; 
                    }
                }

                if (!numeroJaGerado) { 
                    sorteados[i] = num; // Se o número não foi gerado antes, adiciona ao array.
                    break; // Sai do loop.
                }
            }
        }
        return sorteados; // Retorna o array com os números sorteados.
    }

    // Método para obter os 6 números escolhidos pelo jogador.
    public static int[] obterDezenasDoJogador() {
        Scanner sc = new Scanner(System.in); // Cria uma instância da classe Scanner para entrada de dados.
        int[] numeros = new int[6]; // Cria um array para armazenar os 6 números escolhidos.
        int num = 0; // Variável para armazenar o número escolhido.

        for (int i = 0; i < numeros.length; i++) { // Itera para coletar 6 números do jogador.

            while (true) {
                System.out.print("Marque o primeiro " + (i + 1) + "º número da Cartela: "); // Solicita ao jogador que insira um número.
                num = sc.nextInt(); // Lê o número inserido pelo jogador.

                if (!(num >= 1 && num <= 60)) { // Verifica se o número está no intervalo válido (1 a 60).
                    System.out.println("Valor fora do intervalo, tente novamente ...");
                    continue; // Se não estiver, solicita novamente.
                }

                boolean numeroJaMarcado = false; // Verifica se o número já foi marcado anteriormente.
                for (int l = 0; l < i; l++) {
                    if (numeros[l] == num) {
                        System.out.println("Número já marcado, tente novamente ...");
                        numeroJaMarcado = true;
                        break;
                    }
                }

                if (!numeroJaMarcado) {
                    numeros[i] = num; // Se o número não foi marcado, adiciona ao array.
                    break; // Sai do loop.
                }
            }
        }

        return numeros; // Retorna o array com os números escolhidos.
    }

    // Método para imprimir os números escolhidos ou sorteados.
    public static void imprimeNumerosEscolhidos(int[] vet) {
        System.out.print("                  ");
        for (int i = 0; i < vet.length; i++) { // Itera sobre o array de números.
            System.out.print(vet[i] + " "); // Imprime cada número seguido de um espaço.
        }
    }

    // Método para imprimir a cartela de números.
    public static void imprimirCartao(int[][] cartao) {
        for (int il = 0; il < cartao.length; il++) { // Itera sobre as linhas da matriz.
            for (int ic = 0; ic < cartao[il].length; ic++) { // Itera sobre as colunas da matriz.
                System.out.print("[" + (cartao[il][ic] < 10 ? "0" : "") + cartao[il][ic] + "] "); // Imprime o número com formatação.
            }
            System.out.println(); // Quebra de linha após cada linha da matriz.
        }
    }

    // Método para imprimir a cartela de números, marcando os números escolhidos pelo jogador.
    public static void imprimirCartao(int[][] cartao, int[] dezenasDoUsuario) {
        for (int il = 0; il < cartao.length; il++) { // Itera sobre as linhas da matriz.
            for (int ic = 0; ic < cartao[il].length; ic++) { // Itera sobre as colunas da matriz.
                System.out.print(
                        delimitador(cartao[il][ic], dezenasDoUsuario, true) + "" + (cartao[il][ic] < 10 ? "0" : "")
                                + cartao[il][ic] + "" + delimitador(cartao[il][ic], dezenasDoUsuario, false) + " ");
            }
            System.out.println(); // Quebra de linha após cada linha da matriz.
        }
    }

    // Método para adicionar um delimitador "+" aos números escolhidos na cartela.
    public static String delimitador(int valor, int[] valores, boolean tipo) {
        for (int i = 0; i < valores.length; i++) { // Itera sobre o array de números escolhidos.
            if (valor == valores[i])
                return (tipo ? "+" : "+"); // Se o número está no array, retorna "+" para marcar o número.
        }
        return (tipo ? "[" : "]"); // Caso contrário, retorna os colchetes normais.
    }

    // Método para verificar quantos números o jogador acertou.
    public static void conferirNumeros(int[] dezenasEscolhidas, int[] dezenasSorteadas) {

        int c = 0; // Contador para os acertos.
        int[] conferirNumeros = new int[dezenasEscolhidas.length]; // Array para armazenar os números acertados.

        for (int i = 0; i < dezenasEscolhidas.length; i++) { // Itera sobre os números escolhidos.
            for (int j = 0; j < dezenasSorteadas.length; j++) { // Itera sobre os números sorteados.
                if (dezenasEscolhidas[i] == dezenasSorteadas[j]) { // Verifica se há um acerto.
                    conferirNumeros[c]

 = dezenasEscolhidas[i]; // Adiciona o número acertado ao array.
                    c++; // Incrementa o contador de acertos.
                    break; // Sai do loop para não contar o mesmo número mais de uma vez.
                }
            }
        }

        System.out.println("            Você acertou " + c + " número(s)."); // Imprime o número de acertos.
        System.out.println("                Números acertados: ");
        System.out.print("                   ");
        for (int i = 0; i < c; i++) { // Imprime os números acertados.
            System.out.print(conferirNumeros[i] + " ");
        }
        System.out.println(); // Quebra de linha após os números.
    }

    // Método para imprimir a arte ASCII.
    public static void asciiart() {
        String[] asciiArt = { " __  __ _____ ____    _      ____  _____ _   _    _    ",
                "|  \\/  | ____/ ___|  / \\    / ___|| ____| \\ | |  / \\   ",
                "| |\\/| |  _|| |  _  / _ \\   \\___ \\|  _| |  \\| | / _ \\  ",
                "| |  | | |__| |_| |/ ___ \\   ___) | |___| |\\  |/ ___ \\ ",
                "|_|  |_|_____\\____/_/   \\_\\ |____/|_____|_| \\_/_/   \\_\\" };

        for (String line : asciiArt) { // Itera sobre cada linha da arte ASCII.
            System.out.println(line); // Imprime cada linha.
        }
    }
}