#   language: ru

@acceptanceTest

Функция: Проверка коррекности количества отображаемых талонов
  Задействованные роли:
  Тестовый оператор - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Тестовый оператор вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова

  Сценарий: Просмотр талонов
    Когда Тестовый оператор захотел проверить корректость количества талонов в фильтре специальностей
    Тогда количество талонов совпадает