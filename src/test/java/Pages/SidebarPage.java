package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SidebarPage {

    WebDriver driver;
    WebElement sidebarButton;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSidebarButton() {
        return driver.findElements(By.className("text"));
    }

    //---------------------------

    public void clickOnSidebarButton(String buttonName) {
        for (int i = 0; i < getSidebarButton().size(); i++) {
            if (getSidebarButton().get(i).getText().equals(buttonName)) {
                getSidebarButton().get(i).click();
                break;
            }
        }
    }

}
