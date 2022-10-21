package ru.stqa.test01.sandbox;

public class Point {
  public double x; // координата X для точки
  public double y; // координата Y для точки

  public Point(double x, double y) { // конструктор создания объекта Point
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2) { //метод вычисления расстония от заданной точки до точки объекта p2
    return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y)); //квадратный корень из суммы квадартов катетов
  }

}