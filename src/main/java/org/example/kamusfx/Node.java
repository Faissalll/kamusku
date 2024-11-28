package org.example.kamusfx;

public class Node {
    private String key; // Kata utama
    private String value; // Terjemahan kata
    private Node left, right; // Anak kiri dan kanan
    private boolean isRed; // Warna node (merah/hitam)

    // Konstruktor
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.isRed = true; // Default node baru adalah merah
    }

    // Getter dan setter untuk key (kata utama)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // Getter dan setter untuk value (terjemahan)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Getter dan setter untuk anak kiri
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    // Getter dan setter untuk anak kanan
    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    // Getter dan setter untuk status warna node
    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean isRed) {
        this.isRed = isRed;
    }

    // Representasi string untuk debugging
    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", isRed=" + isRed +
                '}';
    }
}
