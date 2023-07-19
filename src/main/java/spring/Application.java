package spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Вот что делает аннотация @SpringBootApplication:
//
//@Configuration: Обозначает, что класс содержит настройки для создания и настройки бинов
// (beans) в Spring контексте.
//
//@EnableAutoConfiguration: Позволяет Spring Boot автоматически настраивать приложение
// на основе зависимостей в проекте и конфигурационных файлов.
//
//@ComponentScan: Определяет пакеты, которые должны быть отсканированы Spring для поиска компонентов,
// таких как контроллеры, сервисы и репозитории.
//
//Когда вы помечаете класс в вашем приложении аннотацией @SpringBootApplication,
// вы автоматически получаете все эти функции,
// что существенно упрощает разработку и уменьшает необходимость в явной конфигурации.
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
