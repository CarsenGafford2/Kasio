package kasio.view.components.buttons;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import kasio.view.components.Colors;


public final class WrapButton extends JButton {

    private final String wrapPrefix;

    public WrapButton(String text, String wrapPrefix, Font font) {
        super(text);
        this.wrapPrefix = wrapPrefix;
        setUp(font);
    }

    public WrapButton(String name, Font font) {
        super(name);
        this.wrapPrefix = "";
        setUp(font);
    }

    void setUp(Font font) {
        setFont(font);
        setFocusable(false);
        setBackground(Colors.PRIMARY);
        setForeground(Colors.WHITE);
        setBorder(BorderFactory.createLineBorder(Colors.BLACK));
    }

    public String getWrapPrefix() {
        return this.wrapPrefix;
    }
}
