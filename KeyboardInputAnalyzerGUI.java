import javax.swing.*;
import java.awt.event.*;

public class KeyboardInputAnalyzerGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Keyboard Input Analyzer");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter Text:");
        label.setBounds(20, 20, 100, 25);
        frame.add(label);

        JTextArea inputArea = new JTextArea();
        inputArea.setBounds(20, 50, 390, 80);
        frame.add(inputArea);

        JButton analyzeButton = new JButton("Analyze");
        analyzeButton.setBounds(160, 150, 120, 30);
        frame.add(analyzeButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(20, 200, 390, 200);
        outputArea.setEditable(false);
        frame.add(outputArea);

        analyzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String input = inputArea.getText();

                int characters = input.length();
                int words = input.trim().isEmpty() ? 0 : input.trim().split("\\s+").length;
                int vowels = 0, consonants = 0, digits = 0, spaces = 0, special = 0;

                for (char ch : input.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        if ("aeiouAEIOU".indexOf(ch) != -1)
                            vowels++;
                        else
                            consonants++;
                    } else if (Character.isDigit(ch)) {
                        digits++;
                    } else if (Character.isWhitespace(ch)) {
                        spaces++;
                    } else {
                        special++;
                    }
                }

                outputArea.setText(
                        "Total Characters: " + characters +
                        "\nTotal Words: " + words +
                        "\nVowels: " + vowels +
                        "\nConsonants: " + consonants +
                        "\nDigits: " + digits +
                        "\nSpaces: " + spaces +
                        "\nSpecial Characters: " + special
                );
            }
        });

        frame.setVisible(true);
    }
}

