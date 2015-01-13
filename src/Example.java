
public class Example {
	private float[] x; //wektor zmiennych objaœniaj¹cych
	private int y; //zmienna objaœniana
	
    public Example(float[] x, int y) {
    	this.x = x;
        this.y = y;
    }

	public float[] getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getDimension() {
		return x.length;
	}
}
