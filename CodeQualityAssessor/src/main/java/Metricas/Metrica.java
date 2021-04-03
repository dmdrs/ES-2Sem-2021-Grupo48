package Metricas;

/**
 * @author 1santo
 * 
 *         Todas as métricas
 *
 */

public abstract class Metrica implements Propriedades{
	private String nomeMetrica; 
	private int valor;
	
	public Metrica(String nome, int valor){
		this.nomeMetrica=nome;
		this.valor=valor;

		
	}

	@Override
	public String getName(){
		return nomeMetrica;
	}
	
	@Override
	//depois mais a frente tem que se definir quais sao as duas escolhidas por defeito
	public boolean escolhida() {
		return false;
	}

	
	@Override
	public int getValor() {
		// valor definido pelo utilizador para ser code smell
		return valor;
	}
	
}

