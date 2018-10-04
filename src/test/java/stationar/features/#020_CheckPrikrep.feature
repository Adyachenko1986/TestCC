#   language: ru

@acceptanceTest1

Функция: 20_Проверка коррекности записей пациента
  Задействованные роли:
  Тестовый оператор - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Тестовый оператор вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова

  Сценарий: Просмотр прикреплений
    Когда Тестовый оператор захотел проверить корректость прикрепления пациента
    Тогда в поле данные пациента будут отображено: Медучереждение, Участок и Врач