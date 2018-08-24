@#   language: ru

@acceptanceTest
Функция: Работа с направлениями
  Задействованные роли:
  Андрей - оператор Колл-Центра

  Сценарий: Просмотр направлений
    Допустим Андрей захотел просмотреть направления пациента
    Когда Андрей выбрал “Записать по направлению”
    Тогда открылась вкладка с активными направлениями, где указано куда направлен пациент, специализация, ФИО врача и период действия направления.

  Сценарий: Запись по направлению
    Допустим Андрей захотел записать пациента по направлению.
    Когда Андрей нажал на выбранное направление
    То появляется расписание врачей этой специальности
    Тогда Андрей выбирает дату
    Также выбирает время визита
    И нажимает “Записать на прием”
    Тогда появляется всплывающее окно с заполненными полями:
      | ЛПУ           |
      | Специализация |
      | ФИО врача     |
      | Кабинет       |
      | Дата          |
      | Время         |
      | № талона      |
    То в “Записях пациента” появится активная запись на прием