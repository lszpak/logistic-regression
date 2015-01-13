import java.util.List;

public interface Trainer {
	void train(List<Example> trainSet, Model model);
}
