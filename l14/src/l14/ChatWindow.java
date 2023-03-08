package l14;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatWindow extends JFrame {
    private JTextField textField;
    private JTextArea chatArea;
    private JComboBox<String> userList;
    private JButton sendButton;

    public ChatWindow() {
        // Set up the window
        setTitle("Chat Window");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Set up the chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBounds(0, 0, 386, 532);
        getContentPane().add(scrollPane);

        // Set up the user list
        userList = new JComboBox<>();
        userList.setBounds(10, 5, 77, 21);
        userList.addItem("User 1");
        userList.addItem("User 2");
        userList.addItem("User 3");
        userList.addItem("User 4");

        // Set up the text field and send button
        textField = new JTextField();
        textField.setBounds(97, 6, 203, 19);
        sendButton = new JButton("Send");
        sendButton.setBounds(310, 5, 66, 21);
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = textField.getText();
                String recipient = (String)userList.getSelectedItem();
                chatArea.append("To " + recipient + ": " + message + "\n");
                textField.setText("");
            }
        });
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendButton.doClick();
            }
        });

        // Add the text field and send button to the window
        JPanel panel = new JPanel();
        panel.setBounds(0, 532, 386, 31);
        panel.setLayout(null);
        panel.add(userList);
        panel.add(textField);
        panel.add(sendButton);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        ChatWindow window = new ChatWindow();
        window.setVisible(true);
    }
}


