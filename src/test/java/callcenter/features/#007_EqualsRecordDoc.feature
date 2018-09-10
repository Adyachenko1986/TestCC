#   language: ru

@acceptanceTest

Функция: Проверка коррекности записей пациента
  Задействованные роли:
  Андрей - оператор Колл-Центра
  Астахова - пациент

  Предыстория:
    Допустим что Андрей вошел в АРМ оператора под своей учетной записью
    И найден пациент Астахова
    И создана запись на прием к "Ай Бо Лит"

  Сценарий: Просмотр записи на прием
    Допустим Андрей захотел проверить корректость полей: Номер талона, Врач, Специальность, Дата создания записи, Дата приема, Время приема
    И Андрей нажимает “Подробная информация” в записи на прием
    То появится всплывающие окно с полями ЛПУ, адрес ЛПУ, Источник вызова, Дата создания