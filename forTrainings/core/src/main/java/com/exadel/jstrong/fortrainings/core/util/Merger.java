package com.exadel.jstrong.fortrainings.core.util;

import java.util.ArrayList;
import java.util.List;

public class Merger {

    static class Struct {
        String string;
        int count;
    }

    public static final String EMPTY_STRING = "";

    public static String merge(String source, String update) {
        Struct direct = mainMerge(source, update);
        Struct inverse = mainMerge(update, source);

        if (direct.count <= inverse.count) {
            return direct.string;
        }   else {
            inverse.string = inverse.string.replaceAll("!\\{rm:", "!{rmnew:");
            inverse.string = inverse.string.replaceAll("!\\{add:", "!{rm:");
            inverse.string = inverse.string.replaceAll("!\\{rmnew:", "!{add:");
            return inverse.string;
        }
    }

    public static Struct mainMerge(String source, String update) {
        List<WordDescriptor> sourceWords = splitWords(source);
        List<WordDescriptor> updateWords = splitWords(update);

        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < sourceWords.size(); i++) {
            WordDescriptor word = sourceWords.remove(i--);
            int index = getIndex(updateWords, word);
            if (index != -1) {
                for (int j = 0; j < index; j++) {
                    appendAddedWord(builder, updateWords.remove(0));
                    count++;
                }
                updateWords.remove(0);
                builder.append("!{").append(word.getWord()).append("} ");
            } else {
                appendRemovedWord(builder, word);
                count++;
            }
        }
        for (int j = 0; j < updateWords.size(); j++ ) {
            appendAddedWord(builder, updateWords.get(j));
            count++;
        }
        Struct struct = new Struct();
        struct.string = builder.toString();
        struct.count = count;
        return struct;
    }

    private static void appendAddedWord(StringBuilder builder, WordDescriptor insertedWord) {
        builder.append(String.format("!{add: %s} ", insertedWord.getWord()));
    }

    private static void appendRemovedWord(StringBuilder builder, WordDescriptor insertedWord) {
        builder.append(String.format("!{rm: %s} ", insertedWord.getWord()));
    }

    private static int getIndex(List<WordDescriptor> updateWords, WordDescriptor word) {
        for (int j = 0; j < updateWords.size(); j++) {
            if (updateWords.get(j).getWord().equals(word.getWord())) {
                return j;
            }
        }
        return -1;
    }

    private static List<WordDescriptor> splitWords(String source) {
        List<WordDescriptor> descriptors = new ArrayList<>();
        int position = 0;
        String[] words = source.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                descriptors.add(new WordDescriptor(words[i], position));
                position++;
            }
        }
        return descriptors;
    }
}