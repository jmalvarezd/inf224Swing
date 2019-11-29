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
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Client client;
	private AbstractAction actionFind, actionPlay, actionClose;
	public MyFrame(Client client) {
		this.client = client;
		JTextArea textArea = new JTextArea();

        JScrollPane jp = new JScrollPane(textArea);
		this.add(jp);
		
		JPanel southFrame = new JPanel();
		
		JTextField targetField = new JTextField("Target media",10);
		southFrame.add(targetField,BorderLayout.SOUTH);
		
		actionFind = new AbstractAction("Find") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				String targetMedia = targetField.getText();
				String response = client.send("find " + targetMedia);
				textArea.append(response);
			}
		};
		actionPlay = new AbstractAction("Play") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append(this.getValue(NAME).toString()+"! \n");
			}
		};
		actionClose = new AbstractAction("Close") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		
		JButton b1 = new JButton(actionFind);
		southFrame.add(b1);
		
		JButton b2 = new JButton(actionPlay);
		southFrame.add(b2);
		
		JButton b3 = new JButton(actionClose);
		southFrame.add(b3);
		
		this.add(southFrame,BorderLayout.SOUTH);
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menu.add(actionFind);
		menu.add(actionPlay);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		JToolBar toolBar = new JToolBar("Toolbar");
		toolBar.add(actionFind);
		toolBar.add(actionPlay);
		this.add(toolBar, BorderLayout.NORTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(400, 400));
		this.setTitle("Telecommande Swing!");
		this.pack();
		this.setVisible(true);
	}
}
