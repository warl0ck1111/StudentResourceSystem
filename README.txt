MOBILE STUDENT ERESOURCE SYSTEM

FRONT END
 IDE USED:ANDROID STUDIO VERSION 3.0.1
	GRADLE VERSION 5.1
	minSdkVersion 16
	targetSdkVersion 28
 DEPENDENCIES:
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support:support-annotations:28.0.0'
    implementation  'com.google.code.gson:gson:2.8.0'
    implementation 'android.arch.lifecycle:extensions:1.1.1'
    testImplementation 'junit:junit:4.12'
    implementation 'com.android.volley:volley:1.1.1'

BACK END:

IDE USED: NETBEANS VERSION 8.1

DEPENDENCIES:
	org.springframework.boot
        spring-boot-starter-data-jpa
	spring-boot-starter-web
	mysql-connector-java

PLUGINS:
	spring-boot-maven-plugin

Properties:
spring.datasource.url=jdbc:mysql://localhost:3306/studentresource?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull

spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.generate-ddl=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL55Dialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true


*ADJUST YOUR ANDROID STUDIO PROJECT SETTINGS TO THE ONES SPECIFIED(make sure you have internet connetion)
*IMPORT THE MYSQL DATABASE 
*OPEN THE PROJECT ON NETBEANS AND MAKE SURE ALL DEPENDENCIES ARE IN PLACE(MAKE SURE YOUR INTERNET CONNECTION IS ON SO IT AUTOMATICALLY DOWNLOADS IT)
*NOW TURN ON YOUR XAMMP CLICK ON ADMIN AND IMPORT THE "studentresource.sql" file in the MySQL Database folder
*THEN RUN THE NETBEANS PROJECT
*IF EVERYTHING IS IN PLACE THE SPRING SERVER SHOULD RUN NORMAL
*NOW GO TO THE ANDROID PROJECT
*BEFORE YOU RUN IT YOU HAVE TO CONNECT YOUR MOBILE PHONE HOTSPOT AND GET THE IPV4 ADDRESS
*AND THEN REPLACE IT ON THE STATIC URL SECTION IN THE DATA CLASS THEN RUN THE PROJECT
*AFTER THAT YOU CAN PROCEED TO THE USNG THE APP