package Aula01;

import java.util.Random;
import java.util.Scanner;

public class MegaSena {

	public static void main(String[] args) {
		asciiart();
		System.out.println("\n\n------------------------------------------------");
		System.out.println("                    |CARTELA|");
		int[][] cartao = criarCartao(6, 10);
		System.out.println("------------------------------------------------");
		imprimirCartao(cartao);
		System.out.println("------------------------------------------------");
		int[] dezenasEscolhidas = obterDezenasDoJogador(), dezenasSorteadas = obterDezenasSorteadas();
		System.out.println("\n-----------------------------------------------");
		System.out.print("                |NÚMEROS ESCOLHIDOS|\n ");
		imprimeNumerosEscolhidos(dezenasEscolhidas);
		System.out.println("\n------------------------------------------------");
		System.out.println("                  |CARTELA MARCADA|");
		System.out.println("------------------------------------------------");
		imprimirCartao(cartao, dezenasEscolhidas);
		System.out.println("\n-------------------------------------------------");
		System.out.print("                |NÚMEROS SORTEADOS|\n ");
		imprimeNumerosEscolhidos(dezenasSorteadas);
		System.out.println("\n-------------------------------------------------");
		System.out.println("                 |RESULTADO FINAL|\n ");
		conferirNumeros(dezenasEscolhidas, dezenasSorteadas);

	}

	public static int[][] criarCartao(int lin, int col) {
		int[][] cartao = new int[lin][col];
		for (int iL = 0, num = 1; iL < cartao.length; iL++) {
			for (int iC = 0; iC < cartao[iL].length; iC++) {
				cartao[iL][iC] = num;
				num++;
			}
		}
		return cartao;
	}

	public static int[] obterDezenasSorteadas() {
		Random rd = new Random();
		int[] sorteados = new int[6];
		int num = 0;

		for (int i = 0; i < sorteados.length; i++) {

			while (true) {

				num = rd.nextInt(60) + 1;
				boolean numeroJaGerado = false;
				for (int l = 0; l < i; l++) {
					if (sorteados[l] == num) {
						numeroJaGerado = true;
						break;
					}
				}

				if (!numeroJaGerado) {
					sorteados[i] = num;
					break;
				}

			}
		}
		return sorteados;
	}

	public static int[] obterDezenasDoJogador() {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[6];
		int num = 0;

		for (int i = 0; i < numeros.length; i++) {

			while (true) {

				System.out.print("Marque o primeiro " + (i + 1) + "º número da Cartela: ");
				num = sc.nextInt();

				if (!(num >= 1 && num <= 60)) {
					System.out.println("Valor fora do intervalo, tente novamente ...");
					continue;
				}

				boolean numeroJaMarcado = false;
				for (int l = 0; l < i; l++) {
					if (numeros[l] == num) {
						System.out.println("Número já marcado, tente novamente ...");
						numeroJaMarcado = true;
						break;
					}
				}

				if (!numeroJaMarcado) {
					numeros[i] = num;
					break;
				}

			}
		}

		return numeros;
	}

	public static void imprimeNumerosEscolhidos(int[] vet) {
		System.out.print("                  ");
		for (int i = 0; i < vet.length; i++) {
			System.out.print(vet[i] + " ");
		}
	}

	public static void imprimirCartao(int[][] cartao) {
		for (int il = 0; il < cartao.length; il++) {
			for (int ic = 0; ic < cartao[il].length; ic++) {
				System.out.print("[" + (cartao[il][ic] < 10 ? "0" : "") + cartao[il][ic] + "] ");
			}
			System.out.println();
		}
	}

	public static void imprimirCartao(int[][] cartao, int[] dezenasDoUsuario) {
		for (int il = 0; il < cartao.length; il++) {
			for (int ic = 0; ic < cartao[il].length; ic++) {
				System.out.print(
						delimitador(cartao[il][ic], dezenasDoUsuario, true) + "" + (cartao[il][ic] < 10 ? "0" : "")
								+ cartao[il][ic] + "" + delimitador(cartao[il][ic], dezenasDoUsuario, false) + " ");
			}
			System.out.println();
		}
	}

	public static String delimitador(int valor, int[] valores, boolean tipo) {
		for (int i = 0; i < valores.length; i++) {
			if (valor == valores[i])
				return (tipo ? "+" : "+");
		}
		return (tipo ? "[" : "]");
	}

	public static void conferirNumeros(int[] dezenasEscolhidas, int[] dezenasSorteadas) {

		int c = 0;
		int[] conferirNumeros = new int[dezenasEscolhidas.length];

		for (int i = 0; i < dezenasEscolhidas.length; i++) {
			for (int j = 0; j < dezenasSorteadas.length; j++) {
				if (dezenasEscolhidas[i] == dezenasSorteadas[j]) {
					conferirNumeros[c] = dezenasEscolhidas[i];
					c++;
					break;
				}
			}
		}

		System.out.println("            Você acertou " + c + " número(s).");
		System.out.println("                Números acertados: ");
		System.out.print("                   ");
		for (int i = 0; i < c; i++) {
			System.out.print(conferirNumeros[i] + " ");
		}
		System.out.println();
	}

	public static void asciiart() {
		String[] asciiArt = { " __  __ _____ ____    _      ____  _____ _   _    _    ",
				"|  \\/  | ____/ ___|  / \\    / ___|| ____| \\ | |  / \\   ",
				"| |\\/| |  _|| |  _  / _ \\   \\___ \\|  _| |  \\| | / _ \\  ",
				"| |  | | |__| |_| |/ ___ \\   ___) | |___| |\\  |/ ___ \\ ",
				"|_|  |_|_____\\____/_/   \\_\\ |____/|_____|_| \\_/_/   \\_\\" };

		for (String line : asciiArt) {
			System.out.println(line);
		}
	}
}