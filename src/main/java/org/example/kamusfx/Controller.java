package org.example.kamusfx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField searchField;

    @FXML
    private TextArea resultArea;

    @FXML
    private CheckBox indToEngCheckBox;

    @FXML
    private CheckBox engToIndCheckBox;

    private final RedBlackTree tree = new RedBlackTree();
    private boolean isIndoToEng = true; // Default penerjemahan Indonesia → Inggris

    public void initialize() {
        // Inisialisasi Red-Black Tree dengan kata-kata awal
        tree.add("apel", "apple");
        tree.add("pisang", "banana");
        tree.add("acak", "random");
        tree.add("sekolah", "school");
        tree.add("guru", "teacher");
        tree.add("sembarang", "random");

        // Atur status awal checkbox
        indToEngCheckBox.setSelected(true); // Default Indonesia → Inggris
        engToIndCheckBox.setSelected(false);
    }

    @FXML
    public void setIndoToEng() {
        if (indToEngCheckBox.isSelected()) {
            isIndoToEng = true;
            engToIndCheckBox.setSelected(false); // Pastikan hanya satu checkbox yang aktif
            resultArea.setText("Penerjemahan: Indonesia → Inggris");
        } else {
            // Cegah kedua checkbox tidak aktif bersamaan
            indToEngCheckBox.setSelected(true);
        }
    }

    @FXML
    public void setEngToInd() {
        if (engToIndCheckBox.isSelected()) {
            isIndoToEng = false;
            indToEngCheckBox.setSelected(false); // Pastikan hanya satu checkbox yang aktif
            resultArea.setText("Penerjemahan: Inggris → Indonesia");
        } else {
            // Cegah kedua checkbox tidak aktif bersamaan
            engToIndCheckBox.setSelected(true);
        }
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
            // Cari terjemahan berdasarkan arah pilihan
            String result = (isIndoToEng) ? tree.translate(word) : tree.translateReverse(word);
            if (result != null) {
                resultArea.setText("Terjemahan: " + result);
            } else {
                resultArea.setText("Kata tidak ditemukan dalam kamus!");
            }
        }
    }
}
