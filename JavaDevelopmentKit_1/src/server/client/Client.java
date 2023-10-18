package server.client;

import server.classSserver.ServerWindow;

public class Client {
    private String name;
    private boolean connectClientGUI;
    private ClientView client;
    private ServerWindow server;
    public Client(ClientView client, ServerWindow serverWindow) {
        this.client = client;
        this.server = serverWindow;
    }
    public String setTextMassage(String textMassage) {
        return name + ":" + "\n" + textMassage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean connectToServer(String name){
        return connectClientGUI;
    }
    public void disconnect(){
//        if (connected) {
//            connected = false;
//            clientView.disconnectFromServer();
//            server.disconnectUser(this);
//            printText("Вы были отключены от сервера!");
//        }
//    private void printText(String text){
//        client.showMessage(text);
    }

}
