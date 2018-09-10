#   language: ru

@acceptanceTest

Функция: Создание листа ожидания
  Задействованные роли:
  Андрей - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
  Допустим что Андрей вошел в АРМ оператора под своей учетной записью
  И найден пациент Астахова

  Структура сценария: Запись в лист ожидания
    Допустим Андрей хочет записать пациента в лист ожидания
    Когда Андрей выбирает "<ЛПУ>"
    И затем выбирает "<Специализация>"
    И выбирает Оформить лист ожидания
    Также заполняет поле "<Жалоба>"
    К тому же выбирает Оформить
    Тогда Появится всплывающее окно с записью "Пациент добавлен в лист ожидания"
    И Андрей отменяет созданный лист ожидания
    Примеры:
      |      ЛПУ       ||              Специализация            || Жалоба  |
      | СТЕНД ЕМИАС МО ||  Терапия.Аллергология и иммунология   || Тест ЛО |
