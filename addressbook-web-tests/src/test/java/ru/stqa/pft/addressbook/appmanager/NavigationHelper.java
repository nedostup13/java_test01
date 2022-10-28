package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
    wd.get("http://localhost/addressbook/group.php");
  }

  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }


}
