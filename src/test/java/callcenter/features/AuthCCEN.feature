#   language: en

@acceptanceTest
Feature: Auth in CC
  Задействованные роли:
  Андрей - оператор Колл-Центра

  Scenario: Auth in CC
    When что Андрей вошел в АРМ оператора под своей учетной записью
    Then Андрей успешно входит в АРМ оператора