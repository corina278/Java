package homework;

//Pinidae clasa ce extinde planta cu public field numberOfSpecies = 50
//si metoda getGrowth Environment ce returneaza mountain
public class Pinidae extends Plant {

	/*
	public int numberOfSpecies(int nr) {
		nr = 50;
		return nr;
	}
	*/

	 public void numberOfSpecies() {
		int nr = 50;
		System.out.println(nr);
	}

	

	@Override
	public void oxygenProduction() {
		System.out.println("200");
	}
	
	public String getGrowthEnvironment(String environment) {
		environment="mountain";
		return environment;
	}
}
