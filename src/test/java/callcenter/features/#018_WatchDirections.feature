#   language: ru

@acceptanceTest

Функция: Работа с направлениями
  Задействованные роли:
  Андрей - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Андрей вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова

  Структура сценария: Просмотр направлений
    Допустим Андрей захотел просмотреть направления пациента
    Когда Андрей выбрал “Записать по направлению”
    Тогда открылась вкладка с активными направлениями,с указанием "<ЛПУ>", "<Врач направления>", "<ФИО врача>"
    Примеры:
      |        ЛПУ     || Врач направления || ФИО врача |
      | Стенд ЕМИАС МО ||      Терапия     || Ай Бо Лит |