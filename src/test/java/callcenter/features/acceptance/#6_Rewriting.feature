@acceptanceTest
#   language: ru

Функция: Перенос записи
  Задействованные роли:
  Андрей - оператор Колл-Центра

  Сценарий: Перенос записи на прием
    Допустим Андрей захотел перенести запись на прием
    Когда Андрей нажимает “Перенести запись”
    Тогда открывается окно “перенос записи талона” с расписанием врачей этой специальности
    И Андрей выбирает дату
    Также выбирает время визита
    И нажимает “перенести запись”
    То появляется всплывающее окно “Запись перенесена успешно”