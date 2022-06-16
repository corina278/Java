package homework;

//object: orange tree aged 10 height 5 eatable time to harvest
//august oxygen production 50
public class Orange extends Plant implements Fructiferous, Eatable {
	
	int age;
	int height;
	
	@Override
	public String color () {
		return null;
	}

	@Override
	public void oxygenProduction() {
		System.out.println("50");
	}

	public void getTimeToHarvest() {
		System.out.println("August");
	}
	
	public void isEatable() {
		System.out.println("eatable");
	}
	
	@Override
	public String toString() {
		return "Orange [age=" + age + ", height=" + height + "]";
	}

	public Orange (int Age, int Height) {
		age=Age;
		height=Height;
	}
	
}
