package l14;
import java.awt.*;       //La inceputul codului se importa diferite biblioteci necesare pentru crearea si utilizarea interfetei grafice (AWT, Swing, util)
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Chat extends JFrame { //Clasa Chat extinde JFrame si implementeaza un design Singleton, astfel ca este creata o singura data o instanta a acestei clase.

	private static Chat instance;
	private List<String> members;
	private JTextArea chatArea;
	private JTextField messageField;
	private JButton sendButton;
	private JButton addButton;
	private JButton removeButton;
	private JList<String> memberList;
	private JScrollPane scrollPane;
	private static String log = "Chat Logs:\n\n";  //Variabila log este utilizata pentru a retine istoricul conversatiei.

	private Chat() {

		members = new ArrayList<>();
		setTitle("Chat");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		chatArea = new JTextArea();                    //In constructorul clasei se initializeaza elementele interfetei grafice precum:
		chatArea.setBounds(0, 0, 228, 442);            //chatArea, messageField, sendButton, addButton, removeButton, memberList, scrollPane.
		chatArea.setEditable(false);
		getContentPane().add(chatArea);

		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(0, 442, 486, 21);
		inputPanel.setLayout(new BorderLayout());

		messageField = new JTextField();
		sendButton = new JButton("Send");               // sendButton - trimiterea mesajului
		inputPanel.add(messageField, BorderLayout.CENTER);
		inputPanel.add(sendButton, BorderLayout.EAST);
		getContentPane().add(inputPanel);

		JPanel memberPanel = new JPanel();
		memberPanel.setBounds(228, 0, 258, 442);
		memberPanel.setLayout(new BorderLayout());
		memberList = new JList<>();
		scrollPane = new JScrollPane(memberList);

		addButton = new JButton("Add Member");    //addButton - adaugarea unui membru
		removeButton = new JButton("Remove Member");

		memberPanel.add(scrollPane, BorderLayout.CENTER);
		memberPanel.add(addButton, BorderLayout.NORTH);
		memberPanel.add(removeButton, BorderLayout.SOUTH);

		getContentPane().add(memberPanel);

		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = messageField.getText();
				String member = memberList.getSelectedValue();
				if(member!=null) {
					chatArea.setText(Chat.getInstance().addMes(member, message));       // Se apeleaza instanta , si se adauga mesajul
					messageField.setText("");
				}
			}
		});
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String member = JOptionPane.showInputDialog(Chat.this, "Enter member name:");
				if (member != null && !member.isEmpty()) {
					members.add(member);
					memberList.setListData(members.toArray(new String[0]));
				}
			}
		});
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String member = memberList.getSelectedValue();
				if (member != null) {
					members.remove(member);
					memberList.setListData(members.toArray(new String[0]));
				}
			}
		});
	}
	public static Chat getInstance() {                          //Metoda getInstance() returneaza instanta clasei Chat, daca aceasta nu exista, o va crea.
		if (instance == null) {
			instance = new Chat();
		}
		return instance;
	}
	static String addMes(String mem,String mess) {                   //Metoda addMes() adauga mesajul si membru care l-a trimis in log.
		Chat.log=Chat.log+mem+":"+mess+"\n";
		System.out.println(log);
		System.out.println("TEST");
		return Chat.log;
	}

	public static void main(String[] args) {
		Chat chat = Chat.getInstance();
		System.out.println(chat.log);
		chat.setVisible(true);
	}
}