# Seasonal Anime Tracker

![Math Dojo Project Image](https://github.com/iKarans/SeasonalAnimeTracker/blob/master/SeasonalAnimeTracker.png)

## Introduction

A seasonal anime tracket table built using Java, Spring, Bootstrap.

The table has for coloumn: Tile, Image, Synopsis and Score. It is sorted in descending order by the score and the data is fetched from the [Jikan API](https://jikan.moe). The [Gson library](https://github.com/google/gson) to convert the response into the Anime Java Object. Thymeleaf is used to create the HTML and the styling for the table is taken from bootstrap.

## Improvements / To-Dos

- [ ] Try to fetch from official MAL API, need to figure out the auth key.
