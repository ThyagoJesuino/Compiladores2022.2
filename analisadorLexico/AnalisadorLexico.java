package analisadorLexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import exceptions.LexicalParseException;

public class AnalisadorLexico {

	public final static char LINE_TOKEN = '�';

	static String RESERVED_WORD[] = { "programaSOL", "Explore", "Present", "Interact", "Critique", "visualizarpdf", "visualizarvídeo", "videoconferencia", "whatsappweb", "email",
		"browser", "navegador"};
	static String TEMPO[] = {"quinzemim", "vintemim", "umahora", "umdia", "doisdias", "semlimite"};
	static String NAOTERMINAL[] = {"loop"};
	static String[] SYMBOLS = {";"};
	
	public static LinkedList<Token> parceLexico(String file) throws Exception {
		LinkedList<Token> tokenlist = new LinkedList<>();
		StringBuffer string = bufferFile(file);

		int lineCount = 1;

		String buffer = "";
		String lineBuffer = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);

			if (Character.valueOf(c).equals(LINE_TOKEN)) {
				lineCount++;
				lineBuffer = "";
				continue;
			}

			if (Character.isLetter(c)) {
				while (Character.isLetter(c)) {
					buffer += c;
					lineBuffer += c;
					i++;
					c = string.charAt(i);
				}
				i--;
				/*tokenlist.add(new Token(lineCount,
						contains(buffer, RESERVED_WORD) ? Token.RESERVED_WORD_TOKEN : Token.TEMPO , buffer));*/

				if(contains(buffer, RESERVED_WORD)){
					tokenlist.add(new Token(lineCount, Token.RESERVED_WORD_TOKEN, buffer));
				}
				else if(contains(buffer, TEMPO)){
					tokenlist.add(new Token(lineCount, Token.TIME, buffer));
				}
				else if(contains(buffer, NAOTERMINAL)){
					tokenlist.add(new Token(lineCount, Token.NONTERMINAL, buffer));
				}
						
				buffer = "";
				continue;
			}

			if (Character.isDigit(c)) {
				while (Character.isDigit(c)) {
					buffer += c;
					lineBuffer += c;
					i++;
					c = string.charAt(i);
				}
				i--;
				tokenlist.add(new Token(lineCount, Token.INTEGER_TOKEN, buffer));
				buffer = "";
				continue;
			}
			
			if (contains(String.valueOf(c), SYMBOLS)) {
				tokenlist.add(new Token(lineCount, Token.SYMBOL_TOKEN, String.valueOf(c)));
				lineBuffer += c;
				continue;
			}

			if (c != ' ' && (int) c > 60) {
				throw new LexicalParseException(lineCount, lineBuffer, c);
			}
			lineBuffer += c;
		}

		return tokenlist;
	}

	public static boolean contains(String s, String v[]) {
		for (int i = 0; i < v.length; i++) {
			if (v[i].equals(s))
				return true;
		}
		return false;
	}

	public static StringBuffer bufferFile(String file) {
		StringBuffer string = null;
		try {
			string = new StringBuffer();
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			if (line != null) {
				string.append(line);
				string.append(LINE_TOKEN);
			}
			while (line != null) {
				line = bufferedReader.readLine();
				if (line != null) {
					string.append(line);
					string.append(LINE_TOKEN);
				}

			}
			fileReader.close();
		} catch (IOException e) {
			System.err.printf("[Err0] Open File: %s.\n", e.getMessage());
			return null;
		}
		return string;
	}

}
