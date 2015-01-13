import java.io.IOException;
import java.util.List;


public class Test {
	public static void main(String[] args) {
		try {
			List<Example> data = DataReader.readCSV("hire.txt");
			Model lrModel = new ModelLR();
			Trainer t = new TrainerMLE();
			t.train(data, lrModel);
	        Example e1 = data.get(0);
	        Example e2 = data.get(26);
	        System.out.println("e1.Y = " + e1.getY() + ", prob(1|e1.X) = " + lrModel.predict(e1.getX()));
	        System.out.println("e2.Y = " + e2.getY() + ", prob(1|e2.X) = " + lrModel.predict(e2.getX()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
