package metrics;

/**
 * @author dmdrs
 *
 */

import java.io.BufferedReader;


public class LOC_class {

	private BufferedReader fileJava;
	private int linesOfCode;

	//Lê todas as linhas inclusive comentários e espaços em branco
	
	public void LOC_Class(BufferedReader file) {
		fileJava = file;
		linesOfCode = (int) fileJava.lines().count();
		System.out.println("O numero de linhas do código é" + linesOfCode );
	}
		
}
