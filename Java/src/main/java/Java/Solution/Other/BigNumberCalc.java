package Java.Solution.Other;

public class BigNumberCalc {

  public String add(String a, String b) {
    int aLen = a.length();
    int bLen = b.length();
    if (aLen == 0 && bLen == 0) {
      return "0";
    }
    if (aLen == 0) {
      return b;
    }
    if (bLen == 0) {
      return a;
    }

    char aStartCh = a.charAt(0);
    char bStartCh = b.charAt(0);
    if (aStartCh == '-' && bStartCh != '-') {
      return sub(b, a);
    } else if (aStartCh != '-' && bStartCh == '-') {
      return sub(a, b);
    }

    int aStartI = aStartCh == '-' || aStartCh == '+' ? 1 : 0;
    int bStartI = bStartCh == '-' || bStartCh == '+' ? 1 : 0;
    boolean aMinus = aStartCh == '-' ? true : false;
    boolean bMinus = bStartCh == '-' ? true : false;

    String c = "";
    int carry = 0;
    int ai = aLen - 1, bi = bLen - 1;
    while (ai >= aStartI || bi >= bStartI) {
      char aCh = ai >= aStartI ? a.charAt(ai) : '0';
      char bCh = bi >= bStartI ? b.charAt(bi) : '0';

      int aNum = Character.getNumericValue(aCh), bNum = Character.getNumericValue(bCh);
      if (aMinus != bMinus) {
        aNum = aMinus ? -aNum : aNum;
        bNum = bMinus ? -bNum : bNum;
      }
      int cNum = aNum + bNum + carry;
      carry = cNum / 10;
      cNum = cNum % 10;

      c = String.format("%d", cNum) + c;
      ai--;
      bi--;
    }
    if (carry == 1) {
      c = String.format("%d", carry) + c;
    }
    if (aMinus == bMinus && aMinus == true) {
      c = "-" + c;
    }

    return c;
  }

  public String sub(String a, String b) {
    int aLen = a.length();
    int bLen = b.length();
    if (aLen == 0) {
      return b;
    }
    if (bLen == 0) {
      return a;
    }
    char aStartCh = a.charAt(0);
    char bStartCh = b.charAt(0);
    if (aStartCh != '-' && bStartCh == '-') {
      return add(a, b);
    }

    boolean aBigger = true;
    if (aLen > bLen) {
      aBigger = true;
    } else if (aLen < bLen) {
      aBigger = false;
    } else {
      for (int i = 0; i < aLen; i++) {
        int aNum = Character.getNumericValue(a.charAt(i));
        int bNum = Character.getNumericValue(b.charAt(i));
        if (aNum != bNum) {
          aBigger = aNum > bNum ? true : false;
          break;
        }
      }
    }

    int ai = aLen - 1, bi = bLen - 1, aStartI = 0, bStartI = 0;
    String c = "";
    int carry = 0;
    while (ai >= aStartI || bi >= bStartI) {
      char aCh = ai >= aStartI ? a.charAt(ai) : '0';
      char bCh = bi >= bStartI ? b.charAt(bi) : '0';
      int aNum = Character.getNumericValue(aCh), bNum = Character.getNumericValue(bCh);
      if (aBigger) {
        bNum = -bNum;
      } else {
        aNum = -aNum;
      }
      int cNum = aNum + bNum + carry;
      if (cNum < 0) {
        cNum = 10 + cNum;
        carry = -1;
      } else {
        carry = 0;
      }
      c = String.format("%d", cNum) + c;
      ai--;
      bi--;
    }
    for (int i = 0; i < c.length(); i++) {
      if (c.charAt(i) != '0') {
        c = c.substring(i);
        break;
      }
    }
    c = aBigger ? c : "-" + c;

    return c;
  }
}
