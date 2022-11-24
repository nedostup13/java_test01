package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
//    int before = app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList(); // теперь в переменной before будет
    // содержаться список элементов, а не счетчик количества элементов

    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();

//    int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // теперь в переменной after будет тоже список, а не счетчик
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1); //удаляем из списка элемент
      Assert.assertEquals(before, after); //проверка двух списков целиком, чтобы убедиться, что группа корректно удалилась
  }

}
