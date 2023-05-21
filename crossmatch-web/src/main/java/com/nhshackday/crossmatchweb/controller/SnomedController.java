package com.nhshackday.crossmatchweb.controller;

import java.util.List;

import com.nhshackday.crossmatchweb.model.Project;
import com.eldrix.hermes.client.Hermes;
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

  @GetMapping({"/snomed/search"})
  public String getSnomedSearch(@RequestParam(value = "s") String s, @RequestParam(value = "ecl") String ecl)) {
  }
}
