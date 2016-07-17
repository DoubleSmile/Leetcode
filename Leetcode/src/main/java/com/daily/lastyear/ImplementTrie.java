package com.daily.lastyear;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Implement a trie with insert, search, and startsWith methods.
 */
public class ImplementTrie {
    class TrieNode {
        // Initialize your data structure here.
        public int num;
        public TrieNode[] son;
        public char value;
        public boolean isEnd;

        public TrieNode() {
            num = 1;
            son = new TrieNode[26];
            isEnd = false;
        }
    }

    public class Trie {

        private TrieNode root;


        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null || word.trim() == "") {
                return;
            }

            char[] str = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < str.length; i++) {
                int pos = str[i] - 'a';
                if (node.son[pos] == null) {
                    node.son[pos] = new TrieNode();
                    node.son[pos].value = str[i];
                } else {
                    node.son[pos].num++;
                }
                node = node.son[pos];
            }
            node.isEnd = true;

        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word == null || word.trim() == "") {
                return false;
            }
            char[] str = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < str.length; i++) {
                int position = str[i] - 'a';
                if (node.son[position] == null) {
                    return false;
                }
                node = node.son[position];
            }
            return node.isEnd;

        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.trim() == "") {
                return false;
            }
            char[] str = prefix.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < str.length; i++) {
                int position = str[i] - 'a';
                if (node.son[position] == null) {
                    return false;
                }
                node = node.son[position];
            }
            return true;
        }

    }
}
