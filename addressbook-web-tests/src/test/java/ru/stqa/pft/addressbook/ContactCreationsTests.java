package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationsTests extends TestBase {

  @Test
  public void testContactCreations() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("testNameF", "testNameM", "testNameL", "testAddress", "testPhoneH", "testPhoneM", "testPhoneW", "testPhoneF", "testMail1", "testMail2", "testMail3", "testAddress2"));
    submitContactCreation();
    returnToHomePage();
  }

}
