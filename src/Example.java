
public class Example {
	private float[] x; //wektor zmiennych obja�niaj�cych
	private int y; //zmienna obja�niana
	
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
