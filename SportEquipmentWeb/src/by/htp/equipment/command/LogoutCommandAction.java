package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.PAGE_DEFAULT;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommandAction implements CommandAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String page = PAGE_DEFAULT;
		return page;
	}

}
