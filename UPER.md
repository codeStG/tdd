<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>

Achieve an end result that clearly focuses on the following elements of code quality:
* Code easy to read and to maintain (i.e. Clean code)
* Object-oriented design patterns (OOD)
* Object-oriented design principles (SOLID) (Expandable Design)
* Unit testing (TDD)

Requirements for the end result:
* Create a simple console application that prints out the receipt details for the shopping baskets provided.
* Basic sales tax is applicable at a rate of 10% on all goods excluding books, food and medical products that are
 exempt.
* Import duty is applicable on all imported goods at a rate of 5%, no exemptions.
* When an item is purchased, a receipt is received that lists:
    - The name of all the items and their price(including tax).
    - Finish with the total cost of the items and total amount of sales tax paid.
    
The required inputs to test are provided to us along with their expected outputs. The application must print out the
 receipt details for the inputs provided.



<h2>2. Planning the Solution</h2>

To begin, I decided to break up the problem into manageable chunks, or components, to help visualize the individual
 pieces I would have to work on in order to accomplish the goal, and in what order I should work on those pieces.
 
I decided to move forward following the below outline:
1. Receipt will be the primary class containing the majority of the logic and calculations.
    - This is where we will store and calculate the totals to be displayed or used in calculations:
        - totalCostWithTax
        - totalCostWithoutTax
        - totalTax
     - Here we will have a List< Product > products which will contain each product that will be displayed on the
      receipt.
     - This is where we will display the list of products along with their price (tax inclusive) and the total cost
      and total amount of sales tax to be paid.


2. Product will be an interface which can be implemented for various types of products.
    - boolean isImported(); This will determine return True/False depending on whether the product is an import.
    - String getName(); This will return the product name.
    - int getPrice(); This will return the product price.


3. The following classes will implement the Product interface and be considered the "types" of products available for
 purchase:
    - Book - This class will be abstract and exempt from the base sales tax.
    - Food - This class will be abstract and exempt from the base sales tax.
    - Medical - This class will be abstract and exempt from the base sales tax.
    - Other - This class will be abstract and include the base sales tax.
    - <b>I considered combining the Book, Food and Medical classes into one class called Taxable and making Other
     into NonTaxable. TBD</b>


4. The specific products will extend from their respective abstract class and have the following variables:
    - String name;
    - double priceWithoutTax;
    - double priceWithTax;


5. The following constant values are easily identifiable and used only within the Receipt class, so we will make them
 constants solely within that class:
    - double SALES_TAX = 0.10; 
    - double IMPORT_DUTY = 0.05;

<h2>3. Executing the Plan</h2>

<p></p>

<h2>4. Reflection / Refactor</h2>

<p></p>