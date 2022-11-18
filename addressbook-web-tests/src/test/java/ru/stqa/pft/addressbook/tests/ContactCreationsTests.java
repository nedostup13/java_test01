package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationsTests extends TestBase {

  @Test
  public void testContactCreations() throws Exception {
    app.getNavigationHelper().gotoGroupPage(); //переходим на страницу групп
    if (! app.getGroupHelper().isThereAGroup()) { //и проверяем их наличие
      app.getGroupHelper().createGroup(new GroupData("test1",
              null, null)); //если нет ни одной группы, то создаем ее
    }

    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();  //считаем количество контактов до создания

    app.getContactHelper().createContact(new ContactData("testNameF", "testNameM", "testNameL",
            "testAddress", "testPhoneH", "testPhoneM", "testPhoneW", "testPhoneF",
            "testMail1", "testMail2", "testMail3", "testAddress2", null)); //создаем контакт

    int after = app.getContactHelper().getContactCount();   //считаем количество контактов после создания
    Assert.assertEquals(after, before + 1);         //проверка количества контактов до и после
  }

}
