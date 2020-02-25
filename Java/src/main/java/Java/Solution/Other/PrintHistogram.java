package Java.Solution.Other;

import java.util.List;
import javafx.util.Pair;

public class PrintHistogram {
  public void print(List<Pair<Integer, String>> input) {
    int colCount = input.size();
    if (colCount < 1) {
      return;
    }

    int maxVal = input.get(0).getKey(), minVal = input.get(0).getKey();
    int maxLabelLen = input.get(0).getValue().length();
    for (Pair<Integer, String> pair : input) {
      maxLabelLen = maxLabelLen > pair.getValue().length() ? maxLabelLen : pair.getValue().length();
      maxVal = maxVal > pair.getKey() ? maxVal : pair.getKey();
      minVal = minVal < pair.getKey() ? minVal : pair.getKey();
    }

    int rowCount = 0, yZeroIndex = 0;
    if (maxVal > 0 && minVal > 0) {
      rowCount = maxVal;
      yZeroIndex = rowCount;
    } else if (maxVal > 0 && minVal < 0) {
      rowCount = maxVal - minVal;
      yZeroIndex = maxVal;
    } else if (maxVal < 0 && minVal < 0) {
      rowCount = Math.abs(minVal);
      yZeroIndex = 0;
    }

    char graph[][] = new char[rowCount][colCount];
    for (int colIndex = 0; colIndex < colCount; colIndex++) {
      Pair<Integer, String> pair = input.get(colIndex);
      int middleLine = yZeroIndex - 1;
      int pairValue = pair.getKey();
      if (pairValue > 0) {
        for (int rowIndex = pairValue; rowIndex > 0; rowIndex--) {
          graph[middleLine--][colIndex] = '#';
        }
      } else {
        for (int rowIndex = Math.abs(pairValue); rowIndex > 0; rowIndex--) {
          graph[++middleLine][colIndex] = '#';
        }
      }
    }

    for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
      for (int colIndex = 0; colIndex < colCount; colIndex++) {
        System.out.print(graph[rowIndex][colIndex]);
      }
      System.out.println();
    }
    for (int colIndex = 0; colIndex < colCount; colIndex++) {
      System.out.print("_");
    }
    System.out.println();
    for (int rowIndex = 0; rowIndex < maxLabelLen; rowIndex++) {
      for (int colIndex = 0; colIndex < colCount; colIndex++) {
        String label = input.get(colIndex).getValue();
        if (rowIndex < label.length()) {
          System.out.print(label.charAt(rowIndex));
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
