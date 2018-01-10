# City Distance Calculator
Program reads a cvs file with cities' coordinates and calculates distance between two given cities

## Prerequisites
* Maven
* JDK

## How to run
### Create a jar file
1. Run Command Prompt
2. Change directory to project folder
3. Run command ```mvn clean install```
4. Jar file will be located in "target" folder

### Run program
1. Run Command Prompt
2. Run command ```java -jar PathToJarFile.jar```
3. Program will ask you to enter path to csv file containing information on cities
4. Program will ask you to enter names of cities of which you want to calculate distance
5. To continue calculating distances press enter, to quit type q and enter

## CVS File Format
City Name;Decimal Latitude;Decimal Longitude
```
London;51.507222;-0.1275
Warsaw;52.233333;21.016667
```

## Built With
* Maven
