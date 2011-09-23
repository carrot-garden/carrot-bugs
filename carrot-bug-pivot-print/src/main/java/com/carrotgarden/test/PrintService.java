package com.carrotgarden.test;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.lang.reflect.InvocationTargetException;

import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;

public class PrintService implements Printable {

	private final Component printComponent;
	private boolean scaleToFit = false;

	public static void printComponent(Component component) {

		printComponent(component, false);

	}

	public static void printComponent(Component component, boolean scaleToFit) {

		new PrintService(component, scaleToFit).print();

	}

	public PrintService(Component component, boolean scaleToFit) {

		this.printComponent = component;

		this.scaleToFit = scaleToFit;

	}

	public void print() {

		PrinterJob printJob = PrinterJob.getPrinterJob();

		printJob.setPrintable(this);

		if (printJob.printDialog()) {
			try {
				printJob.print();
			} catch (PrinterException pe) {
				System.out.println("Error printing: " + pe);
			}
		}

	}

	private static void disableDoubleBuffering(Component c) {

		RepaintManager rm = RepaintManager.currentManager(c);

		rm.setDoubleBufferingEnabled(false);

	}

	private static void enableDoubleBuffering(Component c) {

		RepaintManager rm = RepaintManager.currentManager(c);

		rm.setDoubleBufferingEnabled(true);

	}

	private void paint(Graphics2D g2d, PageFormat pageFormat) {

		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		if (scaleToFit) {

			double scale = pageFormat.getImageableWidth()

			/ printComponent.getWidth();

			g2d.scale(scale, scale);

		}

		printComponent.paint(g2d);

	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {

		if (pageIndex > 0) {

			return (NO_SUCH_PAGE);

		} else {
			try {

				disableDoubleBuffering(printComponent);

				final Graphics2D g2d = (Graphics2D) graphics;
				final PageFormat pf = pageFormat;

				if (!EventQueue.isDispatchThread()) {
					SwingUtilities.invokeAndWait(new Runnable() {
						@Override
						public void run() {
							paint(g2d, pf);
						}
					});
				} else
					paint(g2d, pageFormat);
				return (PAGE_EXISTS);

			} catch (InterruptedException e) {

				e.printStackTrace();

				return NO_SUCH_PAGE;

			} catch (InvocationTargetException e) {

				e.printStackTrace();

				return NO_SUCH_PAGE;

			} finally {

				enableDoubleBuffering(printComponent);

			}

		}

	}

}