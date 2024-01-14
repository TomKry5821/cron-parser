### Cron parser
Console application that allows cron expression parsing. Supports given special characters:
- **'*'**
- *-*
- *,*
- */*

Characters that are not supported yet:
- W
- L
- Combination of special characters (e.g. "1,2,3-5,2/5")

### Installation and run

#### Requirements
- JDK 19 installed

#### Installation guide
After downloading the repository, go to the root directory of the project and execute the command

`./gradlew build`

Once built correctly, you can run the application by passing a cron expression as an argument, e.g. 

`./gradlew run --args="'* * * * *'"`
