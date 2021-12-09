package com.karan.SeasonalAnimeTracker.services;

import com.google.gson.Gson;
import com.karan.SeasonalAnimeTracker.models.Anime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class SeasonalAnimeDataService {
    private final String seasons[] = {
            "sinter", "sinter", "sinter", "spring", "spring", "spring",
            "summer", "summer", "summer", "fall", "fall", "fall"
    };
    private String ANIME_DATA_URL = "https://api.jikan.moe/v3/season/" + Calendar.getInstance().get(Calendar.YEAR) + "/" + seasons[Calendar.getInstance().get(Calendar.MONTH)];
    private ArrayList<Anime> seasonalAnimeList = new ArrayList<>();
    @PostConstruct
    @Scheduled(cron = "* * * 3 * *")
    public void fetchAnimeData() throws IOException, InterruptedException, JSONException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(ANIME_DATA_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray animeArrayJson = jsonObject.getJSONArray("anime");
        Gson gson = new Gson();
        Anime[] animeList = gson.fromJson(String.valueOf(animeArrayJson), Anime[].class);
        ArrayList<Anime> tempSeasonalAnimeList = new ArrayList<>();
        for(int i = 0; i < animeList.length; i++) {
            tempSeasonalAnimeList.add(animeList[i]);
        }
        this.seasonalAnimeList = tempSeasonalAnimeList;
    }

    public ArrayList<Anime> getSeasonalAnimeList() {
        return seasonalAnimeList;
    }

    public void setSeasonalAnimeList(ArrayList<Anime> seasonalAnimeList) {
        this.seasonalAnimeList = seasonalAnimeList;
    }
}
