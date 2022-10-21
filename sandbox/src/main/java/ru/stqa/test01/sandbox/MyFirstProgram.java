package ru.stqa.test01.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

    hello("world");
    hello("Alexei");

    Square s = new Square(5);
    Rectangle r = new Rectangle(4, 8);
    Circle c = new Circle(1.5);

    Point p1 = new Point(-3, 5); //объект Точка1
    Point p2 = new Point(7, 5);  //еще один объект - Точка2

    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.areaRectangle());
    System.out.println("Площадь прямоугольника со стороной " + r.l1 + " и стороной " + r.l2 + " равна " + r.areaRectangle());
    System.out.println("Площадь круга с радиусом " + c.radius + " равна " + c.areaCircle());

    System.out.println("________________________________");
    System.out.println("Решение Задания № 2, способ первый (через функцию):");
    System.out.println("Расстояние между точкой с координатами x=" + p1.x + ", y=" + p1.y +
            " и точкой с координатами x=" + p2.x + ", y=" + p2.y + " равна " + distance(p1, p2));

    System.out.println("________________________________");
        System.out.println("Решение Задания № 2, способ второй (через метод в классе Point):");
    System.out.println("Расстояние между точкой с координатами x=" + p1.x + ", y=" + p1.y +
            " и точкой с координатами x=" + p2.x + ", y=" + p2.y + " равна " + p1.distance(p2));

  }

  public static double distance(Point p1, Point p2) { //функция по вычислению расстояния
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)); //квадратный корень из суммы квадартов катетов
  }

  public static void hello(String somebody) { //функция Привет
    System.out.println("Hello, " + somebody + "!");
  }

}