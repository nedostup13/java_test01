package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationsTests extends TestBase {

  @Test
  public void testContactCreations() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("testNameF", "testNameM", "testNameL", "testAddress", "testPhoneH", "testPhoneM", "testPhoneW", "testPhoneF", "testMail1", "testMail2", "testMail3", "testAddress2"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}