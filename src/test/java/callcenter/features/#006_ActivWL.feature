#   language: ru

@acceptanceTest

Функция: Записи пациента
  Задействованные роли:
  Тестовый оператор - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Тестовый оператор вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова
    И создана запись в ЛО к Клименко

  Структура сценария: Просмотр активного листа ожидания
    Допустим Тестовый оператор захотел просмотреть активный лист ожидания
    Когда Тестовый оператор нажимает “Подробная информация” в листах ожидания
    То появится всплывающие окно с полями: "<ЛПУ>", "<адрес ЛПУ>", "<источник вызова>"
    Тогда Тестовый оператор нажимает История
    И появится всплывающие окно с таблицей с полями Дата, Автор, Что изменилось, Изменение
    И Тестовый оператор отменяет созданный лист ожидания
    Примеры:
    |     ЛПУ        ||                           адрес ЛПУ                          ||    источник вызова     |
    | Стенд ЕМИАС МО || Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5 || Источник: Колл-центр   |
