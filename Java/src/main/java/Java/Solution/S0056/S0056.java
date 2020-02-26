package Java.Solution.S0056;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class S0056 {

  public int[][] merge(int[][] intervals) {
    int intervalCount = intervals.length;
    if (intervalCount <= 1) {
      return intervals;
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });

    int[] currentMergedInterval = intervals[0];
    List<int[]> mergedIntervalList = new LinkedList<>();
    for (int i = 0; i < intervalCount; i++) {
      if (currentMergedInterval[1] >= intervals[i][0]) { // 当前已合并区间终点大于当前区间起点
        if (currentMergedInterval[1] < intervals[i][1]) { // 当前已合并区间终点小于当前区间终点
          currentMergedInterval[1] = intervals[i][1];
        }
      } else { // 当前已合并已合并区间和当前区间没有交集
        mergedIntervalList.add(currentMergedInterval);
        currentMergedInterval = intervals[i];
      }
    }
    mergedIntervalList.add(currentMergedInterval);

    return mergedIntervalList.toArray(new int[mergedIntervalList.size()][]);
  }
}
