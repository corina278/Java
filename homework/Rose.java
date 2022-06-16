package homework;

public class Rose extends Plant implements Fructiferous, Eatable {

	@Override
	void oxygenProduction() {
		System.out.println("30");
	}

	@Override
	public String color() {
		
		return null;
	}

	public void isEatable() {
		System.out.println("not eatable");
	}
	
}
