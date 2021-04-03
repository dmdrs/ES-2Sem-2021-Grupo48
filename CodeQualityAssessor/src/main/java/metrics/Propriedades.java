package metrics;

/**
 * @author 1santo
 * 
 *         Propriedade das métricas para a app se guiar se é a métrica escolhida pelo o utilizador
 *
 */

public interface Propriedades{

	/**
	 * É a métrica escolhida pelo utilizador
	 * 
	 *         
	 */
	boolean escolhida();
		
	/**
	 * Nome da métrica
	 * 
	 *         
	 */
	String getName();

	/**
	 * Valor para guia de code smell
	 * 
	 *         
	 */
	
	int getValor();
		
		 
}

