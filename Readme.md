# Simple Rest Client to weather forecast for next five

Technology Used : Java, Maven,geojson-jackson

prerequisite

1. Set Java Home to 1.8 or higher
2. Install Maven or used any IDE with Maven plugin

How to compile

mvn package

How to Run

Sample Usage : java -jar target/client-1.0-SNAPSHOT.jar 39.7456,-97.0892
Sample Output :

Next Five Day Forecast
Day 1 --> Sunny, with a high near 90. South wind 15 to 20 mph, with gusts as high as 30 mph.
Day 2 --> Mostly clear, with a low around 68. South wind 15 to 20 mph, with gusts as high as 35 mph.
Day 3 --> Mostly sunny, with a high near 92. Southwest wind around 15 mph, with gusts as high as 30 mph.
Day 4 --> Partly cloudy, with a low around 68. Southwest wind 5 to 15 mph, with gusts as high as 25 mph.
Day 5 --> A slight chance of showers and thunderstorms after 1pm. Mostly sunny, with a high near 90. Northeast wind around 5 mph. Chance of precipitation is 20%.

How to clean
mvn clean
