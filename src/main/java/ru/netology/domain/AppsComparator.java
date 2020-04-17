package ru.netology.domain;

import java.util.Comparator;

public class AppsComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
