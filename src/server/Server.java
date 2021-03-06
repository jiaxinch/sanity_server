package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
			if(message.equals("Register")){
				 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
			      UserJDBCTemplate studentJDBCTemplate = 
			         (UserJDBCTemplate)context.getBean("UserJDBCTemplate");
			}
		}catch(JSONException e){
			System.out.println(e.getMessage());
		}
		
	}
	@Override
	public void onError(WebSocket conn, Exception ex) {
		
		
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main( String[] args ) throws InterruptedException , IOException {
		WebSocketImpl.DEBUG = true;
		int port = 9999; // 843 flash policy port
		Server s = new Server( port );
		s.start();
		System.out.println( "ChatServer started on port: " + s.getPort() );

		BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
		while ( true ) {
			String in = sysin.readLine();
			s.broadcast( in );
			if( in.equals( "exit" ) ) {
				s.stop();
				break;
			}
		}
	}
}
