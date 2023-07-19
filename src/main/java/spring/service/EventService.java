package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Event;

import java.util.ArrayList;
import java.util.List;


//Аннотация @Service говорит Spring о том, что этот класс является сервисом,
//который обрабатывает бизнес-логику приложения. Он также сообщает Spring о том,
//что этот класс должен быть обнаружен и автоматически зарегистрирован в качестве компонента Spring.
//Это делает возможным использование этого сервиса в других компонентах приложения.
@Service
public class EventService {
  static final List<Event> events = new ArrayList<Event>() {{
    add(new Event("Opera", "London"));
    add(new Event("Violin concert", "Prague"));
    add(new Event("Jazz concert", "Berlin"));
  }};


  //findAll(): Этот метод возвращает список всех событий.
  // Он просто возвращает статический список events,
  // который содержит несколько предопределенных событий.
  public List<Event> findAll() {
    return events;
  }

  //get(int id): Этот метод ищет событие по его идентификатору (id) в списке events.
  // Если событие с таким идентификатором найдено, оно возвращается,
  // в противном случае возвращается null.

  public Event get(int id) {
    for (Event event : events) {
      if (event.getId() == id) {
        return event;
      }
    }
    return null;
  }


  //add(Event event): Этот метод добавляет новое событие в список events.
  // Он создает новый объект Event, используя переданные параметры name и city,
  // и добавляет его в список. Затем метод возвращает добавленное событие.
  public Event add(Event event) {
    Event newEvent = new Event(event.getName(), event.getCity());
    events.add(newEvent);
    return newEvent;
  }

  //update(int id, Event event): Этот метод обновляет информацию о событии с заданным
  // идентификатором id. Он ищет событие с соответствующим идентификатором в списке events
  // с помощью метода get(int id). Если событие найдено, его имя и город обновляются на значения,
  // переданные в параметре event. Затем метод возвращает обновленное событие.
  public Event update(int id, Event event) {
    Event updEvent = get(id);
    if (updEvent != null) {
      updEvent.setName(event.getName());
      updEvent.setCity(event.getCity());
    }
    return updEvent;
  }


  //delete(int id): Этот метод удаляет событие с заданным идентификатором id из списка events.
  // Он сначала использует метод get(int id) для поиска события по его идентификатору.
  // Если событие найдено, оно удаляется из списка events, и метод возвращает удаленное событие.
  public Event delete(int id) {
    Event event = get(id);
    if (event != null) {
      events.remove(event);
    }
    return event;
  }
}