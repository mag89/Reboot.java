package processing;

public class Client {
    private int clientId;
    private int PIN;
    private Account account;

    public Client(int clientId, int PIN, Account account) {
        this.clientId = clientId;
        this.PIN = PIN;
        this.account = account;
    }

    public int getClientId() {
        return clientId;
    }

    public int getPIN() {
        return PIN;
    }

    public Account getAccount() {
        return account;
    }
}
