package com.cascon77.conecta4.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ButtonModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MyButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6058871936569427235L;
	private static final int PADDING = 4; // padding interior alrededor del círculo

	public MyButton() {
		super();
		setContentAreaFilled(false); // no dejar que Swing pinte el fondo rectangular
		setFocusPainted(false);
		setBorderPainted(false);
		setOpaque(false);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		try {
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int w = getWidth();
			int h = getHeight();
			int diameter = Math.min(w, h) - PADDING * 2;
			if (diameter <= 0) {
				return;
			}
			int x = (w - diameter) / 2;
			int y = (h - diameter) / 2;
			Ellipse2D circle = new Ellipse2D.Float(x, y, diameter, diameter);

			ButtonModel model = getModel();
			Color base = getBackground();
			if (base == null)
				base = UIManager.getColor("Button.background");
			Color fill = base;
			if (!isEnabled()) {
				fill = toGrayscale(fill);
			} else if (model.isPressed()) {
				fill = fill.darker();
			} else if (model.isRollover()) {
				fill = fill.brighter();
			}

			// relleno del círculo
			g2.setColor(fill);
			g2.fill(circle);

			// borde
			Color borderColor = getForeground();
			if (borderColor == null)
				borderColor = UIManager.getColor("Button.foreground");
			g2.setColor(borderColor);
			g2.setStroke(new BasicStroke(1.5f));
			g2.draw(circle);

			// icono centrado (si existe) se pinta encima del círculo
			Icon icon = getIcon();
			if (icon != null) {
				int ix = x + (diameter - icon.getIconWidth()) / 2;
				int iy = y + (diameter - icon.getIconHeight()) / 2;
				icon.paintIcon(this, g2, ix, iy);
			}

			// texto centrado
			String text = getText();
			if (text != null && !text.isEmpty()) {
				FontMetrics fm = g2.getFontMetrics(getFont());
				int tx = x + (diameter - fm.stringWidth(text)) / 2;
				int ty = y + (diameter - fm.getHeight()) / 2 + fm.getAscent();
				g2.setColor(getForeground() == null ? UIManager.getColor("Button.foreground") : getForeground());
				g2.setFont(getFont());
				g2.drawString(text, tx, ty);
			}

		} finally {
			g2.dispose();
		}
	}

	@Override
	public boolean contains(int px, int py) {
		int w = getWidth();
		int h = getHeight();
		int diameter = Math.max(0, Math.min(w, h) - PADDING * 2);
		int cx = w / 2;
		int cy = h / 2;
		double radius = diameter / 2.0;
		double dx = px - cx;
		double dy = py - cy;
		return dx * dx + dy * dy <= radius * radius;
	}

	private Color toGrayscale(Color c) {
		int g = (int) (0.3 * c.getRed() + 0.59 * c.getGreen() + 0.11 * c.getBlue());
		return new Color(g, g, g, c.getAlpha());
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d = super.getPreferredSize();
		int s = Math.max(d.width, d.height);
		// Añadimos padding para asegurar que el círculo no toque los límites
		s = Math.max(s, 24); // tamaño mínimo razonable

		return new Dimension(s + PADDING * 2, s + PADDING * 2);
	}

}