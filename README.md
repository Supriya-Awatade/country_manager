# Country_manager
A simple Java console application that performs CRUD operations on countries and regions tables using Hibernate with JPA (Java Persistence API).

# Technologies Used
    -Java
    -Hibernate (JPA)
    -PostgreSQL
    -Maven
# Features
### JPA Integration
Uses Hibernate with JPA for clean and object-oriented database interaction.

### CRUD Operations for regions Table
    -Create a new region
    -View all regions
    -Update an existing region name
    -Delete a region by ID
### CRUD Operations for countries Table
    -Insert a new country with region reference
    -View all countries
    -Update country name
    -Delete a country by country ID
# Project Structure
      Country_manager
      ├── src/
      │     ├── entity/
      │     │     ├── CountryEntity.java
      │     │     └── RegionEntity.java
      │     │
      │     ├── service/
      │     │    ├── CountryService.java
      │     │    └── RegionService.java
      │     │
      │     └── app/
      │         ├── HibernateUtil.java
      │         └── Main.java
      │   
      ├── resources/ 
      │       └── META-INF/
      │             └── persistence.xml
      └── pom.xml
# Dependencies  (pom.xml):

        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>EmployeeCRUD_HibernateJPA</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    </properties>
    <dependencyManagement>
    <dependencies>
    <dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-platform</artifactId>
    <version>7.0.5.Final</version>
    <type>pom</type>
    <scope>import</scope>
    </dependency>
    <!--  https://mvnrepository.com/artifact/jakarta.platform/jakarta.jakartaee-bom  -->
    <dependency>
    <groupId>jakarta.platform</groupId>
    <artifactId>jakarta.jakartaee-bom</artifactId>
    <version>11.0.0</version>
    <type>pom</type>
    <scope>import</scope>
    </dependency>
    </dependencies>
    </dependencyManagement>
    <dependencies>
    <dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    </dependency>
    <dependency>
    <groupId>jakarta.transaction</groupId>
    <artifactId>jakarta.transaction-api</artifactId>
    </dependency>
    <dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    </dependency>
    <!--  https://mvnrepository.com/artifact/org.postgresql/postgresql  -->
    <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.7</version>
    </dependency>
    </dependencies>
    </project>

# Persistence.xml

     <?xml version="1.0" encoding="UTF-8"?>
    <persistence xmlns="https://jakarta.ee/xml/ns/persistence"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
                 version="3.0">
        <persistence-unit name="myPersistence" transaction-type="RESOURCE_LOCAL">
            <class>entity.Region</class>
    		<class>entity.Countries</class>
            <properties>
                <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
                <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5433/hidb"/>
                <property name="jakarta.persistence.jdbc.user" value="postgres"/>
                <property name="jakarta.persistence.jdbc.password" value="1234"/>
                <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
                <property name="hibernate.show_sql" value="true"/>
                <property name="hibernate.format_sql" value="true"/>
                <property name="jakarta.persistence.schema-generation.database.action" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>
 
# Screenshot of output

<img width="341" height="101" alt="2nd" src="https://github.com/user-attachments/assets/cf435041-c6b7-44ff-9326-81813b75d605" />






# Contact Details

-Name : Supriya Suresh Awatade

-Email : supriyaawatade1205@gmail.com
