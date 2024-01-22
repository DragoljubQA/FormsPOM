package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class PracticeFormPage {

    WebDriver driver;
    WebElement firstName, lastName, email, gender, mobile, dateOfBirth, subjects, hobbies, picture, currentAddress, state, city, submitButton, dateMonth, dateYear, dateDay;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getGender() {
        return driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
    }

    public WebElement getMobile() {
        return driver.findElement(By.id("userNumber"));
    }

    public WebElement getDateOfBirth() {
        return driver.findElement(By.id("dateOfBirthInput"));
    }

    public WebElement getSubjects() {
        return subjects;
    }

    public WebElement getHobbies() {
        return hobbies;
    }

    public WebElement getPicture() {
        return picture;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getDateMonth() {
        return driver.findElement(By.className("react-datepicker__month-select"));
    }

    public WebElement getDateYear() {
        return driver.findElement(By.className("react-datepicker__year-select"));
    }

    public List<WebElement> getDateDay() {
        return driver.findElements(By.cssSelector("div[role='option']"));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //----------------------------

    public void inputFirstName(String firstName) {
        getFirstName().clear();
        getFirstName().sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        getLastName().clear();
        getLastName().sendKeys(lastName);
    }

    public void inputMobileNumber(String number) {
        getMobile().clear();
        getMobile().sendKeys(number);
    }

    public void chooseGender() {
        getGender().click();
    }

    public void clickOnSubmit() {
        /*JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getSubmitButton());*/

        getSubmitButton().submit();
    }

    public void inputEmail(String email) {
        getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void inputDate(String date) {
        getDateOfBirth().click();
        getDateOfBirth().sendKeys(Keys.CONTROL + "a");
        getDateOfBirth().sendKeys(date);
        getDateOfBirth().sendKeys(ENTER);
    }

    public void inputDateOfBirth(String month, String year, String day) {
        getDateOfBirth().click();

        Select selectMonth = new Select(getDateMonth());
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(getDateYear());
        selectYear.selectByVisibleText(year);

        for (int i = 0; i < getDateDay().size(); i++) {
            if (getDateDay().get(i).getText().equals(day)) {
                getDateDay().get(i).click();
                break;
            }
        }
    }

}
