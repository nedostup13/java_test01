package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("testNameF", null, null, null, null, null, null, null, null, null, null, null, "test1"));
    }
    app.getContactHelper().initContactEdition();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoHomePage();
  }
}
