#   language: ru

@acceptanceTest1

Функция: Проверка коррекности записей пациента
  Задействованные роли:
  Андрей - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Андрей вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова

  Сценарий: Просмотр прикреплений
    Когда Андрей захотел проверить корректость прикрепления пациента
    Тогда в поле данные пациента будут отображено: Медучереждение, Участок и Врач