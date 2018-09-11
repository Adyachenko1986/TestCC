#   language: ru

@acceptanceTest

Функция: Вызов врача на дом
  Как оператор КЦ
  Для своевременного обслуживания пациентов
  Я должен быть способен создавать вызовы врача к пациентам, просматривать и отменять их.

  Задействованные роли:
  Тестовый оператор - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Тестовый оператор вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова
    И Тестовый оператор перешел на страницу вызова врача

  Структура сценария: Создание вызова на дом пациента по МКАБ
    Допустим Тестовый оператор хочет вызвать врача
    Тогда Тестовый оператор заполняет поля "<Жалоба>", "<Подъезд>", "<Этаж>", "<Код домофона>", Телефон, "<Адрес>"
    Когда Тестовый оператор выбирает "<ЛПУ>"
    Также нажимает “Вызвать врача”
    И подтверждает создание вызова
    То появится всплывающие окно с заполненными полями "<ЛПУ>", "<ФИО>", "<Дата рождения>", "<Адрес>", "<Подъезд>", "<Этаж>", "<Код домофона>", "<Телефон>", "<Жалоба>"
    И Тестовый оператор удаляет созданный вызов врача
    Примеры:
      |       ЛПУ      ||              ФИО            || Дата рождения || Адрес                         || Подъезд || Этаж || Код домофона || Телефон           || Жалоба      |
      | СТЕНД ЕМИАС МО || АСТАХОВА ВИКТОРИЯ ПАВЛОВНА  || 25.10.1999    || Московская обл, г Красногорск ||  5      ||  6   ||       7      || +7(123) 456 78 99 || Температура |