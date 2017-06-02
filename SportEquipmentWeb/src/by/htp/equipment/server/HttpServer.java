package by.htp.equipment.server;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.service.EquipmentServiceImpl;



public class HttpServer {

	public static void main(String[] args) throws Throwable {
		ServerSocket ss = new ServerSocket(8023);
		while (true) {
			Socket s = ss.accept();
			System.err.println("Client accepted");
			new Thread(new SocketProcessor(s)).start();
		}
	}

	private static class SocketProcessor implements Runnable {

		private Socket s;
		private InputStream is;
		private OutputStream os;

		private SocketProcessor(Socket s) throws IOException {
			this.s = s;
			this.is = s.getInputStream();
			this.os = s.getOutputStream();
		}

		public void run() {
			try {
				String result = readInputHeaders();
				List<Equipment> equipment = new ArrayList<Equipment>();
				RequestResponse req=new RequestResponse(result);
				EquipmentServiceImpl eq = new EquipmentServiceImpl();
				equipment=eq.getEquipmentBase();
				result+=equipment.toString();
				ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				
				oos.writeObject(equipment);
				//s.write(baos.toByteArray());
				baos.close();
				System.out.println("Запрос : "+ req.getRequest());
				System.out.println("result is "+result);
				//writeResponse("<html><body><h1>Hello from Epam</h1></body></html>");
				writeResponse(result);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} finally {
				try {
					s.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
			System.err.println("Client processing finished");
		}

		private void writeResponse(String s) throws IOException {
			String response = "HTTP/1.1 200 OK\r\n" + "Server: EpamServer/2017-05-25\r\n" + "Content-Type: text/html\r\n" + "Content-Length: " + s.length() + "\r\n" + "Connection: close\r\n\r\n";
			String result = response + s;
			os.write(result.getBytes());
			os.flush();
		}

		private String readInputHeaders() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			while (true) {
				String s = br.readLine();
				if (s == null || s.trim().length() == 0) {
					break;
				}
				sb.append(s).append('\n');
			}
			return sb.toString();
		}
	}
}