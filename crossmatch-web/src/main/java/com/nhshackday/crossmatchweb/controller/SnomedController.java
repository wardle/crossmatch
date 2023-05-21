package com.nhshackday.crossmatchweb.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.nhshackday.crossmatchweb.model.Project;
import com.eldrix.hermes.client.Hermes;
import com.eldrix.hermes.sct.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SnomedController {

  @Autowired
  private Hermes hermes;
  private static final List<Project> PROJECTS = Project.ALL;


  private static String makeOption(IResult result) {
    return "<option value=\"" +
            result.id() +
            "\">" +
            result.term() +
            "</option>";
  }

  private static String makeOptions(List<IResult> results) {
    return results.stream().map(SnomedController::makeOption).collect(Collectors.joining());
  }

  private static String makeSelect(String name, List<IResult> results) {
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
  public String getSnomedSearch(@RequestParam(value = "name") String name, @RequestParam(value = "s") String s, @RequestParam(value = "ecl") String ecl) {
    List<IResult> results = Collections.emptyList(); // TODO: call autocomplete service
    return makeSelect(name, results);
  }
}
