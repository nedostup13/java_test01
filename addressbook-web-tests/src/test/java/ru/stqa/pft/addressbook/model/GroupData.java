package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  private int id; //ранее этот идентификатор был типа строка, но их необходимо сравнивать как числа
  // (например, при создании группы и определении самого максимального и самого "свежего" идентификатора, поэтому используем int
  //и ранее у этого атрибута был модификатор final, но нам нужно его менять
  private final String name;
  private final String header;
  private final String footer;

  public int getId() {
    return id;
  }

  //сгенерированный метод-сеттер
  public void setId(int id) {
    this.id = id;
  }

  public GroupData(int id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public GroupData(String name, String header, String footer) {
    this.id = Integer.MAX_VALUE; //когда id был строкой, он был == null //теперь он с максимальным числом, чтобы быть всегда последним в списке групп
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  //сгенерированный метод для преобразования в строку сообщений в консоли:

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  //сгенерированный метод для сравнения атрибутов объекта при сравнении объектов:

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

}
