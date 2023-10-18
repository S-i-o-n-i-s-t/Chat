package server.classSserver;

import server.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    private final int WIDTH = 450;
    private final int HEIGHT = 450;
    private boolean switchServer;
    private StringBuilder chat = new StringBuilder();
    private String husroryMassage;
    private String EDFRWE = "Сервер Прекратил работу";
    private List<ClientGUI> clientGUIList;
    private File file = new File("temp.txt");
    JPanel jPanelButton;
    JButton start, stop;
    JTextArea text;
    public void setChat(String massage){
        this.chat.append(massage);
    }
    public String getHusroryMassage(){
        return this.husroryMassage;
    }
    public void setHusroryMassage(StringBuilder text){
        husroryMassage = new String(text);
    }
    public boolean getSwitchServer(){
        return switchServer;
    }
    public boolean statusServer(){
        return switchServer;
    }
    public String getText(){
        return text.getText();
    }
    /**
     * Метод запуска сервера
     */
    public void startServer(){
        chat = new StringBuilder();
        getTextFile();
        switchServer = true;
    }
    /**
     * Метод остановки сервера
     */
    public void stopServer(){
        switchServer = false;
        setTextFile(getHusroryMassage());
        for (int item = 0; item < clientGUIList.size(); item++){
            clientGUIList.get(item).stopClientGUI();
            clientGUIList.get(item).setHustoryMessage("Сервер Прекратил работу");
        }
        text.setText("Сервер Прекратил работу");
    }
    /**
     * Метод для добавления в массив новых клиентов
     * @param clientGUI
     */
    public void addListClientGUI(ClientGUI clientGUI){
        clientGUI.startClientGUI();
        clientGUIList.add(clientGUI);
    }
    /**
     * Метод объединяющий добавления "истории сообщений" в окно сервера и подключающихся пользователей
     * @param textMassage "Входящее сообщение"
     * @param clientGUI "Отправитель"
     */
    public void setTextArea(String textMassage, ClientGUI clientGUI){
        setChat(textMassage); // Добавляем сообщение к нашей истории сообщений
        setHusroryMassage(chat); // Создаем строковую переменную "история сообщений"
        text.setText(getHusroryMassage()); // Добавляем историю сообщений на "панель"textMassage
        sendingMassage(getHusroryMassage(), clientGUI); // Передаем историю сообщений всем подключенным пользователям
    }

    /**
     * Метод для отправки сообщений пользователям
     * @param massage входящее сообщение
     * @param clientGUI пользователь
     */
    public void sendingMassage(String massage, ClientGUI clientGUI){
        if (!getSwitchServer()){
            clientGUI.setHustoryMessage("Сервер отключен"); // Сообщаем пользователю, что сервер отключен
        }
        else {
            for (int item = 0; item < clientGUIList.size(); item++){
                clientGUIList.get(item).setHustoryMessage(massage); // Отправляем пользователям историю сообщений
            }
        }
    }

    /**
     * Чтение данных из файла
     */
    public void getTextFile(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()){
                setChat(bufferedReader.readLine() + "\n");
                setHusroryMassage(chat);
                text.setText(getHusroryMassage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Метод добавления текста в файл
     * @param text
     */
    public void setTextFile(String text){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void buttonStart(JButton startButton){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });
    }
    public void buttonStop(JButton stopButton){
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
    }
    public void ServerWindowPanel(){
        text = new JTextArea(24,20);

        text.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(text);
        start = new JButton("Start");
        stop = new JButton("Stop");
        buttonStart(start);
        buttonStop(stop);
        jPanelButton = new JPanel(new GridLayout(1,2));
        jPanelButton.add(start);
        jPanelButton.add(stop);

        add(jPanelButton, BorderLayout.SOUTH);
        add(jScrollPane, BorderLayout.NORTH);
    }
    public ServerWindow(){
        clientGUIList = new ArrayList<>();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Server Window");
        setResizable(true);
        setLocationRelativeTo(null);
        ServerWindowPanel();
        setVisible(true);
    }
}
