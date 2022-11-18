package ru.stqa.test01.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
//  public static void main (String[] args) { //так тоже можно инициировать массив
//    String[] langs = new String[4];
//    langs[0] = "Java";
//    langs[1] = "C#";
//    langs[2] = "Python";
//    langs[3] = "PHP";
//  }
  public static void main (String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

//    for (int i = 0; i < langs.length; i++) {
//      System.out.println("Я хочу выучить " + langs[i]);
//    }
    List<String> languages = new ArrayList<String>(); //коллекция List (список), состоящая из элементов типа "строка"
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");

    List<String> languages2 = Arrays.asList("Java", "PHP"); //аналог инициализации массива из строк через список
    List languages3 = Arrays.asList("Java", "PHP", 5); //аналог инициализации массива из любых типов данных через список

    for (String l : languages) { //особая конструкция цикла для перебора элементов массива/коллекции
      System.out.println("Я хочу выучить " + l);
    }

    for (Object l : languages3) { //особая конструкция цикла для перебора элементов списка, состоящего из любых данных
      System.out.println("Я хочу выучить " + l);
    }

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
  }
}
