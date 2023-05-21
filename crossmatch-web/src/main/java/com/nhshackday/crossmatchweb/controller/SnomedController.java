package com.nhshackday.crossmatchweb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.nhshackday.crossmatchweb.model.Project;
import com.eldrix.hermes.sct.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SnomedController {

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

  private static List<IResult> performSearch(String s, String ecl) {
    // TODO: call the HTTP API here
    return Collections.emptyList();
  }

  @GetMapping({"/snomed/search"})
  public @ResponseBody String getSnomedSearch(@RequestParam(value = "name") String name, @RequestParam(value = "s") String s, @RequestParam(value = "ecl") String ecl) {
    if (name == null || s == null || ecl == null || name.isBlank() || s.isBlank() || ecl.isBlank()) {
      throw new IllegalArgumentException("Invalid parameter(s)");
    }
    List<IResult> results = performSearch(s, ecl);
    return makeSelect(name, results);
  }
}
