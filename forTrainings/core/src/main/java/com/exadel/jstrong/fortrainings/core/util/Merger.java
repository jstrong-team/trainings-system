package com.exadel.jstrong.fortrainings.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergey Nalivko.
 */
public class Merger {
    public static final String EMPTY_STRING = "";

    public static String merge(String source, String update) {
        List<WordDescriptor> sourceWords = splitWords(source);
        List<WordDescriptor> updateWords = splitWords(update);

        List<WordDescriptor> sourceMatchWords = new ArrayList<>(sourceWords.size());
        List<WordDescriptor> updateMatchWords = new ArrayList<>(updateWords.size());

        for (int i = 0; i < sourceWords.size(); i++) {
            WordDescriptor word = sourceWords.get(i);
            int index = getIndex(updateWords, word);
            if (index != -1) {
                sourceMatchWords.add(sourceWords.remove(i--));
                updateMatchWords.add(updateWords.remove(index));
            }
        }

        List<WordDescriptor> deletedWords = sourceWords;
        List<WordDescriptor> addedWords = updateWords;

        int inserted = 0;
        int deleted = 0;
        int replaced = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sourceMatchWords.size(); i++) {
            WordDescriptor sourceWordDesc = sourceMatchWords.get(i);
            WordDescriptor updateWordDesc = updateMatchWords.get(i);
            int code = sourceWordDesc.getPosition() - updateWordDesc.getPosition() + inserted - deleted;
            if (code == 0) {
                //check replaced
                int diffCode = sourceWordDesc.getPosition() - updateWordDesc.getPosition();
                int val = i + replaced + deleted;
                WordDescriptor assumeReplaced = getByPosition(deletedWords, val);
                WordDescriptor assumeReplacer = getByPosition(addedWords, val - diffCode);
                if (assumeReplaced != null && assumeReplacer != null) {
                    deletedWords.remove(assumeReplaced);
                    addedWords.remove(assumeReplacer);
                    builder.append(String.format("!{rlc: %s -> %s} ", assumeReplaced.getWord(), assumeReplacer.getWord()));
                    replaced++;
                    i--;
                    continue;
                }

                builder.append(sourceWordDesc.getWord()).append(' ');
                continue;
            }
            if (code < 0) {     //means inserted
                int insertedIndex = updateWordDesc.getPosition() + code;
                WordDescriptor insertedWord = getByPosition(addedWords, insertedIndex);
                appendAddedWord(builder, insertedWord);
                addedWords.remove(insertedWord);
                inserted++;
                i--;
                continue;
            }
            if (code > 0) {     //means deleted
                int deletedIndex = sourceWordDesc.getPosition() - code;
                WordDescriptor deletedWord = getByPosition(deletedWords, deletedIndex);
                appendRemovedWord(builder, deletedWord);
                deletedWords.remove(deletedWord);
                i--;
                deleted++;
            }
        }

        for (WordDescriptor insertedWord : addedWords) {
            appendAddedWord(builder, insertedWord);
        }
        for (WordDescriptor insertedWord : deletedWords) {
            appendRemovedWord(builder, insertedWord);
        }
        return builder.toString();
    }

    private static void appendAddedWord(StringBuilder builder, WordDescriptor insertedWord) {
        builder.append(String.format("!{add: %s} ", insertedWord.getWord()));
    }

    private static void appendRemovedWord(StringBuilder builder, WordDescriptor insertedWord) {
        builder.append(String.format("!{rm: %s} ", insertedWord.getWord()));
    }

    private static WordDescriptor getByPosition(List<WordDescriptor> addedWords, int insertedIndex) {
        for (WordDescriptor addedWord : addedWords) {
            if (addedWord.getPosition() == insertedIndex) {
                return addedWord;
            }
        }
        return null;
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
        List<String> words = Arrays.asList(source.split(" "));
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.isEmpty()) {
                words.remove(i--);
            }
        }
        List<WordDescriptor> descriptors = new ArrayList<>(words.size());
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            descriptors.add(new WordDescriptor(word, i));
        }
        return descriptors;
    }
}
