package com.lamudi.phonefield;

import java.util.ArrayList;
import java.util.List;

public final class Countries {

  public static final List<Country> COUNTRIES = new ArrayList<>();
  static {
    COUNTRIES.add(new Country("hk", "Hong Kong (香港)", 852));
    COUNTRIES.add(new Country("id", "Indonesia", 62));
    COUNTRIES.add(new Country("my", "Malaysia", 60));
    COUNTRIES.add(new Country("sg", "Singapore", 65));
  }

}
