package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

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

	//se file nao existir, ele cria em cada um dos voids + têm de ser iguais para ler um do outro
	//reader=input, writer=output
	//input first
	public static void setWriter(FileWriter writer) throws IOException {
		Historico.writer = new FileWriter("1Histórico.txt", true); ;
	}

	public static void setReader(FileReader reader) throws FileNotFoundException {
		Historico.reader = new FileReader ("1Histórico.txt");
	}
	
	public static void setReader2(BufferedReader reader2) throws FileNotFoundException {
		Historico.reader2 = new BufferedReader(reader);
	}
	
	public static void setWriter2(BufferedWriter writer2) throws IOException {
		Historico.writer2 = new BufferedWriter(writer);
	}
	
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

		System.out.println("VERRR"+writer2);
        writer2.close();

       
	}
	
	public static void mostrarhistorico (JTextArea TextArea) throws IOException, FileNotFoundException {
		
			setReader(reader);
			setReader2(reader2);
			TextArea.read (reader2,null);
			reader2.close();
			TextArea.requestFocus();
		
		
	}

}
