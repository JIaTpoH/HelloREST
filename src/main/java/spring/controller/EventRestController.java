package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.domain.Event;
import spring.service.EventService;

import java.util.List;

//Аннотация @RestController: Обозначает, что этот класс является контроллером,
// который обрабатывает HTTP-запросы и возвращает данные в формате JSON или XML
// (обычно используется для RESTful API).
@RestController

//Аннотация @RequestMapping("/event"): Определяет базовый путь для всех запросов,
// связанных с событиями. Таким образом, все методы контроллера будут обрабатывать запросы,
// начинающиеся с "/event".
@RequestMapping("/event")
public class EventRestController {

  //Аннотация @Autowired: Используется для автоматической инъекции зависимости EventService в контроллер.
  // Это позволяет использовать методы из EventService без необходимости создавать его экземпляр вручную.
  @Autowired
  private EventService eventService;

  //@GetMapping("/"): Этот метод обрабатывает HTTP GET запросы по пути "/event/" и возвращает
  // список всех событий (в формате JSON), используя метод findAll() из EventService.
  @GetMapping("/")
  public List<Event> findAll() {
    return eventService.findAll();
  }

  @GetMapping("/{id}")
  public Event findById(@PathVariable Integer id) {
    return eventService.get(id);
  }

  //@PostMapping("/add"): Этот метод обрабатывает HTTP POST запросы по пути "/event/add"
  // и добавляет новое событие, полученное из тела запроса (в формате JSON).
  // Метод вызывает add(Event event) из EventService, чтобы добавить событие и вернуть его (в формате JSON).
  @PostMapping("/add")
  public Event add(@RequestBody Event event) {
    return eventService.add(event);
  }


  //@PutMapping("/update/{id}"): Этот метод обрабатывает HTTP PUT запросы по пути "/event/update/{id}",
  // где {id} является переменной пути (path variable) и представляет идентификатор события,
  // которое необходимо обновить. Метод вызывает update(Integer id, Event event) из EventService,
  // чтобы обновить событие с указанным идентификатором и вернуть его (в формате JSON).
  @PutMapping("/update/{id}")
  public Event update(@PathVariable Integer id, @RequestBody Event event) {
    return eventService.update(id, event);
  }


  //@DeleteMapping("/delete/{id}"): Этот метод обрабатывает HTTP DELETE запросы по пути "/event/delete/{id}",
  // где {id} является переменной пути (path variable) и представляет идентификатор события,
  // которое необходимо удалить. Метод вызывает delete(Integer id) из EventService,
  // чтобы удалить событие с указанным идентификатором и вернуть его (в формате JSON).
  @DeleteMapping("/delete/{id}")
  public Event delete(@PathVariable Integer id) {
    return eventService.delete(id);
  }
}