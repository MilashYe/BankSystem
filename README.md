# BankSystem
    Система Банковские платежи. Пользователь может иметь один или
    несколько банковских Счетов (депозитные, кредитные). Доступ к своему
    
    Счету можно получить после введения логина и пароля. Пользователь
    может делать банковские переводы, оплачивать счета, выводить на экран
    общую информацию (баланса счета, последних операциях, срок действия).
    Для Кредитных Счетов также доступна информация по кредитном лимите,
    текущей задолженности, сумме начисленных процентов, кредитной ставкой.
    Для Депозитных счетов - сумма депозита, ставка, история пополнения.
    Пользователь может подать запрос на открытие кредитного счета, если
    таковой отсутствует. Администратор подтверждает открытие счета с учетом
    размера депозита и срока действия.

    
#Setup

    JDK 1.8 or higher
    Apache Maven 3.6.1 or higher
    MySQL 5.7 or higher
    Apache Tomcat 7.0.93 or higher

#Installation

    Clone project from GitHub (git clone https://github.com/MilashYe/BankSystem)
    Specify values of "login"(username) and "pass"(password) keys in ../src/main/resources/dbconnection.properties
    Execute script ../db/bankdb.sql to create database
    cd to root project folder and execute command mvn clean install
    copy artifact ROOT.war from target folder to %TOMCAT%\webapps

#Running

    Start Tomcat server by running the script %TOMCAT%\bin\startup .bat for Windows or .sh for Unix based OS.
    After server start, application will be available by URL http://localhost:8080/
    Use login "admin" and password "admin" to log in with administrator rights.
    Use login "user1"  and password "user" to log in with user rights.
    To stop server run script %TOMCAT%\bin\shutdown .bat for Windows or .sh for Unix based OS.

