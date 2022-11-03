package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("testNameF", null, null, null, null, null, null, null, null, null, null, null, "test1"));
    }
    app.getContactHelper().initContactEdition();
    app.getContactHelper().fillContactForm(new ContactData("testNameF", "testNameM", "testNameL", "testAddress", "testPhoneH", "testPhoneM", "testPhoneW", "testPhoneF", "testMail1", "testMail2", "testMail3", "testAddress2", null), false);
    app.getContactHelper().submitContactEdition();
    app.getNavigationHelper().gotoHomePage();
  }
}
