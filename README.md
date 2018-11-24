### Setup 
* JDK 1.8 or higher
* Apache Maven 4.0.0 or higher
* MySQL 8.0 or higher
* Apache Tomcat 7.0.0 or higher

### Installation
* Download project from GitHub
* Unpack .zip
* Specify values of "username" and "password" keys in _\src\main\webapp\META-INF\context.xml_
* Start MySQL server and execute script initdb.sql from _\src\main\resources\dbscripts_ to init database
* cd to root project folder and execute command _mvn clean install_
* copy artifact expocalendar.war from _target_ folder to _%TOMCAT%\webapps_
