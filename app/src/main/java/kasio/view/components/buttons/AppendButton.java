package kasio.view.components.buttons;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import kasio.view.components.Colors;


public class AppendButton extends JButton {

    private final String evalText;

    public AppendButton(String text, Font font) {
        this(text, text, font);
    }

    public AppendButton(String displayText, String evalText, Font font) {
        super(displayText);
        this.evalText = evalText;

        setFocusable(false);
        setBackground(Colors.PRIMARY);
        setForeground(Colors.WHITE);
        setBorder(BorderFactory.createLineBorder(Colors.BLACK));
        this.setFont(font);
    }

    /**
     * Gets the evaluation-ready string value.
     */
    public String getEvalText() {
        return evalText;
    }
}
