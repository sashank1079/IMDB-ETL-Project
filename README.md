# IMDB-ETL-Project
Implemented an end-to-end data pipeline utilizing Talend Studio, with Alteryx for data profiling, MySQL and Microsoft Azure Database for staging, SCD for data integrity, and Power BI/Tableau for analytics.

# I. Perform Data Profiling with Alteryx 
![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/5e985fbf-7935-40da-8f95-aa0d3eafc2c0)
![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/f42bec9a-0e34-4cd5-b6fe-f6a40316477e)

- The Alteryx workflows involve data profiling on TSV files containing information from the IMDB database, specifically focusing on six tables. In the first table, "IMDB NAME BASICS," individual identifiers, names, birth and death years, professions, and known titles are stored, each with specific data constraints. 

- The second table, "IMDB TITLE AKAS," contains details about movie titles, including language, region, and release information. 

- The third table, "IMDB TITLE BASICS," provides information about movies, such as title type, adult content, release years, and genres. These tables are interconnected through unique identifiers, ensuring data integrity and relational structure.

- The fourth table, "IMDB TITLE CREW," lists the directors and writers associated with each movie, with creation timestamps. 

- The fifth table, "IMDB TITLE PRINCIPALS," includes details about individuals involved in a movie, such as their roles, order of appearance, and associated characters. 

- Lastly, the sixth table, "IMDB TITLE RATINGS," involves ratings assigned to movies, with director and writer information. The data in these tables is crucial for understanding the relationships between movies, individuals, and their respective roles in the filmmaking process.

- Additionally, the workflows involve analyzing revenue data, which is spread across nine separate CSV files. Each file has 11 columns with specific data constraints. The revenue data includes movie identifiers, titles, dates, ranks, gross earnings, percentages, theater information, total gross, and duration. Data validation checks reveal issues such as trailing spaces and null values, providing insights into data quality and potential cleaning requirements.

- The comprehensive overview of these Alteryx workflows and associated TSV files underscores the complexity and richness of the IMDB dataset, offering valuable insights for data analysis and exploration.


