## Overview
The purpose of this assignment is to create a simple App to display the current weather forecast using the OpenWeatherMap free weather API.  Details of this API can be found at http://openweathermap.org/API.   You will need an API key to request this data…

API Key : 5ad7218f2e11df834b0eaf3a33a39d2a
Example Usage : curl "http://api.openweathermap.org/data/2.5/weather?id=7778677&appid=5ad7218f2e11df834b0eaf3a33a39d2a"

## Objectives
Design and create a simple App that displays the current weather forecast for your devices current location, and display location and all relevant information returned in the UI.  Include a 1-page high level design document that should include all design decisions made, call flows and a description of the App
Send a HTTP request to the OpenWeatherMap API to retrieve the current local weather forecast, and parse the response.
Persist the response so that it can be retrieved again without having to make a further network request.
Schedule a request for every 2 hours to update and persist the latest weather response.  There should not be more than 1 request in a 2-hour period.  All background requests should only be made if Wi-Fi is connected.
Produce clean and well formatted/documented code.

This is version 1.0 of the app.  Design a version 2.0 of the app.  The MVP for version 2.0 contains the following new features:
Favorite city support.  A new tab which contains a configurable list of cities with their current temperature.
Weather forecasts for your current location for the next 5 days
Daily notifications of the next day’s weather. 
The high-level design for these new features should include proposed new call flows, assumptions and any unknowns you want to call out.


## Timescale
We recommend that you spend no more than a few hours designing and developing this App.  We are mainly looking at how you approach this assignment and your coding style and ability. 
