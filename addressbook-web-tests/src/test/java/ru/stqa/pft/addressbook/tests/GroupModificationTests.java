package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }

//    int before = app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList(); // теперь в переменной before будет
    // содержаться список элементов, а не счетчик количества элементов

    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModifocation();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1", "test2", "test3");
    //при модификации группы мы оставляем старый id группы, а имя, хэдер и футер - прежние
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModifocation();
    app.getGroupHelper().returnToGroupPage();

//    int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // теперь в переменной after будет тоже список, а не счетчик
    Assert.assertEquals(after.size(), before.size());

    //моификация старого списка, чтобы предсказать нужный результат:
    before.remove(before.size() - 1); //удаляем последний элемент из списка
    before.add(group); //вместо него добавляется новый элемент, который получился после модификации
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
