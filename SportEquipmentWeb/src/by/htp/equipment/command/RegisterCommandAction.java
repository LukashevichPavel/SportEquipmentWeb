package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommandAction implements CommandAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String page = PAGE_REGISTER;
		return page;
	}

}
