package serverPrimer.server;

import serverPrimer.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server implements RepositoryvView{
    Repository repository;
    ServerWindow serverWindow;
    List<Client> clientGUIList;
    boolean work;

    public void setWork(boolean work) {
        this.work = work;
    }

    public boolean getWork() {
        return work;
    }

    public List<Client>  clientGUIList() {
        return this.clientGUIList = new ArrayList<>();
    }
    public List<Client>  getClientGUIList() {
        return this.clientGUIList;
    }

    private void answerAll(String text){
        for (Client clientGUI: clientGUIList){
            clientGUI.serverAnswer(text);
        }
    }
    public Server(Repository repository, ServerWindow serverWindow){
        this.repository = repository;
        this.serverWindow = serverWindow;
        //this.client = client;
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientGUIList.add(client);
        return true;
    }
    public void disconnectFromServer(){
        for (Client clientGUI: clientGUIList){
            clientGUI.disconnect();
        }
    }

    public void disconnectUser(Client clientGUI){
        clientGUIList.remove(clientGUI);
        if (clientGUI != null){
            clientGUI.disconnect();
        }
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
        serverWindow.appendLog(text);
        answerAll(text);
        InLog(text);

    }
    public String getHistory() {
        return Log();
    }

    @Override
    public void InLog(String text) {
        repository.saveInLog(text);
    }
    @Override
    public String Log() {
        return repository.readLog();
    }
}
