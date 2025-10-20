package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private static final ArrayList<String> DELIMITERS = new ArrayList<>(Arrays.asList(",", ":"));

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String regex = String.join("|", DELIMITERS);
        int[] nums = Arrays.stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("결과 : " + calculate(nums));
    }

    private static int calculate(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
