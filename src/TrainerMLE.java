import java.util.List;

/**
 * @author �ukasz Szpak
 * Klasa estymuj�ca parametry beta na podstawie przyk�ad�w treningowych.
 * Implementacja wykorzystuj� metod� najwi�kszej wiarygodno�ci w celu estymacji
 * oraz metod� prostego gradientu w celu znalezienia maksimum funkcji wiarygodno�ci.
 */
public class TrainerMLE implements Trainer {
	private double step; // wsp�czynnik d�ugo�ci kroku
	private double[] gradient;
	private int iterationsCounter;
	private TerminationCondition terminationCondition;
	
	public TrainerMLE() {
		step = 0.0001;
		terminationCondition = new TerminationCondition() {
			@Override
			public boolean isFulfilled() {
				return getGradientModule() < 0.0001 || iterationsCounter == 1_00_000;
			}
		};
	}
		
	public TrainerMLE(double step, TerminationCondition terminationCondition) {
		this.step = step;
		this.terminationCondition = terminationCondition;
	}

	@Override
	public void train(List<Example> trainSet, Model model) {
		if (!trainSet.isEmpty()) {
			int dim = trainSet.get(0).getDimension();
			double[] beta = new double[dim];
			gradient = new double[dim];
			model.setBeta(beta);
			iterationsCounter = 0;
			do {			
				model.logLikelihoodGradient(trainSet.iterator(), gradient);
				for (int i = 0; i < dim; ++i) {  
					beta[i] += step*gradient[i];
				}			
				++iterationsCounter;
			} while (!terminationCondition.isFulfilled());
		}
	}

	public double getGradientModule() {
		double gradientModule = 0;
		for (int i = 0; i < gradient.length; ++i) {
			gradientModule += gradient[i]*gradient[i];
		}
		return Math.sqrt(gradientModule);
	}

	public int getIterationsCounter() {
		return iterationsCounter;
	}
	
}
