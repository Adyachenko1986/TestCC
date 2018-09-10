#   language: ru

@acceptanceTest

Функция: Работа с направлениями
  Задействованные роли:
  Андрей - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Андрей вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова

  Структура сценария: Запись по направлению
    Допустим Андрей захотел записать пациента по направлению
    Когда Андрей нажал на выбранное направление
    То появляется расписание врачей этой специальности
    Тогда Андрей выбирает дату привема
    К тому же выбирает время приема
    И затем выбирает: Записать на прием
    Тогда появится всплывающее окно с полями "<ЛПУ>", "<Специализация>", "<ФИО врача>", "<Кабинет>"
    То в Записях пациента появится активная запись на прием к "Тест ФЛГ"
    И Андрей удаляет запись на прием
    Примеры:
      |     ЛПУ        || Специализация || ФИО врача || Кабинет |
      | Стенд ЕМИАС МО ||  Терапевты    || Ай Бо Лит ||   407   |