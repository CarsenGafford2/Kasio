package app;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FuncButton extends JButton {
    FuncButton(String name) {
        setUp(name);
        addActionListener(e -> {
            App.textField.setText(
                    String.format("%s(%s)", name, App.textField.getText()));
        });
    }

    FuncButton(String name, String func) {
        setUp(name);
        addActionListener(e -> {
            App.textField.setText(
                    String.format("%s(%s)", func, App.textField.getText()));
        });
    }

    FuncButton(String name, String func, String pos) {
        setUp(name);
        addActionListener(e -> {
            App.textField.setText(
                    String.format("(%s)%s", App.textField.getText(), func));
        });
    }

    void setUp(String name) {
        setText(name);
        setFont(Fonts.alphaFont);
        setFocusable(false);
        setBackground(Colors.PRIMARY);
        setForeground(Colors.WHITE);
        setBorder(BorderFactory.createLineBorder(Colors.BLACK));
    }
}
