package com.karan.SeasonalAnimeTracker.services;

import com.google.gson.Gson;
import com.karan.SeasonalAnimeTracker.models.Anime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
public class SeasonalAnimeDataService {
    public String ANIME_DATA_URL = "https://api.jikan.moe/v3/season/2019/summer";

    @PostConstruct
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
        ArrayList<Anime> seasonalAnimeList = new ArrayList<>();
        for(int i = 0; i < animeList.length; i++) {
            seasonalAnimeList.add(animeList[i]);
        }

    }
}
