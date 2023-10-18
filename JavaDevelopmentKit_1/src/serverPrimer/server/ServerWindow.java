package serverPrimer.server;

//import server.client.Client;
//import server.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame implements ServerView{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public Server server;
    JButton btnStart, btnStop;
    JTextArea log;
    public Server getServer() {
        return server;
    }

    public ServerWindow(){
        Repository repository = new Repository();
        server = new Server(repository, this);
        server.clientGUIList();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }
    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.getWork()){
                    appendLog("Сервер уже был запущен");
                } else {
                    server.setWork(true);
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.getWork()){
                    appendLog("Сервер уже был остановлен");
                } else {
                    server.disconnectFromServer();
                    server.setWork(false);
                    //TODO поправить удаление
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    @Override
    public void appendLog(String text) {
        log.append(text + "\n");
    }

}