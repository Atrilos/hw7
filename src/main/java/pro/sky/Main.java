package pro.sky;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void task1() {
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = lastName + " " + firstName + " " + middleName;
        System.out.println(fullName);
    }

    public static void task2() {
        String fullName = "Ivanov Ivan Ivanovich";
        System.out.println(fullName.toUpperCase());
    }

    public static void task3() {
        String fullName = "Иванов Семён Семёнович";
        fullName = Arrays.stream(fullName.split(""))
                .map(s -> {
            if (s.equals("ё")) return "е";
            else return s;
        })
                .collect(Collectors.joining());
        System.out.println(fullName);
    }

    public static void task4(String s) {
        String firstName = s.substring(0, s.indexOf(" "));
        String middleName = s.substring(s.indexOf(" ") + 1, s.lastIndexOf(" "));
        String lastName = s.substring(s.lastIndexOf(" ") + 1);
        System.out.printf("""
                Имя сотрудника - %s
                Фамилия сотрудника - %s
                Отчество сотрудника - %s%n
                """, firstName, middleName, lastName);
    }

    public static String task5(String s) {
        return Arrays
                .stream(s.split(" "))
                .map(str -> str.toUpperCase().charAt(0) + str.substring(1))
                .collect(Collectors.joining(" "));
    }

    public static String task6(String s1, String s2) {
        int pointer1 = 0, pointer2 = 0;
        StringBuilder sb = new StringBuilder();

        while (pointer1 < s1.length() && pointer2 < s2.length()) {
            if (s1.charAt(pointer1) < s2.charAt(pointer2)) {
                sb.append(s1.charAt(pointer1++));
            } else {
                sb.append(s2.charAt(pointer2++));
            }
        }

        if (pointer1 == s1.length()) {
            sb.append(s2.substring(pointer2));
        } else {
            sb.append(s1.substring(pointer1));
        }

        return sb.toString();
    }

    public static String task7(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < s.length(); i++)
            if (i != 0 && s.charAt(i - 1) == s.charAt(i))
                set.add(s.charAt(i));

        return set.stream().map(Objects::toString).collect(Collectors.joining());
    }

    /**
     * task6() with sorting
     */
    public static String task6_2(String s1, String s2) {
        return Stream.of(
                Arrays.stream(s1.split("")).toArray(String[]::new),
                Arrays.stream(s2.split("")).toArray(String[]::new)
        ).flatMap(Stream::of).sorted().collect(Collectors.joining());
    }
}