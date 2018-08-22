#   language: en

@acceptanceTest
Feature: Auth in CC
  Задействованные роли:
  Андрей - оператор Колл-Центра

  Scenario: Auth in CC
    Given open website
    And enter "Работай сука"
    And press "Найти"
    Then verify "Work Bitch"
