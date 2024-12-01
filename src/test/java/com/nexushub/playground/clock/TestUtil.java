package com.nexushub.playground.clock;

public class TestUtil {
  private final String[] esIsch = {"\033[0;1mE\033[0;0m", "\033[0;1mS\033[0;0m", "K", "\033[0;1mI\033[0;0m", "\033[0;1mS\033[0;0m", "\033[0;1mC\033[0;0m", "\033[0;1mH\033[0;0m", "A", "F", "Ü", "F"};

  private final String[] esIschFünf = {"\033[0;1mE\033[0;0m", "\033[0;1mS\033[0;0m", "K", "\033[0;1mI\033[0;0m", "\033[0;1mS\033[0;0m", "\033[0;1mC\033[0;0m", "\033[0;1mH\033[0;0m", "A", "\033[0;1mF\033[0;0m", "\033[0;1mÜ\033[0;0m", "\033[0;1mF\033[0;0m"};

  private final String[] zää = {"V", "I", "E", "R", "T", "U", "B", "F", "\033[0;1mZ\033[0;0m", "\033[0;1mÄ\033[0;0m", "\033[0;1mÄ\033[0;0m"};

  private final String[] viertel = {"\033[0;1mV\033[0;0m", "\033[0;1mI\033[0;0m", "\033[0;1mE\033[0;0m", "\033[0;1mR\033[0;0m", "\033[0;1mT\033[0;0m", "\033[0;1mU\033[0;0m", "B", "F", "Z", "Ä", "Ä"};

  private final String[] zwänzig = {"\033[0;1mZ\033[0;0m", "\033[0;1mW\033[0;0m", "\033[0;1mÄ\033[0;0m", "\033[0;1mN\033[0;0m", "\033[0;1mZ\033[0;0m", "\033[0;1mG\033[0;0m", "S", "I", "V", "O", "R"};

  private final String[] zwänzigVor = {"\033[0;1mZ\033[0;0m", "\033[0;1mW\033[0;0m", "\033[0;1mÄ\033[0;0m", "\033[0;1mN\033[0;0m", "\033[0;1mZ\033[0;0m", "\033[0;1mG\033[0;0m", "S", "I", "\033[0;1mV\033[0;0m", "\033[0;1mO\033[0;0m", "\033[0;1mR\033[0;0m"};

  private final String[] vor = {"Z", "W", "Ä", "N", "Z", "G", "S", "I", "\033[0;1mV\033[0;0m", "\033[0;1mO\033[0;0m", "\033[0;1mR\033[0;0m"};

  private final String[] ab = {"\033[0;1mA\033[0;0m", "\033[0;1mB\033[0;0m", "O", "H", "A", "U", "B", "I", "E", "P", "M"};

  private final String[] abHaubi = {"\033[0;1mA\033[0;0m", "\033[0;1mB\033[0;0m", "O", "\033[0;1mH\033[0;0m", "\033[0;1mA\033[0;0m", "\033[0;1mU\033[0;0m", "\033[0;1mB\033[0;0m", "\033[0;1mI\033[0;0m", "E", "P", "M"};

  private final String[] haubi = {"A", "B", "O", "\033[0;1mH\033[0;0m", "\033[0;1mA\033[0;0m", "\033[0;1mU\033[0;0m", "\033[0;1mB\033[0;0m", "\033[0;1mI\033[0;0m", "E", "P", "M"};

  private final String[] eis = {"\033[0;1mE\033[0;0m", "\033[0;1mI\033[0;0m", "\033[0;1mS\033[0;0m", "Z", "W", "Ö", "I", "S", "D", "R", "Ü"};

  private final String[] uhr = {"Z", "W", "Ö", "U", "F", "I", "A", "M", "\033[0;1mU\033[0;0m", "\033[0;1mH\033[0;0m", "\033[0;1mR\033[0;0m"};

  private final String[] e2 = {"V", "I", "E", "R", "T", "U", "B", "F", "Z", "Ä", "Ä"};

  private final String[] e3 = {"Z", "W", "Ä", "N", "Z", "G", "S", "I", "V", "O", "R"};

  private final String[] e4 = {"A", "B", "O", "H", "A", "U", "B", "I", "E", "P", "M"};

  private final String[] e6 = {"V", "I", "E", "R", "I", "F", "Ü", "F", "I", "Q", "T"};

  private final String[] e7 = {"S", "Ä", "C", "H", "S", "I", "S", "I", "B", "N", "I"};

  private final String[] e8 = {"A", "C", "H", "T", "I", "N", "Ü", "N", "I", "E", "L"};

  private final String[] e9 = {"Z", "Ä", "N", "I", "E", "R", "B", "E", "U", "F", "I"};

  String[][] array = {{"\033[0;1mE\033[0;0m", "\033[0;1mS\033[0;0m", "K", "\033[0;1mI\033[0;0m", "\033[0;1mS\033[0;0m", "\033[0;1mC\033[0;0m", "\033[0;1mH\033[0;0m", "A", "F", "Ü", "F"}, {"V", "I", "E", "R", "T", "U", "B", "F", "Z", "Ä", "Ä"}, {"Z", "W", "Ä", "N", "Z", "G", "S", "I", "V", "O", "R"}, {"A", "B", "O", "H", "A", "U", "B", "I", "E", "P", "M"}, {"E", "I", "S", "Z", "W", "Ö", "I", "S", "D", "R", "Ü"}, {"V", "I", "E", "R", "I", "F", "Ü", "F", "I", "Q", "T"}, {"S", "Ä", "C", "H", "S", "I", "S", "I", "B", "N", "I"}, {"A", "C", "H", "T", "I", "N", "Ü", "N", "I", "E", "L"}, {"Z", "Ä", "N", "I", "E", "R", "B", "E", "U", "F", "I"}, {"Z", "W", "Ö", "U", "F", "I", "A", "M", "\033[0;1mU\033[0;0m", "\033[0;1mH\033[0;0m", "\033[0;1mR\033[0;0m"}};


  public String[][] fünfAbEis() {
    return new String[][]{esIschFünf, e2, e3, ab, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] zääAbEis() {
    return new String[][]{esIsch, zää, e3, ab, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] viertelAbEis() {
    return new String[][]{esIsch, viertel, e3, ab, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] zwänzigAbEis() {
    return new String[][]{esIsch, e2, zwänzig, ab, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] fünfAbHalbiEis() {
    return new String[][]{esIschFünf, e2, e3, abHaubi, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] halbiEis() {
    return new String[][]{esIsch, e2, e3, haubi, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] fünfVorEis() {
    return new String[][]{esIschFünf, e2, vor, e4, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] zääVorEis() {
    return new String[][]{esIsch, zää, vor, e4, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] viertelVorEis() {
    return new String[][]{esIsch, viertel, vor, e4, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] zwanzigVorEis() {
    return new String[][]{esIsch, e2, zwänzigVor, e4, eis, e6, e7, e8, e9, uhr};
  }

  public String[][] fünfVorHalbiEis() {
    return new String[][]{esIschFünf, e2, vor, haubi, eis, e6, e7, e8, e9, uhr};
  }
}
