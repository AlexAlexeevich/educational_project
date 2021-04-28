# REST-сервис, учебный проект.


Клонируйте проект: git clone https://github.com/AlexAlexeevich/Jar-Soft-springboot-backend

Для запуска перейдите в папку с проектом и выполните mvn spring-boot:run<br>
Проект будет доступен по url: http://localhost:8889

### Работа с сервисом:
Все описанные возвращаемые типы данных находятся в параметре data. В случае ошибки возвращается параметр error.
Например, в случае, если запрос корректно отработает, бэк возвращает в body ответа:
```
{
    “data”:{
        //возвращаемые данные
    }
}
```
А в случае ошибки возвращает 
```
{
    “error”:”текст ошибки”
}
```

#### Запросы:

1. api/organization/list<br>
   method: POST<br>
   
   In (фильтр):
```
{
  "name":"", //обязательный параметр
  "inn":"",
  "isActive":""
}
```
  Out:
```
[
  {
    “id”:””,
    “name”:””,
    “isActive”:”true”
  },
  ...
]

```

2. api/organization/{id}<br>
 method: GET<br>
 
 Out:
```
{
  “id”:””,
  “name”:””,
  “fullName”:””,
  “inn”:””,
  “kpp”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}
```
3. api/organization/update<br>
 method: POST<br>
 
 In:
```
{
  “id”:””, //обязательный параметр
  “name”:””, //обязательный параметр
  “fullName”:””, //обязательный параметр
  “inn”:””, //обязательный параметр
  “kpp”:””,  //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:”true”
}
```
  Out:
```
{
    “result”:”success”
}
```

4. api/organization/save<br>
 method: POST<br>
 
 In
 ```
 {
  “name”:””, //обязательный параметр
  “fullName”:””, //обязательный параметр
  “inn”:””, //обязательный параметр
  “kpp”:””, //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:”true”
}
```

5. api/office/list<br>
 method: POST<br>
 
 In (фильтр):
 ```
{
  “orgId”:””, //обязательный параметр
  “name”:””,
  “phone”:””,
  “isActive” 
}
```
  Out:
```
[
  {
    “id”:””,
    “name”:””,
    “isActive”:”true”
  },
  ...
]
```

6. api/office/{id}<br>
method:GET<br>

Out:
```
{
  “id”:””,
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}
```

7. api/office/update<br>
 method: POST<br>
 
In:
```
{
  “id”:””, //обязательный параметр
  “name”:””, //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:”true” //пример
}
```

  Out:
  ```
{
    “result”:”success”
}
```

8. api/office/save<br>
 method: POST<br>
 
In:
```
{
  “orgId”:””, //обязательный параметр
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}
```

  Out:
  ```
{
    “result”:”success”
}
```

9. api/user/list<br>
mathod: POST

  In (фильтр):
  ```
{
  “officeId”:””, //обязательный параметр
  “firstName”:””,
  “lastName”:””,
  “middleName”:””,
  “position”,””,
  “docCode”:””,
  “citizenshipCode”:””
}
```

  Out:
  ```
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
}
```

10. api/user/{id}<br>
method:GET<br>

Out:
  ```
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipName”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true”
}
```

11. api/user/update<br>
method: POST<br>

In:
```
{
  “id”:””, //обязательный параметр
  “officeId”:””,
  “firstName”:””, //обязательный параметр
  “secondName”:””,
  “middleName”:””,
  “position”:”” //обязательный параметр
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true” //пример
}
```

Out:
```
{
    “result”:”success”
}
```

12. api/user/save<br>
method: POST<br>

In:
```
{
  “officeId”:””, //обязательный параметр
  “firstName”:””, //обязательный параметр
  “secondName”:””,
  “middleName”:””,
  “position”:”” //обязательный параметр
  “phone”,””,
  “docCode”:””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true” //пример
}
```

Справочники:<br>
api/docs<br>
```
[
  {
    “name”:“Паспорт гражданина РФ”,
    “code”:”21”
  },
  ...
]
```

api/countries<br>
```
[
  {
    “name”:“Российская Федерация”,
    “code”:”643”
  },
  ...
]
```
