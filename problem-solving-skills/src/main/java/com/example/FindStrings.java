package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FindStrings {

    public static void main(String[] args) {
        List<String> r = findStrings(List.of("aab", "aac"), List.of(3, 8, 21));
        System.out.println(r);
    }

    private static void findSubsequences(List<String> al, String s,String ans) {
        if (s.trim().length() != 0) {
            al.add(ans);
            return;
        }
        findSubsequences(al, s.substring(1), ans+s.charAt(0));
        findSubsequences(al, s.substring(1),ans);
    }


    private static List<String> findStrings(List<String> w, List<Integer> queries) {
        List<String> S =
                w
                        .stream()
                        .flatMap(s -> {
                            List<String> list = new ArrayList<>();
//                            for (int i = 0; i < s.length(); i++) {
//                                for (int j = i + 1; j <= s.length(); j++) {
//                                    list.add(s.substring(i, j));
//                                }
//                            }
                            System.out.println(s);
                            findSubsequences(list, s,"");
                            System.out.println(list);
                            return list.stream();
                        })
                        .distinct()
                        .sorted()
                        .collect(toList());

        System.out.println(S);

        List<String> result = new ArrayList<>();
        for (Integer q : queries) {
            try {
                result.add(S.get(q - 1));
            } catch (IndexOutOfBoundsException e) {
                result.add("INVALID");
            }
        }
        return result;
    }
}
