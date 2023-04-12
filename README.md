# UK(Überbetriebliche Kurse) - special course in Swiss apprenticeship education

##Covered topics
1) Mapping of cardinalities(m-m, 1-m, 1-1), unidirectional+bidirectional
2) Auditing
3) Custom exception handling
4) Validation

##System architecture
The system architecture of this project is a layered architecture, defined by three layers: presentation, business and data access.
![image](https://user-images.githubusercontent.com/90136987/231436380-af63ceaf-6d61-4ab9-8774-262efb33ba06.png)

##Work with Flyway
###Naming Convention
V + Current Date and Time (YYYYMMDDHHMM) + 2 Underscores + Description + .sql

Examples:
V202111011102__DDL_IntialMigration.sql
