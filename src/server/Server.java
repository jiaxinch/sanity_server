import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONException;
import org.json.JSONObject;

public class Server extends WebSocketServer{
	public Server(int port) throws UnknownHostException{
		super(new InetSocketAddress(port));
	}
	public Server(InetSocketAddress address){
		super(address);
	}
	
	
	public void onOpen(WebSocket conn, ClientHandshake handshake){
		broadcast("new connection: "+ handshake.getResourceDescriptor());
	}
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onMessage(WebSocket conn, String msgReceive) {
		JSONObject JSONMessage;
		try{
			JSONMessage = new JSONObject(msgReceive);
			String message = JSONMessage.getString("function");
			if(message.equals("login")){
				
			}
		}catch(JSONException e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void onError(WebSocket conn, Exception ex) {
		
		
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}
}
