package com.example.covid19.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CoronaVirusDataService {

	// use the Gitee to change the Github url
	private static String COVID19_DATA_URI = "https://gitee.com/ruhuang/resources-test/raw/master/who_covid_19_sit_rep_time_series.csv";

	@PostConstruct
	public void fetchCovidData() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(COVID19_DATA_URI))
				.build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.body());

	}
}
