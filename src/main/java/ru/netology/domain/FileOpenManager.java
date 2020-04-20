package ru.netology.domain;

import java.util.*;

public class FileOpenManager {
    Map<String, String> map = new HashMap<>();

    public void register(String name, String extension) {
        map.put(extension.toLowerCase(), name);
    }

    public String checkName(String extension) {
        return map.get(extension.toLowerCase());
    }

    public void removeConnection(String extension) {
        map.remove(extension.toLowerCase());
    }

    public List<String> getAllExtensions() {
        Set<String> strings = map.keySet();
        List<String> list = new ArrayList<>(strings);
        AppsComparator comparator = new AppsComparator();
        list.sort(comparator);
        return list;
    }

    public Set<String> getAllApps() {
        Collection<String> values = map.values();
        Set<String> appSet = new HashSet<>(values);
        return appSet;
    }
}
