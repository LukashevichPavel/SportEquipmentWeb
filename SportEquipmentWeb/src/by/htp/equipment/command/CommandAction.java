package by.htp.equipment.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException;

}