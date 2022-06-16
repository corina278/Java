package homework;

/*
 1. Plant abstract clasa : oxygenProduction (mandatory)
2. Fructiferous interfata : color + metoda getTimeToHarvest
3. Orange clasa ce extinde Plant si Fructiferous : age, height
4. Pinidae clasa ce extinde planta cu public field numberOfSpecies = 50
si metoda getGrowth Environment ce returneaza mountain
5. Cedar clasa ce extinde Pinidae cu overriden field numberOfSpecies = 10
si metoda getGrowthEnvironment ce returneaza mountain si Mediterranean
6. Eatable interfata extinsa de Orange si Cedar cu metoda isEatable
7. object: orange tree aged 10 height 5 eatable time to harvest
august oxygen production 50
8. object Cedar tree tip Pinidae oxygen production 200 not eatable
Print the field number of species si rezultatul metodei 
getGrowthEnvironment
9. implemeanteaza o cale sa creezi Rose object
 */
public class Main {

	public static void main(String[] args) {
		Orange orange_tree = new Orange(10,5);
		//orange.age = 10;
		//orange.height = 5;
		System.out.println(orange_tree); //10 5 
		orange_tree.oxygenProduction();//50
		orange_tree.getTimeToHarvest();//August
		orange_tree.isEatable(); // eatable
		Cedar cedar_tree = new Cedar();
		cedar_tree.oxygenProduction(); // 200
		cedar_tree.isEatable(); // not eatable
		cedar_tree.numberOfSpecies(); //10
		System.out.println(cedar_tree.getGrowthEnvironment("mountain, Mediterranean"));
		Rose rose = new Rose();
		rose.oxygenProduction();
		rose.isEatable();
	}

}
