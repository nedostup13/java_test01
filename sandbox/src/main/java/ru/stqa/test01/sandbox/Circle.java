package ru.stqa.test01.sandbox;

public class Circle {
  public double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double areaCircle() {
    return Math.PI * (this.radius * this.radius);
  }
}
