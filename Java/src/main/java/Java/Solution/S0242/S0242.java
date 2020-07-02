package Java.Solution.S0242;

public class S0242 {
  public boolean isAnagram(String s, String t) {

    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }

    int base = 97, sLength = s.length(), tLength = t.length();
    int[] counts = new int[26];
    int i, code;
    for (i = 0; i < sLength; i++) {
      code = s.charAt(i) - base;
      counts[code] += 1;
    }

    for (i = 0; i < tLength; i++) {
      code = t.charAt(i) - base;
      counts[code] -= 1;
    }

    for (int count : counts) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
}
