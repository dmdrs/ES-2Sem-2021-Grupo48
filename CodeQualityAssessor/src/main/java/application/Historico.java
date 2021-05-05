package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class Historico {
	
	public static void escreverhistorico (String metrica1, int valor1,  String operador1, String metrica2, int valor2, String metrica3, int valor3, String operador2, String metrica4, int valor4) {
		FileWriter writer;
		try {
			writer = new FileWriter("Histórico.txt", true); 
			BufferedWriter writer2 = new BufferedWriter(writer);
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
		FileReader reader;
		try {
			reader = new FileReader ("Histórico.txt");
			BufferedReader reader2 = new BufferedReader (reader);
			TextArea.read (reader2,null);
			reader2.close();
			TextArea.requestFocus();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}