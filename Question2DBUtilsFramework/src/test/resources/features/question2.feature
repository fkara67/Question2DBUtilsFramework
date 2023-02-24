@db
Feature: Homework DB verification

   # 2 - Find the total sales of each staff for each month.

  Scenario Outline: Verify the homework second question's answer with DB
    Given "<month>" "<staff_name>" <sales_count> should match the DB record


    Examples:
      | month    | staff_name   | sales_count |
      | February | Mike Hillyer | 1016        |
      | February | Jon Stephens | 1000        |
      | March    | Mike Hillyer | 2817        |
      | March    | Jon Stephens | 2827        |
      | April    | Jon Stephens | 3390        |
      | April    | Mike Hillyer | 3364        |
      | May      | Mike Hillyer | 95          |
      | May      | Jon Stephens | 87          |