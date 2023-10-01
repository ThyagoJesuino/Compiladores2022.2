package analisadorSintatico;

import java.util.LinkedList;
import analisadorLexico.Token;
import java.net.URI;
import java.awt.Desktop;

public class AnalisadorSintatico {
	int i;
	boolean testa = false;
	boolean operador = false;
	int aux;

	private LinkedList<Token> tokens;

	public void result() {
		if (testa) {
			System.out.println("Analise sintatica correta");
		}
		 else {
			System.out.println("Analise sintatica incorreta verifique sua entrada;");
		}
	}

	public Token getToken(int i) {
		for (i = aux; i < tokens.size(); i++) {
			return tokens.get(i);
		}
		return null;
	}

	public AnalisadorSintatico(LinkedList<Token> tokens) {
		super();
		this.i = 0;
		this.tokens = tokens;
		this.testa = false;
		this.aux = i;
	}
	public void progremaSOL() {
		if (tokens.get(i).getValor().equals("programaSOL")) {
			getToken(i++);
			if (tokens.get(i).getValor().equals("loop")){
				getToken(i++);
				vezes();
				sequencia();
				if (tokens.get(i).getValor().equals(";")) {
					testa = true;
				}
			}
		}
	}
	public void vezes(){
		if (tokens.get(i).getTipo().equals(Token.INTEGER_TOKEN)){
			getToken(i++);
		}
	}
	public void sequencia(){
		fasesEPIC();
		tempo();
	}
	public void fasesEPIC(){
		if (tokens.get(i).getValor().equals("Explore")){
			getToken(i++);
			explore();
		}
		if (tokens.get(i).getValor().equals("Present")){
			getToken(i++);
			present();
		}
		if (tokens.get(i).getValor().equals("Interact")){
			getToken(i++);
			interact();
		}
		if (tokens.get(i).getValor().equals("Critique")){
			getToken(i++);
			critique();
		}
	}
	public void explore(){
		//Abrir o navegador
		if (tokens.get(i).getValor().equals("navegador")){
			getToken(i++);
			try{
				URI link = new URI("www.google.com");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
			tempo();
		}
	}
	public void present(){
		//Abrir Drive
		if (tokens.get(i).getValor().equals("visualizarpdf")){
			getToken(i++);
			try{
				URI link = new URI("https://drive.google.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
		}
		//Abrir Youtube
		else if (tokens.get(i).getValor().equals("visualizarvideo")){
			getToken(i++);
			try{
				URI link = new URI("https://www.youtube.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
		}
		//Abrir Meet
		else if (tokens.get(i).getValor().equals("videoconferencia")){
			getToken(i++);
			try{
				URI link = new URI("https://meet.google.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
			tempo();
			if (tokens.get(i).getValor().equals(";")) {
				getToken(i++);
			}
		}
	}
	
	public void interact(){
		//Abrir Whatsappweb
		if (tokens.get(i).getValor().equals("whatsappweb")){
			getToken(i++);
			try{
				URI link = new URI("https://web.whatsapp.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
		}
		//Abrir Gmail
		else if (tokens.get(i).getValor().equals("email")){
			getToken(i++);
			try{
				URI link = new URI("https://mail.google.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
		}
		//Abrir Meet
		else if (tokens.get(i).getValor().equals("videoconferencia")){
			getToken(i++);
			try{
				URI link = new URI("https://meet.google.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
			tempo();
			if (tokens.get(i).getValor().equals(";")) {
				getToken(i++);
			}
		}
	}
	public void critique(){
		//Abrir Whatsappweb
		if (tokens.get(i).getValor().equals("whatsappweb")){
			getToken(i++);
			try{
				URI link = new URI("https://web.whatsapp.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
		}
		//Abrir Gmail
		else if (tokens.get(i).getValor().equals("email")){
			getToken(i++);
			try{
				URI link = new URI("https://mail.google.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
		}
		//Abrir Meet
		else if (tokens.get(i).getValor().equals("videoconferencia")){
			getToken(i++);
			try{
				URI link = new URI("https://meet.google.com/");
				Desktop.getDesktop().browse(link);
        	}catch(Exception erro){
         	 	System.out.println("ERRO");
       		}
			tempo();
			if (tokens.get(i).getValor().equals(";")) {
				getToken(i++);
			}
		}
	}
	public void tempo(){
		if (tokens.get(i).getValor().equals("quinzemim")){
			getToken(i++);
		}
		else if (tokens.get(i).getValor().equals("vintemim")){
			getToken(i++);
		}
		else if (tokens.get(i).getValor().equals("umahora")){
			getToken(i++);
		}
		else if (tokens.get(i).getValor().equals("umdia")){
			getToken(i++);
		}
		else if (tokens.get(i).getValor().equals("doisdias")){
			getToken(i++);
		}
		else if (tokens.get(i).getValor().equals("semlimite")){
			getToken(i++);
		}
	}
}
