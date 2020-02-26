package Java.Solution.BasicTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

public class BasicTest {

  // Comparator比较方法返回值测试
  @Test
  public void testComparatorReturnVal() {
    int[][] input = {{362, 367}, {314, 315}, {133, 138}, {434, 443}, {202, 203}, {144, 145},
        {229, 235}, {205, 212}, {314, 323}, {128, 129}, {413, 414}, {342, 345}, {43, 49},
        {333, 342}, {173, 178}, {386, 391}, {131, 133}, {157, 163}, {187, 190}, {186, 186},
        {17, 19}, {63, 69}, {70, 79}, {386, 391}, {98, 102}, {236, 239}, {195, 195}, {338, 338},
        {169, 170}, {151, 153}, {409, 416}, {377, 377}, {90, 96}, {156, 165}, {182, 186},
        {371, 372}, {228, 233}, {297, 306}, {56, 61}, {184, 190}, {401, 403}, {221, 228},
        {203, 212}, {39, 43}, {83, 84}, {66, 68}, {80, 83}, {32, 32}, {182, 182}, {300, 306},
        {235, 238}, {267, 272}, {458, 464}, {114, 120}, {452, 452}, {372, 375}, {275, 280},
        {302, 302}, {5, 9}, {54, 62}, {237, 237}, {432, 439}, {415, 421}, {340, 347}, {356, 358},
        {165, 168}, {15, 17}, {259, 265}, {201, 204}, {192, 197}, {376, 383}, {210, 211},
        {362, 367}, {481, 488}, {59, 64}, {307, 315}, {155, 164}, {465, 467}, {55, 60}, {20, 24},
        {297, 304}, {207, 210}, {322, 328}, {139, 142}, {192, 195}, {28, 36}, {100, 108}, {71, 76},
        {103, 105}, {34, 38}, {439, 441}, {162, 168}, {433, 433}, {368, 369}, {137, 137},
        {105, 112}, {278, 280}, {452, 452}, {131, 132}, {475, 480}, {126, 129}, {95, 104}, {93, 99},
        {394, 403}, {70, 78}};
    Arrays.sort(input, new Comparator<int[]>() {
      /**
       * 返回值0非常特殊, 是个大坑! 返回0, 表示不交换顺序, 但表示两个元素相同.
       * 而在map中比较的是key, 如果比较key发现相同, 则会发生覆盖, 进而造成数据丢失.
       */
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] > o2[0]) {
          return 1; // 交换
        }
        return -1; // 不交换
      }
    });
    Assert.assertTrue(input[0][0] == 5 && input[0][1] == 9);
  }

  // Collections.toArray用法测试
  @Test
  public void toArrayTest() {
    List<Integer> intList = new LinkedList<>();
    intList.add(10);
    intList.add(89);
    // 这样使用报错, 返回的Object[]无法转换为Integer[]
    // Integer[] nums = (Integer[])intList.toArray();

    // 在参数中指定返回类型, 参数数组大小小于实际元素多少不影响返回结果
    Integer[] nums1 = intList.toArray(new Integer[0]);
    for (int num : nums1) {
      System.out.print(String.format("%d ", num));
    }
    System.out.println("\n");

    // 参数数组大小与实际元素数组大小相同时, 正常返回所有元素
    Integer[] param2 = new Integer[2];
    Integer[] nums2 = intList.toArray(param2);
    for (int num : nums2) {
      System.out.print(String.format("%d ", num));
    }
    System.out.println();
    for (int num : param2) {
      System.out.print(String.format("%d ", num));
    }
    System.out.println("\n");

    // 参数数组大小超过实际元素大小时, 超出部分元素为null
    Integer[] param3 = new Integer[5];
    Integer[] nums3 = intList.toArray(param3);
    for (int num : nums3) {
      System.out.print(num);
      System.out.print(" ");
    }
    System.out.println();
    for (int num : param3) {
      System.out.print(num);
      System.out.print(" ");
    }
  }

  @Test
  public void testSplitTimeByMonth() {
    long startTime = getDateTimeTs("2019-12-05 09:00:00"),
        endTime = getDateTimeTs("2020-05-01 00:00:00");
    List<Pair<String, String>> list = rangeToListByMonth(startTime, endTime);
    for (Pair<String, String> item : list) {
      System.out.println(String.format("%s, %s", item.getKey(), item.getValue()));
    }
    System.out.println("\n\n\n");

    startTime = getDateTimeTs("2019-12-05 09:00:00");
    endTime = getDateTimeTs("2020-01-01 00:00:00");
    list = rangeToListByMonth(startTime, endTime);
    for (Pair<String, String> item : list) {
      System.out.println(String.format("%s, %s", item.getKey(), item.getValue()));
    }
    System.out.println("\n\n\n");

    startTime = getDateTimeTs("2019-02-05 09:00:00");
    endTime = getDateTimeTs("2019-03-29 19:00:00");
    list = rangeToListByMonth(startTime, endTime);
    for (Pair<String, String> item : list) {
      System.out.println(String.format("%s, %s", item.getKey(), item.getValue()));
    }
  }

  private List<Pair<String, String>> rangeToListByMonth(long startTime, long endTime) {
    List<Pair<String, String>> timeListByMonth = new LinkedList<>();

    Date currentStartDate = new Date(startTime);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentStartDate);
    calendar.add(Calendar.MONTH, 1);
    Date nextMonth = calendar.getTime();
    long currentStartTime = startTime;
    long currentEndTime = nextMonth.getTime();
    String dateOfCurrentMonth =
        getDateTimeStr(currentEndTime).substring(0, 8) + "01 00:00:00";
    long endtimeOfCurrentMonth = getDateTimeTs(dateOfCurrentMonth);
    while (endtimeOfCurrentMonth <= endTime) {
      timeListByMonth.add(new Pair<String, String>(getDateTimeStr(currentStartTime),
          getDateTimeStr(endtimeOfCurrentMonth - 1)));
      currentStartTime = endtimeOfCurrentMonth;
      currentStartDate = new Date(currentStartTime);
      calendar = Calendar.getInstance();
      calendar.setTime(currentStartDate);
      calendar.add(Calendar.MONTH, 1);
      currentEndTime = calendar.getTime().getTime();
      dateOfCurrentMonth = getDateTimeStr(currentEndTime).substring(0, 8) + "01 00:00:00";
      endtimeOfCurrentMonth = getDateTimeTs(dateOfCurrentMonth);
    }
    timeListByMonth.add(new Pair<String, String>(
        getDateTimeStr(endTime).substring(0, 8) + "01 00:00:00",
        getDateTimeStr(endTime)));

    return timeListByMonth;
  }

  private String getDateTimeStr(long timestmap) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
    return df.format(new Date(timestmap));
  }

  private long getDateTimeTs(String strDateTime) {
    long ts = 0;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      ts = sdf.parse(strDateTime).getTime();
    } catch (java.text.ParseException e) {
    }
    return ts;
  }
}