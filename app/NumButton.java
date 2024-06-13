package app;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class NumButton extends JButton {
    NumButton(String name) {
        setText(name);  
        setFont(Fonts.numFont);
        setFocusable(false);
        setBackground(Colors.PRIMARY);
        setForeground(Colors.WHITE);
        setBorder(BorderFactory.createLineBorder(Colors.BLACK));
        addActionListener(e -> {
            App.textField.setText(App.textField.getText() + name);
        });
    }
}
