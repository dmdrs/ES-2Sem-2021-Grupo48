package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

/**
 * Classe responsável pelo Histórico de Regras
 * @author rgmpo-iscte
 *
 */
public class Historico {
	
	private static FileWriter writer;
	private static BufferedWriter writer2;
	private static FileReader reader;
	private static BufferedReader reader2;

	public FileWriter getWriter() {
		return writer;
	}

	public BufferedWriter getWriter2() {
		return writer2;
	}

	public FileReader getReader() {
		return reader;
	}

	public BufferedReader getReader2() {
		return reader2;
	}

	public static void setWriter(FileWriter writer) throws IOException {
		Historico.writer = new FileWriter("Histórico.txt", true); ;
	}

	public static void setReader(FileReader reader) throws FileNotFoundException {
		Historico.reader = new FileReader ("Histórico.txt");
	}
	
	public static void setReader2(BufferedReader reader2) throws FileNotFoundException {
		Historico.reader2 = new BufferedReader(reader);
	}
	
	public static void setWriter2(BufferedWriter writer2) throws IOException {
		Historico.writer2 = new BufferedWriter(writer);
	}
	/**
	 * Escreve no ficheiro .txt do Histórico os valores e regras definidas no Editor de Regras da Gui para a deteção de CodeSmells 
	 * @param metrica1
	 * @param valor1
	 * @param operador1
	 * @param metrica2
	 * @param valor2
	 * @param metrica3
	 * @param valor3
	 * @param operador2
	 * @param metrica4
	 * @param valor4
	 * @throws IOException
	 */
	public static void escreverhistorico (String metrica1, int valor1,  String operador1, String metrica2, 
			int valor2, String metrica3, int valor3, String operador2, String metrica4, int valor4) throws IOException {
		setWriter(writer);
		setWriter2(writer2);
		writer2.newLine();
		writer2.write("Long Method:");
		writer2.newLine();
		writer2.write(metrica1+ " > " + valor1 + " " + operador1 + " " + metrica2 + " > " + valor2);
		writer2.newLine();
		writer2.write("God Class:");
		writer2.newLine();
		writer2.write(metrica3+ " > " + valor3 + " " + operador2 + " " + metrica4 + " > " + valor4);
		writer2.newLine();

        writer2.close();

       
	}
	/**
	 * Mostra o histórico que está guardado num .txt na TextArea recebida 
	 * @param TextArea
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void mostrarhistorico (JTextArea TextArea) throws IOException, FileNotFoundException {
		
			setReader(reader);
			setReader2(reader2);
			TextArea.read (reader2,null);
			reader2.close();
			TextArea.requestFocus();
		
		
	}

}
