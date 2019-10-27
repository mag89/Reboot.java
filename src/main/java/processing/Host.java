package processing;

import com.sun.org.apache.regexp.internal.RE;
import streams.Request;
import streams.Response;

public class Host {
    private Client client;

    public Response getBalance(Request request){
        Response result = null;
        if (request.getClientId() == client.getClientId() & request.getPIN() == client.getPIN() &
                request.getAccountId() == client.getAccount().getAccountId()){
            result = new Response(false, client.getAccount().getBalance());
        }
        else if (request.getClientId() != client.getClientId()){
            result = new Response(true, "clientId not found!");
        }
        else if (request.getPIN() != client.getPIN()){
            result = new Response(true, "authorized fail!");
            }
        else if (request.getAccountId() != client.getAccount().getAccountId()){
            result = new Response(true, "accountId not found");
        }

        return result;
    }
}
