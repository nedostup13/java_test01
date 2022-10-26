package ru.stqa.test01.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance1() {
    Point p1 = new Point(0, 0);                     //тест.объект Точка1
    Point p2 = new Point(0, 0);                     //еще один тест.объект - Точка2
    Assert.assertEquals(p1.distance(p2), 0.0);    //проверяем, указываем верное значение
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(0, 0);                     //тест.объект Точка1
    Point p2 = new Point(0, 1);                     //еще один тест.объект - Точка2
    Assert.assertEquals(p1.distance(p2), 1.0);    //проверяем, указываем верное значение
  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(-1, 5);                     //тест.объект Точка1
    Point p2 = new Point(1, 5);                      //еще один тест.объект - Точка2
    Assert.assertEquals(p1.distance(p2), 2.0);    //проверяем, указываем верное значение
  }

  @Test
  public void testDistance4() {
    Point p1 = new Point(0, 4);                      //тест.объект Точка1
    Point p2 = new Point(0, 5.5);                    //еще один тест.объект - Точка2
    Assert.assertEquals(p1.distance(p2), 1.5);    //проверяем, указываем верное значение
  }

}
