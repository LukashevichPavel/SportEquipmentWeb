package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.PAGE_REGISTER;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowRegisterPage implements CommandAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String page = PAGE_REGISTER;
		return page;
	}

}
