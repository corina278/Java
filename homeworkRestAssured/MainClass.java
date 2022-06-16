package homeworkRestAssured;

public class MainClass {

    public static void main(String[] args) {
        RestAssured restAssured = new RestAssured();
        System.out.println("Post:");
        restAssured.assurePost();
        System.out.println();
        System.out.println("Get:");
        restAssured.assureGet("sold");
        System.out.println();
        System.out.println("Put");
        restAssured.assurePut();
        System.out.println();
        System.out.println("Delete");
        restAssured.assureDelete("sold");
    }
}
