package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Forms extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void userCanFillFormWithJustMandatoryFields() {
        //driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
        homePage.clickOnCard("Forms");
        sidebarPage.clickOnSidebarButton("Practice Form");
        practiceFormPage.inputFirstName("John");
        practiceFormPage.inputLastName("Smith");
        practiceFormPage.chooseGender();
        practiceFormPage.inputMobileNumber("1231231231");
        /*JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.7'");*/
        practiceFormPage.clickOnSubmit();
    }

    @Test
    public void userCanFillFormWithAllFields() {
        //driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
        homePage.clickOnCard("Forms");
        sidebarPage.clickOnSidebarButton("Practice Form");

        //practiceFormPage.inputDate("22 Feb 1900");
        practiceFormPage.inputFirstName("John");
        practiceFormPage.inputLastName("Smith");
        practiceFormPage.inputEmail("mail@mail.com");
        practiceFormPage.inputDateOfBirth("June", "1990", "11");
        practiceFormPage.chooseGender();
        practiceFormPage.inputMobileNumber("1231231231");
        /*JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.7'");*/
        practiceFormPage.clickOnSubmit();
    }

    @Test
    public void userCanFillFormWithExcelFile() {
        String firstName = excelReader.getStringData("Forms", 1, 0);
        String lastName = excelReader.getStringData("Forms", 1, 1);
        String email = excelReader.getStringData("Forms", 1, 2);
        String mobile = String.valueOf(excelReader.getIntegerData("Forms", 1, 3));

        homePage.clickOnCard("Forms");
        sidebarPage.clickOnSidebarButton("Practice Form");
        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(email);
        practiceFormPage.chooseGender();
        practiceFormPage.inputMobileNumber(mobile);
        practiceFormPage.clickOnSubmit();
    }

}
