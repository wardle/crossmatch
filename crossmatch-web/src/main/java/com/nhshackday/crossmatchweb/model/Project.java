/*
 * The MIT License (MIT)
 *
 * Copyright 2023 Crown Copyright (Health Education England)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.nhshackday.crossmatchweb.model;

import static com.nhshackday.crossmatchweb.model.AgeBracket.A20_40;
import static com.nhshackday.crossmatchweb.model.AgeBracket.A40_60;
import static com.nhshackday.crossmatchweb.model.AgeBracket.U20;

import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

  public static final List<Project> ALL = List.of(
      Project.builder().name("Assessment of menstruation in women with reproductive potential")
          .id("1").sex(Sex.F).age(Set.of(U20,A20_40,A40_60))
          .build(),
      Project.builder().name("Prospective study on healthy volunteers looking at longevity").id("2")
          .build(),
      Project.builder().name("Assessment of muscle mass in young men").id("3")
          .sex(Sex.M).age(Set.of(U20,A20_40))
          .build());
  private String id;
  private String name;
  private Set<AgeBracket> age;
  private Sex sex;
  private Boolean cardio;
  private Boolean neuro;
  private Boolean diabetic;

}