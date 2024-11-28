package org.example.kamusfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private TextArea resultArea;

    private final RedBlackTree tree = new RedBlackTree();

    public void initialize() {
        // Inisialisasi Red-Black Tree dengan kata-kata awal
        tree.add("apel", "apple");
        tree.add("pisang", "banana");
        tree.add("acak", "random");
        tree.add("sekolah", "school");
        tree.add("guru", "teacher");
        tree.add("sembarang", "random");
    }

    @FXML
    public void searchWord() {
        String word = searchField.getText().trim();

        if (word.isEmpty()) {
            resultArea.setText("Harap masukkan kata yang ingin diterjemahkan.");
            return;
        }

        // Jika pengguna mencari kata acak
        if (word.equalsIgnoreCase("random") ||
                word.equalsIgnoreCase("acak") ||
                word.equalsIgnoreCase("sembarang")) {
            String randomWord = tree.getRandomWord();
            resultArea.setText("Word of the Day: \n" + randomWord);
        } else {
            // Cari terjemahan kata
            String result = tree.translate(word);
            if (result != null) {
                resultArea.setText("Terjemahan: " + result);
            } else {
                resultArea.setText("Kata tidak ditemukan dalam kamus!");
            }
        }
    }
}
