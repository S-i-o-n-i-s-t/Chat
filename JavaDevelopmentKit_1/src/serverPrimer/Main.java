package serverPrimer;

//import server.client.ClientGUI;
//import server.server.ServerWindow;

import serverPrimer.client.ClientGUI;
import serverPrimer.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}