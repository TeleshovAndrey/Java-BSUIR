Это spring boot проект который на данном этапе имеет GET endpoint "/welcome" и query params (name, surname)

При запросе localhost:8080/welcome?name=somesing&surname=somesing

В данном случае выведет

{'name': somesing, 'surname': somesing}

https://github.com/TeleshovAndrey/Java-BSUIR/blob/main/springboot-first-app/src/main/java/com/springbool/app/WelcomeController.java - Ссылка на контроллер
