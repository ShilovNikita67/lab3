@echo off
if exist out rmdir /s /q out
if exist lab3.jar del lab3.jar
mkdir out
javac -encoding UTF-8 -d out -sourcepath src src\ru\university\lab3\Main.java
jar cfm lab3.jar manifest.mf -C out .
echo Готово: lab3.jar. Запуск: java -jar lab3.
