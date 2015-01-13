import java.util.Iterator;

/**
 * @author £ukasz Szpak
 * Model regresji liniowej. Implementacja zak³ada wybór logitu jako funkcji ³¹cz¹cej.
 */
public class ModelLR extends Model {
	private double logit(float[] x) {
		double result = 0;
		for (int i = 0; i < x.length; ++i) {
			result += beta[i]*x[i];
		}
		return result;
	}
	
	public double predict(float[] x) {
		return 1/(1 + Math.exp(-logit(x)));
	}
	
	@Override
	public void logLikelihoodGradient(Iterator<Example> it, double[] gradient) {
		//obliczany gradient jest przekazywane przez parametr a nie zwracan¹ wartoœæ ze wzglêdów wydajnoœciowych
		for (int i = 0; i < gradient.length; ++i) {
			gradient[i] = 0;
		}
		while (it.hasNext()) {
			addGradientElement(it.next(), gradient);
		}
	}

	private void addGradientElement(Example e, double[] gradient) {
		double predictError = e.getY() - predict(e.getX());
		for (int i = 0; i < gradient.length; ++i) {
			gradient[i] += predictError*e.getX()[i];
		}
	}

	@Override
	public double logLikelihood(Iterator<Example> it) {
        double logLikelihood = 0, prediction;
        Example e;
        while (it.hasNext()) {
        	e = it.next();
        	prediction = predict(e.getX());
        	logLikelihood += e.getY()*Math.log(prediction) + (1-e.getY())*Math.log(1-prediction);
        }
        return logLikelihood;
	}
}
