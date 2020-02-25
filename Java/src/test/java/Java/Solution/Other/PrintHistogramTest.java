package Java.Solution.Other;

import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;
import org.junit.Test;

public class PrintHistogramTest {

  @Test
  public void test1() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(5, "a"));
    input.add(new Pair<Integer, String>(2, "b"));
    input.add(new Pair<Integer, String>(-5, "d"));
    input.add(new Pair<Integer, String>(-3, "c"));
    input.add(new Pair<Integer, String>(9, "e"));

    System.out.println("图1");
    printHistogram.print(input);
    System.out.println("\n");
  }

  @Test
  public void test2() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(-5, "a"));
    input.add(new Pair<Integer, String>(-2, "b"));
    input.add(new Pair<Integer, String>(-5, "d"));
    input.add(new Pair<Integer, String>(-3, "c"));
    input.add(new Pair<Integer, String>(-9, "e"));

    System.out.println("图2");
    printHistogram.print(input);
    System.out.println("\n");
  }

  @Test
  public void test3() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(5, "a"));
    input.add(new Pair<Integer, String>(2, "b"));
    input.add(new Pair<Integer, String>(5, "d"));
    input.add(new Pair<Integer, String>(3, "c"));
    input.add(new Pair<Integer, String>(9, "e"));

    System.out.println("图3");
    printHistogram.print(input);
    System.out.println("\n");
  }

  @Test
  public void test4() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(0, "a"));
    input.add(new Pair<Integer, String>(1, "b"));
    input.add(new Pair<Integer, String>(0, "d"));
    input.add(new Pair<Integer, String>(-1, "c"));
    input.add(new Pair<Integer, String>(0, "e"));

    System.out.println("图4");
    printHistogram.print(input);
    System.out.println("\n");
  }

  @Test
  public void test5() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(5, "awed"));
    input.add(new Pair<Integer, String>(2, "bwfwe"));
    input.add(new Pair<Integer, String>(-5, "dgwer"));
    input.add(new Pair<Integer, String>(-3, "cwer"));
    input.add(new Pair<Integer, String>(9, "ewerg"));

    System.out.println("图5");
    printHistogram.print(input);
    System.out.println("\n");
  }

  @Test
  public void test6() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(-5, "awef"));
    input.add(new Pair<Integer, String>(-2, "bfaf"));
    input.add(new Pair<Integer, String>(-5, "dasdfasfasd"));
    input.add(new Pair<Integer, String>(-3, "casdfwerweer"));
    input.add(new Pair<Integer, String>(-9, "e"));

    System.out.println("图6");
    printHistogram.print(input);
    System.out.println("\n");
  }

  @Test
  public void test7() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(5, "acafasf"));
    input.add(new Pair<Integer, String>(2, "bwew"));
    input.add(new Pair<Integer, String>(5, "dwwehdf"));
    input.add(new Pair<Integer, String>(3, "cwerwr"));
    input.add(new Pair<Integer, String>(9, "easdfewrw"));

    System.out.println("图7");
    printHistogram.print(input);
    System.out.println("\n");
  }

  @Test
  public void test8() {
    PrintHistogram printHistogram = new PrintHistogram();
    List<Pair<Integer, String>> input = new LinkedList<>();
    input.add(new Pair<Integer, String>(0, "awerwer"));
    input.add(new Pair<Integer, String>(1, "basdfwerw"));
    input.add(new Pair<Integer, String>(0, "dasdf"));
    input.add(new Pair<Integer, String>(-1, "c"));
    input.add(new Pair<Integer, String>(0, "easdfsaf"));

    System.out.println("图8");
    printHistogram.print(input);
    System.out.println("\n");
  }
}
