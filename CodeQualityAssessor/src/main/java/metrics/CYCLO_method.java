package metrics;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author 1santo
 * 
 *         
 *
 */

public class CYCLO_method extends Metrica{

	//quando estiver na classe que Lê files depois instancia-se o valor com o que é passado pelo utilizador na classe GUI
	
	//(complexidade ciclomática do método <=> [(somatório da quantidade de instruções “if”, “case”, “for”, “while” e outros ciclos)+1])
	
	//NESTE MOMENTO ESTARÁ SÓ PARA CONTAR NO FICHEIRO TODO E NAO SÓ NO METODO
	
	private int ocurrenciasIf;
	private int ocurrenciasCase;
	private int ocurrenciasFor;
	private int ocurrenciasWhile;


	
	public CYCLO_method(int valor) {
		super("CYCLO_method", valor);
	}


	@Override
	public void init(BufferedReader file) {
		
		try {
			while (true) { //isto vai ter que ser enquanto estamos no void {}
			String linha;
			linha = file.readLine();
	
			if (linha == null) break;
			String[] palavra = linha.split(" ");
				for(int i=0; i<palavra.length; i++){
			        if(palavra[i].contains("if")){
			        	ocurrenciasIf++;
			        	System.out.println(palavra+"tem"+ocurrenciasIf);
			        }
			    }    
			}

		}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

	}
	
}




/*while(file.hasNext()){
String word=file.next();
Integer count=words.get(word);
if(count!=null)
	count++;
else
count=1;
words.put(word,count);
}
file.close();


linesOfCode = (int) file.lines().count();
System.out.println("O numero de linhas do código é " + linesOfCode );		
}*/