  package Test;

//Once login is performed:
//
//- check that 'Total Balance' is $350
//
//- count how many transactions are in 'Complete' status
//
//- check that the Category for the declined transaction is 'Finance'

  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.support.ui.WebDriverWait;
  import session7.utils.SeleniumWrapper;

  import java.time.Duration;
  import java.util.List;

  public class OBFlow {
      public WebDriver driver;
      public WebDriverWait wait;
      public SeleniumWrapper seleniumWrapper;
      public String usernameField = "#username";
      public String passwordField = "#password";
      public String loginBtn = ".btn.btn-primary";
      public String balance = ".balance-value";
      public String tableRow = "table > tbody > tr";

      public String complete = "status-pill.smaller.green";
      


      public OBFlow(WebDriver driver) {
          this.driver = driver;
          this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          this.seleniumWrapper = new SeleniumWrapper(driver);
      }

      public void openOnlineBanking() throws Exception {
          driver.get("https://demo.applitools.com/index.html");
          Thread.sleep(2000);
      }

      public void loginUser(String username, String password) throws Exception {


          seleniumWrapper.sendKeys(By.cssSelector(usernameField), username);

          seleniumWrapper.sendKeys(By.cssSelector(passwordField), password);

          driver.findElement(By.cssSelector(loginBtn)).click();
          Thread.sleep(1000);
      }

      public int countTransactions() {
          List<WebElement> tableRows = driver.findElements(By.cssSelector(tableRow));
          return tableRows.size();
      }

      public boolean checkBalance(){
          if (driver.findElement(By.cssSelector(".balance-value")).equals(350)){
              return true;
          }

          return true;
      }

      public int  countTransactions(int count) {
          count = 0;
          List<WebElement> tableRows = driver.findElements(By.cssSelector(tableRow));
          for (WebElement row : tableRows) {
              if (row.findElements(By.cssSelector("span")).get(0).getText().equals(complete)) {
                  count++;
              }
          }
          return count;
      }

  }
