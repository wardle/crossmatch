package com.nhshackday.crossmatchweb.controller;

import com.nhshackday.crossmatchweb.external.HermesResult;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.nhshackday.crossmatchweb.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class SnomedController {

  @Autowired
  private RestTemplate restTemplate;
  @Value("${hermes.uri}")
  private String uri;

  private static final List<Project> PROJECTS = Project.ALL;



  private static String makeOption(HermesResult result) {
    return "<option value=\"" +
            result.getConceptId() +
            "\">" +
            result.getTerm() +
            "</option>";
  }

  private static String makeOptions(List<HermesResult> results) {
    return results.stream().map(SnomedController::makeOption).collect(Collectors.joining());
  }

  private static String makeSelect(String name, List<HermesResult> results) {
    return "<select " +
            "name=\"" +
            name +
            "\" id=\"" +
            name +
            "\">" +
            makeOptions(results) +
            "</select>";
  }

  @GetMapping({"/snomed/search"})
  public @ResponseBody String getSnomedSearch(@RequestParam(value = "name", required = true) String name,
      @RequestParam(value = "s", required = true) String s, @RequestParam(value = "ecl", required = true) String ecl)
      throws URISyntaxException {
    String searchUri = uri.formatted(
        URLEncoder.encode(s, StandardCharsets.UTF_8),URLEncoder.encode(ecl, StandardCharsets.UTF_8));
    ResponseEntity<HermesResult[]> results = restTemplate.getForEntity(new URI(searchUri), HermesResult[].class);
    return makeSelect(name, Arrays.asList(results.getBody()));
  }
}
