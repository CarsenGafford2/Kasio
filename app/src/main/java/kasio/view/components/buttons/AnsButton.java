package kasio.view.components.buttons;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import kasio.view.components.Colors;
import kasio.view.components.Fonts;


public class AnsButton extends JButton {
    public AnsButton() {
        super("Ans");
        setFocusable(false);
        setBackground(Colors.PRIMARY);
        setForeground(Colors.WHITE);
        setBorder(BorderFactory.createLineBorder(Colors.BLACK));
        this.setFont(Fonts.KEYPAD_PRIMARY);
    }
}
