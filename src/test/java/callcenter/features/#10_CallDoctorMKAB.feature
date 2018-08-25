#   language: ru

@acceptanceTest
Функция: Вызов врача на дом
  Как оператор КЦ
  Для своевременного обслуживания пациентов
  Я должен быть способен создавать вызовы врача к пациентам, просматривать и отменять их.

  Задействованные роли:
  Андрей - оператор Колл-Центра
  Предыстория:
    Допустим Андрей перешел на страницу вызова врача
    И найден пациент

  Сценарий: Создание вызова на дом пациента по МКАБ
    Допустим Андрей хочет вызвать врача
    Тогда Андрей заполняет поля
      | Жалоба       |
      | Подъезд      |
      | Этаж         |
      | Код домофона |
    Когда Андрей выбирает “СТЕНД ЕМИАС МО”
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