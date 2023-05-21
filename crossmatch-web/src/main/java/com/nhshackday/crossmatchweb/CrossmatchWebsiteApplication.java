package com.nhshackday.crossmatchweb;

import com.eldrix.hermes.client.Hermes;
import com.eldrix.hermes.sct.IResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrossmatchWebsiteApplication {

	public static void main(String[] args) {

		// example
		Hermes hermes = Hermes.openLocal( "/Users/mark/Dev/hermes/snomed.db");
		Hermes.SearchRequest request = Hermes.newSearchRequestBuilder().setFuzzy(0).setFallbackFuzzy(2).setS("parkins").setConstraint("<64572001").setMaxHits(500).build();

		for (IResult result : hermes.search(request)) {
			System.out.println(result.term());
		};

		SpringApplication.run(CrossmatchWebsiteApplication.class, args);
	}

}
