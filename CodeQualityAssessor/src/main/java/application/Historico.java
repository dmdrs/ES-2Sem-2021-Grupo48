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

	public static void escreverhistorico (String metrica1, int valor1,  String operador1, String metrica2, int valor2, String metrica3, int valor3, String operador2, String metrica4, int valor4) {
		try {
			writer = new FileWriter("Histórico.txt", true); 
			writer2 = new BufferedWriter(writer);
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	public static void mostrarhistorico (JTextArea TextArea) throws IOException {
		try {
			reader = new FileReader ("Histórico.txt");
			reader2 = new BufferedReader (reader);
			TextArea.read (reader2,null);
			reader2.close();
			TextArea.requestFocus();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

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

}
