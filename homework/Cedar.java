package homework;

//object Cedar tree tip Pinidae oxygen production 200 not eatable
//Print the field number of species si rezultatul metodei
//Cedar clasa ce extinde Pinidae cu overriden field numberOfSpecies = 10
//si metoda getGrowthEnvironment ce returneaza mountain si Mediterranean
public class Cedar extends Pinidae implements Eatable {

	public String getGrowthEnvironment( String environment)
	{
		environment = "mountain, Mediterranean";
		return environment;
	}

	@Override
	public void isEatable() {
		System.out.println("not eatable");
	}

	@Override
	public void numberOfSpecies() {
		System.out.println("10");
	}

	@Override
	public String toString() {
		return "Cedar = [ " + "]";
	}

	
	
	
}
