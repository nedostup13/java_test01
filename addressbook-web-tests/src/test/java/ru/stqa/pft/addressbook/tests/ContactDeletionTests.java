package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoGroupPage(); //переходим на страницу групп
    if (! app.getGroupHelper().isThereAGroup()) { //и проверяем их наличие
      app.getGroupHelper().createGroup(new GroupData("test1", null, null)); //если нет ни одной группы, то создаем ее
    }

    app.getNavigationHelper().gotoHomePage();  //переходим на гл.страницу (страница контактов)
    if (! app.getContactHelper().isThereAContact()) { //и проверяем наличие контактов
      app.getContactHelper().createContact(new ContactData("testNameF", null, null,
              null, null, null, null, null, null, null,
              null, null, null)); //если нет ни одного контакта, то создаем его
    }

    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount(); //считаем количество контактов до удаления

    app.getContactHelper().selectContact(before - 1); // выбираем последний контакт из списка
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoHomePage();

    int after = app.getContactHelper().getContactCount(); //считаем количество контактов после удаления
    Assert.assertEquals(after, before - 1);
  }
}
