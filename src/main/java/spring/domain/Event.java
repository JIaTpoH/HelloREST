package spring.domain;


public class Event {
  private Integer id;
  private String name;
  private String city;
  private static int count = 0;


  public Event(String name, String city) {
    this.id = ++count;
    this.name = name;
    this.city = city;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public static int getCount() {
    return count;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public static void setCount(int count) {
    Event.count = count;
  }
}
