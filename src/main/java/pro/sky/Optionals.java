package pro.sky;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Optionals {
    public static String task1(String input) {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(input.split("")).forEach(s -> sb.append(s).append(s));

        return sb.toString();
    }

    public static String task2(String brackets, String input) {
        StringBuilder sb = new StringBuilder();
        String beginning = brackets.substring(0, brackets.length() / 2);
        String ending = brackets.substring(brackets.length() / 2);

        sb.append(beginning).append(input).append(ending);

        return sb.toString();
    }

    public static String task3(String a, String b) {
        StringBuilder sb = new StringBuilder();

        if (a.isEmpty()) {
            sb.append('@');
        } else {
            sb.append(a.charAt(0));
        }

        if (b.isEmpty()) {
            sb.append('@');
        } else {
            sb.append(b.charAt(b.length() - 1));
        }

        return sb.toString();
    }

    public static String task4(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            if (i >= input.length() - 2) {
                if (i == input.length() - 2) {
                    sb.append(input.charAt(i)).append(input.charAt(i + 1));
                }
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.reverse().toString();
    }

    public static String task4(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int minLength = Math.min(s1.length(), s2.length());

        if (minLength == s1.length()) {
            s2 = s2.substring(s2.length() - minLength);
        } else {
            s1 = s1.substring(s1.length() - minLength);
        }
        return sb.append(s1).append(s2).toString();
    }

    public static int task5(String input) {
        int count = 0;
        Matcher m = Pattern.compile("hi").matcher(input);

        while (m.find()) {
            ++count;
        }
        return count;
    }

    public static int task6(String input) {
        int maxCount = 0;
        Character last = null;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (last == null) {
                last = input.charAt(i);
                count = 1;
            } else if (last.equals(input.charAt(i))) {
                ++count;
            } else {
                last = input.charAt(i);
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
        }
        return maxCount;
    }

    public static String task7(String word, String separator, int repeats) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < repeats; i++) {
            sb.append(word);
            if (i != repeats - 1) {
                sb.append(separator);
            }
        }

        return sb.toString();
    }
}
