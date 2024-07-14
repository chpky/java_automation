package com.tests.lesson13_fileDownloadTests;

import java.util.List;

public class MenuOption {
    public String id;
    public String value;
    public Popup popup;

    public static class Popup {
        public List<MenuItems> menuItems;

    }
    public static class MenuItems {
        public String value;
        public String onClick;
    }
}
