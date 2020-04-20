package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileOpenManagerTest {

    FileOpenManager fileOpenManager = new FileOpenManager();

    @Test
    void getName() {
        fileOpenManager.register("Word", "txt");
        assertEquals("Word", fileOpenManager.checkName("txt"));
    }

    @Test
    void removeConnection() {
        fileOpenManager.register("Word", "txt");
        fileOpenManager.removeConnection("Word");
        assertNull(fileOpenManager.checkName("txt"));
    }

    @Test
    void getAllExtensions() {
        fileOpenManager.register("Word", "txt");
        fileOpenManager.register("IDEA", "class");
        List<String> actual = fileOpenManager.getAllExtensions();
        List<String> expected = new ArrayList<>();
        expected.add("class");
        expected.add("txt");
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllAppsWithoutRepeat() {
        fileOpenManager.register("Excel", "xls");
        fileOpenManager.register("Word", "txt");
        fileOpenManager.register("IDEA", "class");
        fileOpenManager.register("Paint", "bmp");
        fileOpenManager.register("Paint", "jpeg");
        Set<String> actual = fileOpenManager.getAllApps();
        Set<String> expected = new HashSet<>();
        expected.add("Excel");
        expected.add("Word");
        expected.add("IDEA");
        expected.add("Paint");
        assertEquals(expected, actual);
    }
}
