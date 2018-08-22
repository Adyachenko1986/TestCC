@acceptanceTest
#   language: ru

Функция: Вызов врача на дом
  Как оператор КЦ
  Для своевременного обслуживания пациентов
  Я должен быть способен создавать вызовы врача к пациентам, просматривать и отменять их.

  Задействованные роли:
  Андрей - оператор Колл-Центра
  Контекст: Допустим Адрей перешел на страницу вызова врача

  Сценарий: Создание вызова на дом пациента по МКАБ
    Допустим Андрей уже известен пациент
    Тогда Андрей заполняет поля:
      | Жалоба       |
      | Подъезд      |
      | Этаж         |
      | Код домофона |
    И нажимает на  ЛПУ
    Также нажимает “Вызвать врача”
    То появится всплывающие окно с заполненными полями:
      | ЛПУ           |
      | ФИО врача     |
      | Дата рождения |
      | Адрес         |
      | Подъезд       |
      | Этаж          |
      | Код домофона  |
      | Телефон       |
      | Жалоба        |

  Сценарий: Создание вызова на дом пациента методом СМП
    Допустим Андрей не известен пациент
    Тогда Андрей заполняет обязательные поля
      | Жалоба       |
      | Адрес        |
      | Подъезд      |
      | Этаж         |
      | Код домофона |
      | Телефон      |
    Тогда вводит название ЛПУ в фильтре списка учреждений
    И нажимает на ЛПУ
    Также нажимает “Вызвать врача”
    То появится всплывающие окно с заполненными полями
      | ЛПУ           |
      | ФИО врача     |
      | Дата рождения |
      | Адрес         |
      | Подъезд       |
      | Этаж          |
      | Код домофона  |
      | Телефон       |
      | Жалоба        |