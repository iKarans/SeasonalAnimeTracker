package com.karan.SeasonalAnimeTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SeasonalAnimeTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeasonalAnimeTrackerApplication.class, args);
	}

}
