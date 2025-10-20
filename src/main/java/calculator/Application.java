package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private static final ArrayList<String> DELIMITERS = new ArrayList<>(Arrays.asList(",", ":"));

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (validateEmpty(input)) {
            System.out.println("결과 : 0");
            return;
        }

        input = parseCustomDelimiter(input);

        String regex = String.join("|", DELIMITERS);
        int[] nums = Arrays.stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("결과 : " + calculate(nums));
    }

    private static String parseCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int backslashIndex = input.indexOf('\\');
            if (backslashIndex == -1) {
                throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
            }
            if (input.charAt(backslashIndex + 1) != 'n') {
                throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
            }

            String customDelimiters = input.substring(2, backslashIndex);
            DELIMITERS.addAll(Arrays.asList(customDelimiters.split("")));

            return input.substring(backslashIndex + 2);
        }

        return input;
    }

    private static int calculate(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num <= 0) {
                throw new IllegalArgumentException("입력받은 정수가 양수가 아닙니다.");
            }
            sum += num;
        }
        return sum;
    }

    private static boolean validateEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
