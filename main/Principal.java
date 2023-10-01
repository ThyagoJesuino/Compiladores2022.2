package main;

import java.util.LinkedList;
import analisadorLexico.AnalisadorLexico;
import analisadorLexico.Token;
import analisadorSintatico.AnalisadorSintatico;
import exceptions.AnaliseException;

public class Principal {

	public static void main(String[] args) {
		LinkedList<Token> tokens = null;
		try {
			//Adicionar origem onde o textfile.txt esta localizado no PC do usuario.
			tokens = AnalisadorLexico.parceLexico("textfile.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Analise Lexica: ");
		 for (Token token : tokens) {
		 System.out.println(token);
		 }
		 

		try {
			System.out.println();
			System.out.printf("Analise Sintatica: ");
			AnalisadorSintatico as = new AnalisadorSintatico(tokens);
			as.progremaSOL();
			System.out.println();
			as.result();
		} catch (Exception e) {
			AnaliseException exception = new AnaliseException();
		}

	}

}
