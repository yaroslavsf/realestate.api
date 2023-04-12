# UK(Überbetriebliche Kurse) - special course in Swiss apprenticeship education

## Covered topics
1) Mapping of cardinalities(m-m, 1-m, 1-1), unidirectional+bidirectional
2) Auditing
3) Custom exception handling
4) Validation

## System architecture
The system architecture of this project is a layered architecture, defined by three layers: presentation, business and data access.
![image](https://user-images.githubusercontent.com/90136987/231436380-af63ceaf-6d61-4ab9-8774-262efb33ba06.png)

## Work with Flyway
### Naming Convention
V + Current Date and Time (YYYYMMDDHHMM) + 2 Underscores + Description + .sql

Examples:
V202111011102__IntialMigration.sql

## Technical task
Realestate management: The web application should enable the agent to create, edit and delete rental objects. It should also be possible to define and save various object properties such as name (lower and upper case letters and numbers), area size (numbers only), canton (lower and upper case letters and hyphen), homegate url to a property (includes the string 'homegate' in the URL) and rental price (minimum CHF 500 and maximum CHF 4500).
	
Roles: 
Users with an "@noseryoung.com" e-mail receive the role "Agent".
All other users get the role "Client".
It must be possible to expand roles at any time.
	
Applicant management: The web application should allow prospective tenants to apply for a rental property. The agent shall be able to approve or reject applications and inform applicants about the status of their application.
If a client's application is approved, all other applications are set to rejected.	
Search function: The web application shall provide a search function that allows users to find rental properties and agents to find clients of their own applications by keywords or attributes.
		
Search for rental properties by canton	
Search for rental property by name (hint: findByXYLike)
Search for user by name (hint: findByXYLike)
	
Code documentation: The code should be documented using comments and automatically generated documentation. (Swagger)

