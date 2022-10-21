package ru.stqa.test01.sandbox;

public class Rectangle {
  public double l1;
  public double l2;

  public Rectangle(double l1, double l2) {
    this.l1 = l1;
    this.l2 = l2;
  }

  public double areaRectangle() {
    return this.l1 * this.l2;
  }

}
