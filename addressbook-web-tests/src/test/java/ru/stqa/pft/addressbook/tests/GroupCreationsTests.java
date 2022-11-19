package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationsTests extends TestBase {

  @Test
  public void testGroupCreations() throws Exception {
    app.getNavigationHelper().gotoGroupPage();

//    int before = app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList(); // теперь в переменной before будет
    // содержаться список элементов, а не счетчик количества элементов

    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));

//    int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // теперь в переменной after будет тоже список, а не счетчик
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
