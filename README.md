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

# II. Load Data into Staging Tables with Talend

Staging Jobs –
S.no	Job name
1	Actors_combined
2	Combined_titles
3. 	Converting_runtime_int
4.	Json_staging_names
5. 	Json_staging_titles
6. 	Sql_scripts_staging
7.	Tsv_file_staging

DIM_Loading Jobs –
S.no	Job Name
1.	Date_dim_loading
2. 	Directors_dim
3. 	Genres_dim
4.	Location_dim
5.	Movie_dim_Scd
6.	Person_dim_scd
7.	Principals_dim
8,	Writers_dim

Fact_Loading Jobs –
S.no	Job Name
1.	Fact_movie_accomplishments
2. 	Fact_movie_revenue

Bridge_Loading Jobs –
S.no	Job Name
1.	Genre_movie_bridge
2. 	Region_bridge_loading

# III. Dimensional Modelling

![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/317f6799-2721-48a9-95a1-a0146ba47ec2)

# IV. Mapping of source and target

![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/719d45fa-ca1e-42aa-b1e6-2d94f5811964)

Categorised into 4 kinds 
1. Movie -  ![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/73abcae7-a3c2-4ad7-81e5-639aaed49b32)

2. Revenue/accomplishments -  ![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/d25e140a-934a-453e-b6a2-b688b3a3653b)

3. Workflow - ![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/f0f8c660-3a09-414b-80bb-68862900662f)

4. Person -  ![image](https://github.com/sashank1079/IMDB-ETL-Project/assets/122720872/bba4a9f5-8638-4610-a860-532bbcb909f1)




