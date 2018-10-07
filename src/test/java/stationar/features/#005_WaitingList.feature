#   language: ru

@acceptanceTest

Функция: Создание листа ожидания
  Задействованные роли:
  Тестовый оператор - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
  Допустим что Тестовый оператор вошел в АРМ оператора под своей учетной записью
  И найден пациент Астахова

  Структура сценария: Запись в лист ожидания
    Допустим Тестовый оператор хочет записать пациента в лист ожидания
    Когда Тестовый оператор выбирает "<ЛПУ>"
    И затем выбирает "<Специализация>"
    И выбирает Оформить лист ожидания
    Также заполняет поле "<Жалоба>"
    К тому же выбирает Оформить
    Тогда Появится всплывающее окно с записью "Пациент добавлен в лист ожидания"
    И Тестовый оператор отменяет созданный лист ожидания
    Примеры:
      |      ЛПУ       ||              Специализация            || Жалоба  |
      | СТЕНД ЕМИАС МО ||  Терапия.Аллергология и иммунология   || Тест ЛО |