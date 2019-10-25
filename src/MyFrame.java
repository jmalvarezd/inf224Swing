import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MyFrame() {

		System.out.println("hi");
		
		JTextArea textArea = new JTextArea();

        JScrollPane jp = new JScrollPane(textArea);
		this.add(jp);
		
		JPanel southFrame = new JPanel();
		
		AbstractAction action = new AbstractAction("Button 1") {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append(e.getSource().toString());
			}
		};
		
		JButton b1 = new JButton();
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("Button 1! \n");
				
			}
		});
		southFrame.add(b1);
		JButton b2 = new JButton();
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("Button 2! \n");
				
			}
		});
		southFrame.add(b2);
		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		southFrame.add(b3);
		
		this.add(southFrame,BorderLayout.SOUTH);
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menu.add(action);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		JToolBar toolBar = new JToolBar("Toolbar");
		this.add(toolBar, BorderLayout.NORTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(400, 300));
		this.setTitle("JSwing!");
		this.pack();
		this.setVisible(true);
	}
}
