package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModifocation() {
    click(By.name("edit"));
  }

  public void submitGroupModifocation() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>(); //создаем список, который будем заполнять
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group")); //получаем список всех объектов типа WebElement,
    // т.е. находим все веб-элементы с тегом span и классом group
    for (WebElement element : elements) { // цикл по каждому найденному элементу (переменная element "пробегает" по списку elements
      String name = element.getText(); // из каждого найденного элемента получаем текст (имя группы)
      GroupData group = new GroupData(name, null, null); // создаем объект типа GroupData, имя нам известно, а header и footer - нет
      groups.add(group); // добавляем созданный объект в список
    }
    return groups;
  }
}
