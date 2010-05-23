package no.thunaes.petter.svg.app.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import no.thunaes.petter.svg.app.Controller;

public class MainMenu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JMenuItem newChart = new JMenuItem("New chart");
	private JMenuItem renderChart = new JMenuItem("Render chart");
	private JMenuItem exit = new JMenuItem("Exit");

	public MainMenu() {
		JMenu file = new JMenu("File");
		file.add(newChart).addActionListener(this);
		file.add(renderChart).addActionListener(this);
		file.add(exit).addActionListener(this);
		add(file);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(newChart)) {
			Controller.newChart();
		}
		if (e.getSource().equals(renderChart)) {
			Controller.renderChart();
		}
		if (e.getSource().equals(exit)) {
			Controller.exit();
		}
	}
}
