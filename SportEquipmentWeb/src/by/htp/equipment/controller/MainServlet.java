package by.htp.equipment.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.command.CommandAction;
import by.htp.equipment.command.CommandChooser;

public class MainServlet extends HttpServlet {
	 
   	private static final long serialVersionUID = -2657755046972134814L;

	public MainServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do post");
		//UserDao dao = new UserDaoImpl();
		//dao.fetchByCredentials("", "");
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String action = request.getParameter("action");
		String page = null;
		if (action != null) {
			CommandAction currentAction = CommandChooser.chooseAction(action);
			page = currentAction.execute(request, response);
			//response.setCharacterEncoding("cp1251");
		//	response.setContentType("text/html;charset=cp1251");
			
			RequestDispatcher disp =request.getRequestDispatcher(page);
	        disp.forward(request, response);
		}
	}
}

