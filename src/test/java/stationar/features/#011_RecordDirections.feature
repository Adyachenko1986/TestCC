#   language: ru

@acceptanceTest

Функция: Работа с направлениями
  Задействованные роли:
  Тестовый оператор - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Тестовый оператор вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова

  Структура сценария: Запись по направлению
    Допустим Тестовый оператор захотел записать пациента по направлению
    Когда Тестовый оператор нажал на выбранное направление
    То появляется расписание врачей этой специальности
    Тогда Тестовый оператор выбирает дату привема
    К тому же выбирает время приема
    И затем выбирает: Записать на прием
    Тогда отобразится всплывающее окно с полями "<ЛПУ>", "<Специализация>", "<ФИО врача>", "<Кабинет>"
    То в Записях пациента появится активная запись на прием к "Тест ФЛГ"
    И Тестовый оператор удаляет запись на прием
    Примеры:
      |     ЛПУ        || Специализация || ФИО врача || Кабинет |
      | Стенд ЕМИАС МО ||  Терапевты    || Ай Бо Лит ||   407   |