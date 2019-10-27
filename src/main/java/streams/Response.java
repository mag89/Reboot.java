package streams;

public class Response {
    private boolean isError;
    private String balance;

    public Response(boolean isError, int balance) {
        this.isError = isError;
        this.balance = "" + balance;
    }

    public Response(boolean isError, String balance) {
        this.isError = isError;
        this.balance = balance;
    }

    public boolean isError() {
        return isError;
    }

    public int getBalance() {
        return Integer.parseInt(balance);
    }
}
