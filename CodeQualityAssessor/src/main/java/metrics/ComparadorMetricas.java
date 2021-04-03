package metrics;

/**
 * @author 1santo
 * 
 *         
 *
 */

import java.util.Comparator;

public class ComparadorMetricas implements Comparator<Metrica> {

//ira ser mais usado e redefinido num Sprint mais à frente
	public int compare(Metrica metricaLimite, Metrica metricaReal) {
		// TODO Auto-generated method stub
		return metricaLimite.getValor()- metricaReal.getValor() ;
	}

}
