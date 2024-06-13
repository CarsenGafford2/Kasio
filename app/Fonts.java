package app;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Fonts {
    static Font numFont = new Font("Arial", Font.BOLD, 24);
    static Font alphaFont = new Font("Arial", Font.BOLD, 20);
    static Font symbolFont = new Font("Ink Free", Font.BOLD, 24);
    static Font displayFont;
    static {
        try {
            displayFont = Font.createFont(Font.TRUETYPE_FONT, new File("/home/hethon/Documents/SSC/Year 2/2nd Semester/OOP/course project/The Calc/assets/fonts/casio-calculator-font.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(displayFont);
        } catch (IOException | FontFormatException e) {
            displayFont = numFont;
            e.printStackTrace();
        }
    }
}
