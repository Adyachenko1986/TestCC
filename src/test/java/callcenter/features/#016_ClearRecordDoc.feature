#   language: ru

@acceptanceTest1
Функция: 16_Удаление активных записей
  Задействованные роли:
  Тестовый оператор - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
  Допустим что Тестовый оператор вошел в АРМ оператора под своей учетной записью
  И найден пациент Астахова
  И создана запись на прием к "Селевич Николай Николаевич"
  И создана запись в ЛО к Клименко
  Также Тестовый оператор выбрал “Все записи пациента”

  Сценарий: Отмена записи на прием
    Допустим Тестовый оператор захотел отменить запись на прием
    Когда Тестовый оператор нажимает Удалить запись
    Тогда запись к "Селевич Николай Николаевич" пропадает из поля Записи на прием