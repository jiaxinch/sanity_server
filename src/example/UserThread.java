import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import org.java_websocket.WebSocket;
import org.json.*;

public class UserThread extends Thread {

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ChatServer cs;
	private String username;
	
	public UserThread(WebSocket conn., ChatServer cs) {
		try {
			this.cs = cs;
			oos = new ObjectOutputStream(conn..getOutputStream());
			ois = new ObjectInputStream(conn..getInputStream());
			this.start();
		} catch (IOException ioe) {
			System.out.println("ioe: " + ioe.getMessage());
		}
	}
	
	public void sendMessage(JSONObject message) {
		try {
			oos.writeObject(message);
			oos.flush();
		} catch (IOException ioe) {
			System.out.println("ioe: " + ioe.getMessage());
		}
	}

	public void run() {
		try {
			while(true) {
				JSONObject jso = (JSONObject)ois.readObject();
				String message = jso.getString("function");
				if(message.equals("login")){
					//up = username + password String set.
					//vector's first string would be username, second would be passwordd
					oos.writeObject(UserDAO.login(jso));
					oos.flush();
				}
				if(message.equals("Register")){
					//up = username + password String set.
					//vector's first string would be username, second would be passwordd
					oos.writeObject(UserDAO.Register(jso));
					oos.flush();
				}
				//register with info from clients.
				//1. username
				//2. password
				//3. name
				if(message.equals("AddToQueue")){

				}
				if(message.equals("register")){
					//CreateUsr(up.get(0), up.get(1);
				//	oos.writeObject(User.register(message));
					oos.flush();
				}
				//take string add to group's playlist.
				if(message.equals("LoadMusic")){
					//Vector<String> music = message.getVar();
					//cs.UpdateGroupMusic(music);'
				}
				//create a guest user and login as a guest.
				if(message.equals("Guest")){
					this.username.equals("Guest");
				}
				if(message.equals("requestMusic")){
					//System.out.println(message.getVar().get(0));
				}

				//cs.sendMessageToAllClients(message);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe in run: " + cnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println("ioe in run: " + ioe.getMessage());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}