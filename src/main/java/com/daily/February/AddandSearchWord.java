package com.daily.February;

import java.util.HashMap;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Design a data structure that supports the following two operations:
 * <p/>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p/>
 * For example:
 * <p/>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */
public class AddandSearchWord {
    class TrieNode {
        String value;
        HashMap<Character, TrieNode> children = null;
        Boolean flag;

        public TrieNode() {
            value = null;
            children = new HashMap();
            flag = Boolean.FALSE;
        }

        public TrieNode(String value) {
            this.value = value;
            children = new HashMap();
            flag = Boolean.FALSE;
        }

        public void add(Character c) {
            String val = "";
            if (this.value == null) { //root node
                val = String.valueOf(c);
            } else {
                val = this.value + String.valueOf(c);
            }
            this.children.put(c, new TrieNode(val));
        }

    }

    class Trie {
        TrieNode root = null;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.add(c);
                }
                node = node.children.get(c);
            }
            node.flag = true;
        }

        public TrieNode getRoot() {
            return root;
        }

    }


    public class WordDictionary {

        Trie trie = new Trie();

        // Adds a word into the data structure.
        public void addWord(String word) {
            trie.addWord(word);
        }

        public boolean searchPattern(TrieNode node, String pattern, int counter) {
            if (node == null) return false;
            if (counter == pattern.length()) return node.flag;

            Character c = pattern.charAt(counter);
            if (c == '.') {
                for (Character ch : node.children.keySet()) {
                    if (searchPattern(node.children.get(ch), pattern, counter + 1)) return true;
                }
            } else if (c != '.' && node.children.containsKey(c)) {
                return searchPattern(node.children.get(c), pattern, counter + 1);
            }

            return false;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return searchPattern(trie.getRoot(), word, 0);
        }
    }
}
