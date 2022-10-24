package ru.stqa.test01.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance1() {
    Point p1 = new Point(0, 0);   //тест.объект Точка1
    Point p2 = new Point(0, 0);  //еще один тест.объект - Точка2
    Assert.assertEquals(p1.distance(p2), 0.0); //проверяем, указываем верное значение

    Point p3 = new Point(0, 0);   //тест.объект Точка3
    Point p4 = new Point(0, 1);  //еще один тест.объект - Точка4
    Assert.assertEquals(p3.distance(p4), 1.0); //проверяем, указываем верное значение

    Point p5 = new Point(-1, 5);   //тест.объект Точка5
    Point p6 = new Point(1, 5);  //еще один тест.объект - Точка6
    Assert.assertEquals(p5.distance(p6), 2.0); //проверяем, указываем верное значение

    Point p7 = new Point(0, 4);   //тест.объект Точка7
    Point p8 = new Point(0, 5.5);  //еще один тест.объект - Точка8
    Assert.assertEquals(p7.distance(p8), 1.5); //проверяем, указываем верное значение

  }
  
}
