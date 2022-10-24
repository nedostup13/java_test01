package ru.stqa.test01.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
    public void testAreaRectangle() {
    Square s = new Square(6);
    Assert.assertEquals(s.areaRectangle(), 36.0);
  }

}
