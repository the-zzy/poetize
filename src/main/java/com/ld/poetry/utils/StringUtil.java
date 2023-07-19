package com.ld.poetry.utils;

public class StringUtil {

    public static void main(String[] args) {
        System.out.println(removeHtml(""));
    }

    private static final String REGEX_SCRIPT = "<script[^>]*?>[\\s\\S]*?<\\/script>";

    private static final String REGEX_STYLE = "<style[^>]*?>[\\s\\S]*?<\\/style>";

    public static String removeHtml(String content) {
        return content.replace("</", "《/")
                .replace("/>", "/》")
                .replace("<script", "《style")
                .replace("<style", "《style")
                .replace("<img", "《img")
                .replace("<br", "《br")
                .replace("<input", "《input");
    }
}
