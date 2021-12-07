package com.karan.SeasonalAnimeTracker.models;

public class Anime {
    private String title;
    private String image_url;
    private String synopsis;
    private int episodes;
    private double score;

    public Anime(String title, String image_url, String synopsis, int episodes, double score) {
        this.title = title;
        this.image_url = image_url;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.score = score;
    }

    public Anime() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "AnimeData{" +
                "title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", episodes=" + episodes +
                ", score=" + score +
                '}';
    }
}
