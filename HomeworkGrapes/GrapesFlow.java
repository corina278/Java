  package HomeworkGrapes;

//Adaugat un tip nou de strugure (deja implementat la curs) |
//Odata adaugat, ne pozitionam pe randul strugurelui nostru si dam click pe ‘Pickup & crush grapes’
//Vom fi redirectionati catre pagina de ‘Must’ unde vom cauta strugurele in tabel, vom bifa casuta din
// dreptul strugurelui nostru si vom da click pe ‘Ferment 1 must’
//In final ajungem pe pagina de ‘Wine cellar contents’ unde vom verifica daca intr-adevar strugurele nostru este prezent.

  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.support.ui.Select;
  import org.openqa.selenium.support.ui.WebDriverWait;
  import session7.utils.SeleniumWrapper;

  import java.time.Duration;
  import java.util.List;

public class GrapesFlow {
    public WebDriver driver;
    public WebDriverWait wait;
    public SeleniumWrapper seleniumWrapper;

    public String addBtn = ".animated-button"; //tag.class
    public String nameField = "#name";
    public String quantityField = "#quantity";
    public String unitField = "//select[@id='unit']";
    public String ageField = "#age"; //tag#id
    public String ripenessField = "//input[@id='ripeness']";//tag.class[attribute=value]  clear()
    public String submitBtn = "//input[@value='Submit']"; //tag[attribute=value]
    public String tableRow = "table > tbody > tr";


    public GrapesFlow(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void openGrapes() throws Exception {
        driver.get("https://wineappui.azurewebsites.net/");
        Thread.sleep(2000);
    }

    public void addNewGrape(String grapeName) throws Exception {
        // click 'Add grapes' btn
        // driver.findElement(By.cssSelector(addBtn)).click();
        //driver.findElement(By.xpath("//button[text()='Add grapes']"));
       seleniumWrapper.click(By.cssSelector(addBtn));

        // set Name
        /*WebElement name = driver.findElement(By.cssSelector(nameField));
        name.clear();
        name.sendKeys(grapeName);*/
        seleniumWrapper.sendKeys(By.cssSelector(nameField), grapeName);

        // set Quantity
        Select quantitySelect = new Select(driver.findElement(By.cssSelector(quantityField)));
        quantitySelect.selectByValue("24");
        Thread.sleep(1000);

        // set Unit
        Select unitSelect = new Select(driver.findElement(By.xpath(unitField)));
        unitSelect.selectByIndex(2);
        Thread.sleep(1000);

        // set Age
        WebElement age = driver.findElement(By.cssSelector(ageField));
        age.clear();
        age.sendKeys("50");
        Thread.sleep(1000);

        // set Ripeness
        WebElement ripeness = driver.findElement(By.xpath(ripenessField));
        ripeness.clear();
        ripeness.sendKeys("90");
        Thread.sleep(1000);

        // click 'Submit' btn
        driver.findElement(By.xpath(submitBtn)).click();
        Thread.sleep(1000);
    }

    public int countGrapes() {
        List<WebElement> tableRows = driver.findElements(By.cssSelector(tableRow));
        return tableRows.size();
    }


    public void pickAndCrushGrapes(String grapeName) {
        List<WebElement> tableRows = driver.findElements(By.cssSelector(tableRow));
        for (WebElement row : tableRows) {
            if (row.findElements(By.tagName("td")).get(0).getText().equals(grapeName)) {
                driver.findElement(By.cssSelector("button")).click();
                break;
            }
        }
    }

    public void Must(String grapeName) {
        List<WebElement> tableRows = driver.findElements(By.cssSelector(tableRow));
        for (WebElement row : tableRows) {

            if (row.findElements(By.tagName("td")).get(0).getText().equals(grapeName)) {
                driver.findElement(By.cssSelector("checkbox")).click(); //isSelected() on/off
                break;
            }
        }
    }

    public void ferment(String grapeName) {
        Must(grapeName);
        List<WebElement> tableRows = driver.findElements(By.cssSelector(tableRow));
        for (WebElement row : tableRows) {
            if (row.findElements(By.tagName("td")).get(0).getText().equals(grapeName)) {
                driver.findElement(By.cssSelector("button")).click(); //tag:contains("Ferment 1 must")
                break;
            }
        }
    }


    public boolean isMyGrapeInTable(String grapeName) {
        List<WebElement> tableRows = driver.findElements(By.cssSelector(tableRow));
        for (WebElement row : tableRows) {
            if (row.findElements(By.tagName("td")).get(0).getText().equals(grapeName))
                return true;
        }

        return false;
    }
}
