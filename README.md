# Recipe Book Application 

![recipe 1](https://github.com/amalg20/Final-Java-Angular-9w-GitHub-repo2/assets/145042005/8b732eb6-3785-46b7-b1a5-0f49482fb822)



## 1. Description of the project:

The recipe book app allows users to create accounts to save and organize their personal recipes. They can add new recipes with details like title, ingredients, instructions, and an image. 

Recipes can also be tagged with categories for easy filtering. 

Users can view a list of all their recipes, search for specific ones, and open up individual recipes to see the details. Recipes can be edited or deleted as needed.


## 2. Class Diagram:

![class-diagram](https://github.com/amalg20/Final-Java-Angular-9w-GitHub-repo2/assets/145042005/8a788c5d-a57a-49cc-8476-d5434e22cfb0)


## 3. Use case Diagram:


## 4. Setup:

To setup the project I used:
**i. Java 17**
**ii. Maven**

## 5. Technologies Used:

1. Spring Boot 3.1.5
2. Maven
3. Junit 5
4. Postman
5. DBeaver

## 6. Controllers and Routes structure:

**1.RecipeController:**

A. /api/recipes/ : Get All Recipes

B. /api/recipes/+ recipe.getId() : Update Recipe

C. /api/recipes/ + recipe.getId() : Delete Recipe

**2.IngredientController:**

A. /api/ingredient-items/ : Get All Ingredient

B. /api/ingredient-items/ + ingredient.getId() : Update Ingredient

C. /api/ingredient-items/ + ingredient.getId() : Delete Ingredient

**3.CategoryController:** 

A. /api/category-items/ : Get All Category

B. /api/category-items/ + category.getId() : Update Category

C. /api/category-items/ + category.getId() : Delete Category

**3.AuthController:** 

A. /api/auth/signin : To Signin

B. /api/auth/signup : To Signup

## 7. Steps:

1) Created Spring Boot project with Maven and Java 
2) Defined Category, Ingredient, Recipe, Role, and User model classes under model package
3) Added JPA annotations and relationships between entities
4) Tested repositories by saving and fetching sample data
5) Created REST controllers for CRUD operations on entities
6) Moved controller logic to service classes
7) Wrote MockMVC tests for controller methods
8) Implemented exception handling with @ControllerAdvice
9) Configured MySQL database with Spring Data JPA
10) Used postman to test the URL .
11) Used Git for version control and GitHub for remote repo.

## 8. Extra Information:

First, create Recipe, User, and other model classes. Then, configure Spring Data JPA to interact with database. Most build REST controllers for CRUD operations on recipes.
Also, authenticate users with Spring Security. The, write service layer methods for business logic.
However, add input validation annotations on models. Last, write unit and integration tests using JUnit.


## 9. Extra links : 

https://prezi.com/p/edit/uuwumx1g50nm/

## 10. Future Work:

1. I will connect to the Frontend and Dispaly the app.
2. I will add the Admin for the app.

## 11. Resources:

1. https://play.google.com/store/apps/details?id=com.desertstorm.recipebook

## Thank you! :)
