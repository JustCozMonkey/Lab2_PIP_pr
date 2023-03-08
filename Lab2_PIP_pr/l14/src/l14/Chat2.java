package l14;



import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Chat2 {

	private JFrame frame;
	private JTextField textField;
	private JButton btnAddMember;
	private JList<String> memberList;
	private List<String> members;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat2 window = new Chat2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chat2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		members = new ArrayList<>();
		setTitle("Chat");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea chatArea = new JTextArea();
		chatArea.setBounds(0, 0, 233, 442);
		chatArea.setEditable(false);
		frame.getContentPane().add(chatArea);
		
		textField = new JTextField();
		textField.setBounds(0, 444, 431, 21);
		frame.getContentPane().add(textField);
		
		JButton removeButton = new JButton("Remove Member");
		removeButton.setBounds(236, 421, 190, 21);
		frame.getContentPane().add(removeButton);
		
		btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String member = JOptionPane.showInputDialog(Chat.this, "Enter member name:");
				if (member != null && !member.isEmpty()) {
					members.add(member);
					memberList.setListData(members.toArray(new String[0]));
				}
				
			}
		});
		btnAddMember.setBounds(236, 399, 190, 21);
		frame.getContentPane().add(btnAddMember);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(236, 0, 190, 399);
		frame.getContentPane().add(scrollPane);
		
		memberList = new JList<String>();
		scrollPane.setViewportView(memberList);
		
		
		
	}
}
