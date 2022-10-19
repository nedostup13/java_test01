package ru.stqa.test01.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

    hello("world");
    hello("user");
    hello("Alexei");
    hello("all");

    double radius = 3;
    System.out.println("Площадь круга с радиусом " + radius + " равна " + areaCircle(radius));

    double a = 3;
    double b = 4;
    System.out.println("Площадь прямоугольника со стороной " + a + " и стороной " + b + " равна " + areaRectangle(a, b));

  }

  public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");

  }

  public static double areaCircle(double radius) {

    double S;
    S = Math.PI * square(radius);
    return S;
  }

  public static double square(double a) {
    return a * a;
  }

  public static double areaRectangle(double a, double b) {
    return a * b;
  }

}