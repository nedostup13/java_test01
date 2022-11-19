package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoGroupPage(); //переходим на страницу групп
    if (! app.getGroupHelper().isThereAGroup()) { //и проверяем их наличие
      app.getGroupHelper().createGroup(new GroupData("test1", null, null)); //если нет ни одной группы, то создаем ее
    }

    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) { //проверяем наличие контактов на главной странице
      app.getContactHelper().createContact(new ContactData("testNameF", null, null,
              null, null, null, null, null, null, null,
              null, null, null)); //если нет ни одного контакта, то создаем его
    }

    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount(); //считаем количество контактов до модификации

    app.getContactHelper().initContactEdition(before - 1); // редактируем последний контакт из списка
    app.getContactHelper().fillContactForm(new ContactData("testNameF", "testNameM", "testNameL", "testAddress", "testPhoneH", "testPhoneM", "testPhoneW", "testPhoneF", "testMail1", "testMail2", "testMail3", "testAddress2", null), false);
    app.getContactHelper().submitContactEdition();
    app.getNavigationHelper().gotoHomePage();

    int after = app.getContactHelper().getContactCount();   //считаем количество контактов после модификации
    Assert.assertEquals(after, before);         //проверка количества контактов до и после
  }
}
