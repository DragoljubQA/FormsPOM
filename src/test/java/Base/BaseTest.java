package Base;

import Pages.HomePage;
import Pages.PracticeFormPage;
import Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public PracticeFormPage practiceFormPage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        excelReader = new ExcelReader("C:\\Users\\drago\\Desktop\\TestData.xlsx");

        homePage = new HomePage(driver);
        sidebarPage = new SidebarPage(driver);
        practiceFormPage = new PracticeFormPage(driver);
    }
}
