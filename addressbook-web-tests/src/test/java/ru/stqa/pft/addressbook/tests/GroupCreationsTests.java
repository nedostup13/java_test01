package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationsTests extends TestBase {

  @Test
  public void testGroupCreations() throws Exception {
    app.getNavigationHelper().gotoGroupPage();

//    int before = app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList(); // теперь в переменной before будет
    // содержаться список элементов, а не счетчик количества элементов

    GroupData group = new GroupData("test2", null, null);
    app.getGroupHelper().createGroup(group);

//    int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // теперь в переменной after будет тоже список, а не счетчик
    Assert.assertEquals(after.size(), before.size() + 1);

//    СТАРЫЙ СПОСОБ СРАВНЕНИЯ:
    //т.к. неизвестен новый идентификатор группы, мы понимаем, что у новой группы должен быть максимальный из всех возможных, входящих в after - т.е. это предсказанный ожидаемый идентификатор
    //при этом наш идентификатор был типа строка, а сравнивать необходимо их как числа
//    int max = 0;
    //цикл для проверки всех элементов на максимальный:
//    for (GroupData g : after) { //g - переменная, которая "пробегает" список after
//      if (g.getId() > max) { //если идент-р группы больше максимального,
//        max = g.getId();     //то присвоим максимуму знаение найденного идент-ра этой группы
//      }
//    }

    //    НОВЫЙ СПОСОБ СРАВНЕНИЯ (только в Java 8) через компаратор:

//    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()); //присваиваем самый большой идент-р присваевается как идентификатор новой группы
    before.add(group); //добавлем в старый список ту группу, которую создали самостоятельно(модифицировали); здесь мы предсказываемый ожидаемый результат
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); //сравниваемый старый список с новым без учета порядка
    //оба списка преобразовываем в множества и сравниваем
  }

}
