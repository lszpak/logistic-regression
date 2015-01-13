import java.util.Iterator;


public abstract class Model {
	protected double[] beta; //wektor wspó³czynników regresji
	
	public double[] getBeta() {
		return beta;
	}

	public void setBeta(double[] beta) {
		this.beta = beta;
	}
	
	abstract public double predict(float[] x);
	
	abstract public void logLikelihoodGradient(Iterator<Example> it, double[] gradient);
	
	abstract public double logLikelihood(Iterator<Example> it);
}
