# UK(Überbetriebliche Kurse) - special course in Swiss apprenticeship education

## Covered topics: 
todo

## Task QV:
 

Developing a web application to manage rental properties for a real estate agent.
The application should enable prospective tenants to apply for a rental property and give the broker the opportunity to manage and respond to applications.
The following requirements must be met:



Object management:
The web application should enable the broker to create, edit and delete rental objects.
It should also be possible to specify various object properties such as name (lower and upper case letters and numbers), area size (only numbers), 
canton (lower and upper case letters and hyphen), homegate url for a property (contains the string 'homegate' in the URL ) and 
rental price (minimum CHF 500 and maximum CHF 4500) and save it.

Role:
Users with an “@noseryoung.com” email are given the “Agent” role.
All other users the role “Client”.
It must be possible to expand roles at any time.



Applicant management:
The web application should enable prospective tenants to apply for a rental property.
The broker should be able to approve or reject applications and inform applicants about the status of their application.

If a client's application is accepted, all other applications are set to rejected.



Search function:
The web application shall offer a search with which users can find rental properties and broker clients from their own applications using keywords or attributes.

Search for rental properties by canton
Search for rental property by name (tip: findByXYLike)
Search for users by name (tip: findByXYLike)



Code documentation:
The code should be documented using comments and automatically generated documentation. (swagger)



 

Spring Boot should be used and a PostgreSQL database should be connected.
