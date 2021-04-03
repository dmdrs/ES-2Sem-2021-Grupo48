package metrics;

/**
 * @author 1santo
 * 
 *         
 *
 */

public class CYCLO_method extends Metrica{

	//quando estiver na classe que Lê files depois instancia-se o valor com o que é passado pelo utilizador na classe GUI
	
	//(complexidade ciclomática do método <=> [(somatório da quantidade de instruções “if”, “case”, “for”, “while” e outros ciclos)+1])
	
	
	public CYCLO_method(int valor) {
		super("CYCLO_method", valor);
		// TODO Auto-generated constructor stub
	}

	int ocurrencias=0;
	
}
