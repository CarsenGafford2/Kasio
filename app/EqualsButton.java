package app;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class EqualsButton extends JButton {
    EqualsButton() {
        setText("=");
        setFont(Fonts.symbolFont);
        setFocusable(false);
        setBackground(Colors.GREEN);
        setForeground(Colors.WHITE);
        setBorder(BorderFactory.createLineBorder(Colors.BLACK));
        addActionListener(e -> {
            App.textField.setText("8");
        });
    }
}
