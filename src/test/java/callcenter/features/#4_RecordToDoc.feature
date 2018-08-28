#   language: ru

@acceptanceTest
Функция: Запись на прием
  Задействованные роли:
  Андрей - оператор Колл-Центра

  Предыстория:
    Допустим что Андрей вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова

  Структура сценария: Запись на прием к врачу
    Допустим Андрей хочет записать пациента к терапевту
    Когда Андрей выбирает <ЛПУ>
    И затем выбирает <Специализация>
    Также выбирает ближайшую запись у <ФИО врача>
    К тому же выбирает время приема
    И затем выбирает “Записать на прием”
    Тогда появится всплывающее окно с полями <ЛПУ>, <Специализация>, <ФИО врача>, <Кабинет>, "Дата","Время","№ талона"

  Примеры:
      |     ЛПУ       || Специализация || ФИО врача || Кабинет |
      |Стенд ЕМИАС МО ||  Терапевты    || Ай Бо Лит ||   407   |


