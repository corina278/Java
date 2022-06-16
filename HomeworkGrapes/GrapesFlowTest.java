package HomeworkGrapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session7.tests.BaseTest;

import java.time.Instant;

public class GrapesFlowTest extends BaseTestGrapes {

    public static final String GRAPE_NAME = "cabernet";

    @Test
    public void addGrape() throws Exception {
        //int initialValue, endValue;
        grape.openGrapes();
        //initialValue = grapePO.countGrapes();
        grape.addNewGrape(GRAPE_NAME);
        //endValue = grapePO.countGrapes();
        //Assertions.assertEquals(1, endValue - initialValue, "Grape was NOT added successfully!");
        grape.pickAndCrushGrapes(GRAPE_NAME);
        grape.Must(GRAPE_NAME);
        grape.ferment(GRAPE_NAME);
        boolean isAdded = grape.isMyGrapeInTable(GRAPE_NAME);
        System.out.println(isAdded);
        Assertions.assertTrue(isAdded, "Grape was NOT added successfully!");


    }
}
