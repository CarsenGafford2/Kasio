package kasio.view.components.buttons;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import kasio.view.components.Colors;
import kasio.view.components.Fonts;


public class AppendButton extends JButton {

    private final String evalText;

    public AppendButton(String text) {
        this(text, text);
    }

    public AppendButton(String displayText, String evalText) {
        super(displayText);
        this.evalText = evalText;

        setFocusable(false);
        setBackground(Colors.PRIMARY);
        setForeground(Colors.WHITE);
        setBorder(BorderFactory.createLineBorder(Colors.BLACK));
        if (isNumeric(displayText) || ".".equals(displayText)) {
            this.setFont(Fonts.KEYPAD_PRIMARY);
        } else if (displayText.length() == 1) {
            this.setFont(Fonts.KEYPAD_SECONDARY);
        } else {
            this.setFont(Fonts.KEYPAD_SECONDARY);
        }
    }

    private boolean isNumeric(String str) {
        return str.length() == 1 && Character.isDigit(str.charAt(0));
    }

    /**
     * Gets the evaluation-ready string value.
     */
    public String getEvalText() {
        return evalText;
    }
}
