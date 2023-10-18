package server.client;

import server.classSserver.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private final int WIDTH = 350;
    private final  int HEIGHT = 350;
    private final int LOC_WIDTH = 750;
    private final int LOC_HEIGHT = 400;
    JButton login, send;
    JTextField port, ip, log, message;
    JPasswordField password;
    JPanel panelRegistr1, panelRegistr2, panelGroupRegistr, panelMessage;
    JTextArea hustoryMessage;
    private String textMassage;
    private String name;
    private boolean connectClientGUI;
    public void startClientGUI() {
        this.connectClientGUI = true;
        panelGroupRegistr.setVisible(false);
    }
    public void stopClientGUI() {
        this.connectClientGUI = false;
        panelGroupRegistr.setVisible(true);
    }

    // @Override
    public String getName() {
        return name;
    }

   // @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getTextMassage() {
        return textMassage;
    }

    public void setTextMassage(String textMassage) {
        this.textMassage = textMassage;
    }
    public void setHustoryMessage(String textMassage){
        hustoryMessage.setText(textMassage);
    }
    public ClientGUI(ServerWindow serverWindow){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(LOC_WIDTH, LOC_HEIGHT);
        setTitle("ClientGUI");
        setResizable(false);
        clientGUIconnectPanel();
        getText(send, message, serverWindow, this);
        connectServer(login, serverWindow,this);

        setVisible(true);
    }
    public void getText(JButton sendMessage, JTextField textMessage, ServerWindow serverWindow, ClientGUI clientGUI){
        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connectClientGUI){
                    setName(log.getText()); // Берем имя отправителя
                    setTextMassage(getName() + "\n" + textMessage.getText() + "\n"); // Создаем текст сообщения
                    serverWindow.setTextArea(getTextMassage(), clientGUI); // Отправляем сообщение на сервер
                }
                else clientGUI.setHustoryMessage("Вы не 'авторизированы'");
            }
        });
    }
    public void connectServer(JButton login, ServerWindow serverWindow, ClientGUI client){
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWindow.statusServer()){
                    serverWindow.addListClientGUI(client);
                    client.setHustoryMessage(serverWindow.getText());
                }
                else {
                    client.setHustoryMessage("Сервер отключен");
                }
            }
        });
    }

    public void clientGUIconnectPanel(){
        login = new JButton("login");
        ip = new JTextField("192.10.1");
        port = new JTextField("80.80.80");
        log = new JTextField("Ivan Ivanov");
        password = new JPasswordField("12345");

        send = new JButton("send");
        message = new JTextField();

        panelRegistr1 = new JPanel(new GridLayout(1,3));
        panelRegistr2 = new JPanel(new GridLayout(1,3));
        panelGroupRegistr = new JPanel(new GridLayout(2,1));
        panelRegistr1.add(ip);
        panelRegistr1.add(port);
        panelRegistr2.add(log);
        panelRegistr2.add(password);
        panelRegistr2.add(login);
        panelGroupRegistr.add(panelRegistr1);
        panelGroupRegistr.add(panelRegistr2);

        panelMessage = new JPanel(new GridLayout(1, 2));
        panelMessage.add(message);
        panelMessage.add(send);
        //getText(send, message, serverWindow);

        hustoryMessage = new JTextArea();
        hustoryMessage.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(hustoryMessage);

        add(jScrollPane);
        add(panelGroupRegistr, BorderLayout.NORTH);
        add(panelMessage, BorderLayout.SOUTH);
    }
}
