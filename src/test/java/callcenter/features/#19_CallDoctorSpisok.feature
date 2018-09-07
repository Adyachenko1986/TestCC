#   language: ru

@acceptanceTest
@Test
Функция: Записи вызовов на дом
  Как оператор КЦ
  Для своевременного обслуживания пациентов
  Я должен быть способен создавать вызовы врача к пациентам, просматривать и отменять их.

  Задействованные роли:
  Андрей - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Андрей вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова
    И Андрей перешел на страницу вызова врача


  Сценарий: Просмотр всех вызовов врача на дом
    Допустим Андрей захотел просмотреть все вызовы на дом
    Тогда появляется список всех созданных вызовов
    И Андрей удаляет созданный вызов