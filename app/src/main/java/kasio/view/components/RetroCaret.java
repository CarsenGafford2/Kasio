package kasio.view.components;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

public class RetroCaret extends DefaultCaret {

  public RetroCaret() {
    setBlinkRate(500);
  }

  @Override
  protected synchronized void damage(Rectangle r) {
    if (r == null) return;
    JTextComponent comp = getComponent();
    x = r.x;
    y = r.y;

    width = comp.getFontMetrics(comp.getFont()).charWidth('W');
    height = r.height;
    comp.repaint(x, y, width, height);
  }

  @Override
  public void paint(Graphics g) {
    JTextComponent comp = getComponent();
    if (comp == null) return;

    int dot = getDot();
    Rectangle r;
    try {
      r = comp.modelToView2D(dot).getBounds();
    } catch (BadLocationException e) {
      return;
    }
    if (r == null) return;

    if (isVisible()) {
      g.setColor(comp.getCaretColor());
      int charWidth = comp.getFontMetrics(comp.getFont()).charWidth('W');
      g.fillRect(r.x, r.y, charWidth, r.height);
    }
  }

  @Override
  public void focusLost(FocusEvent e) {
    // do nothing
  }
}
