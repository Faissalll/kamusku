package org.example.kamusfx;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    private Node root;

    // Menambahkan kata beserta terjemahan
    public void add(String word, String translation) {
        // Tambahkan pasangan dalam dua arah (word -> translation, translation -> word)
        root = addRecursive(root, word, translation);
        root = addRecursive(root, translation, word);
        root.setRed(false); // Root harus selalu hitam
    }

    private Node addRecursive(Node current, String word, String translation) {
        if (current == null) {
            return new Node(word, translation);
        }
        if (word.compareTo(current.getKey()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), word, translation));
        } else if (word.compareTo(current.getKey()) > 0) {
            current.setRight(addRecursive(current.getRight(), word, translation));
        }
        // Logika keseimbangan red-black tree diabaikan untuk kesederhanaan
        return current;
    }

    // Penerjemahan berdasarkan pilihan bahasa
    public String translate(String word) {
        Node current = root;
        while (current != null) {
            if (word.equals(current.getKey())) {
                return current.getValue();
            }
            current = word.compareTo(current.getKey()) < 0 ? current.getLeft() : current.getRight();
        }
        return null;
    }

    // Penerjemahan balik: Inggris → Indonesia
    public String translateReverse(String word) {
        Node current = root;
        while (current != null) {
            if (word.equals(current.getValue())) {
                return current.getKey();
            }
            current = word.compareTo(current.getValue()) < 0 ? current.getLeft() : current.getRight();
        }
        return null;
    }

    // Mendapatkan kata acak dari tree
    public String getRandomWord() {
        List<Node> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);
        if (!nodes.isEmpty()) {
            int randomIndex = (int) (Math.random() * nodes.size());
            Node randomNode = nodes.get(randomIndex);
            return randomNode.getKey() + " - " + randomNode.getValue();
        }
        return "No words available.";
    }

    // Traversal in-order untuk mendapatkan daftar node
    private void inOrderTraversal(Node current, List<Node> nodes) {
        if (current != null) {
            inOrderTraversal(current.getLeft(), nodes);
            nodes.add(current);
            inOrderTraversal(current.getRight(), nodes);
        }
    }
}
