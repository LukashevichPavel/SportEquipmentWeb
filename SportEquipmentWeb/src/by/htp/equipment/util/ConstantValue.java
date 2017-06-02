package by.htp.equipment.util;

import by.htp.equipment.entity.Order;

public final class ConstantValue {

	private ConstantValue() {
	}

	public static final String ACTION_AUTHORISE = "login";
	public static final String ACTION_LOGOUT = "logout";
	public static final String ACTION_MAKE_ORDER = "create_order";
	public static final String ACTION_ORDER = "make_order";
	public static final String ACTION_REGISTER = "register";
	public static final String ACTION_CREATE_USER = "create_user";

	public static final String PAGE_ADMIN_MAIN = "/admin.jsp";
	public static final String PAGE_USER_MAIN = "/user.jsp";
	public static final String PAGE_ERROR = "/error.jsp";
	public static final String PAGE_DEFAULT = "/index.html";
	public static final String PAGE_REGISTER = "/register.jsp";

	public static final String PAGE_ORDER_ALL = "/orders.jsp";
	public static final String PAGE_ORDER_CREATE = "/order.jsp";

	public static final String REQUEST_PARAM_ACTION = "";
	public static final String REQUEST_PARAM_AUTHORISE = "";
	public static final String REQUEST_PARAM_USER = "user";
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_PASSWORD2 = "pass2";
	public static final String REQUEST_PARAM_MAIL = "email";
	public static final String REQUEST_PARAM_FIRSTNAME = "firstname";
	public static final String REQUEST_PARAM_LASTNAME = "lastname";
	public static final String REQUEST_PARAM_ADRESS = "adress";
	public static final String REQUEST_PARAM_TELNUMBER = "telnumber";
	public static final String REQUEST_PARAM_PASSPORT = "passport";
	public static final String REQUEST_PARAM_LIST_EQ = "list_eq";
	public static final String REQUEST_PARAM_LIST_ORDERS = "list_orders";
	public static final String REQUEST_PARAM_CURRENT_DATE = "current_date";
	public static final String REQUEST_PARAM_ERROR_MSG = "error_msg";

	public static final String SQL_STATEMENT_SELECT_USERS = "select * from user";
	public static final String SQL_STATEMENT_SELECT_USER = "select * from user where login=? and password=?";
	public static final String SQL_STATEMENT_ORDER_CREATE = "INSERT INTO sport.order (user_id, equipment_id, date_start, date_end, status) VALUES (?, ?, ?, ?, ?);";

	// Мои SQL запросы:
	public static final String SQL_STATEMENT_SELECT_ALL_EQUIPMENT = "select * from equipment;";
	public static final String SQL_STATEMENT_SELECT_ALL_ORDERS = "SELECT * FROM sport.order;";
	public static final String SQL_STATEMENT_SELECT_ALL_ORDERS_USER = "SELECT * FROM sport.order WHERE user_id=?;";
	public static final String SQL_STATEMENT_EQUIPMENT_AVIALIBLE_TOFALSE = "UPDATE sport.equipment SET isAvialible='0' WHERE  equipment_id=?;";
	public static final String SQL_STATEMENT_EQUIPMENT_AVIALIBLE_CHECK = "SELECT * FROM sport.equipment WHERE equipment_id=?;";
	public static final String SQL_STATEMENT_INSERT_USER = "INSERT INTO sport.user (login, password, role, firstName, lastName, email, adress, telNumber, passport) VALUES (?,?,?,?,?,?,?,?,?);";
	public static final String SQL_STATEMENT_FIND_USER_ID = "select * from user where user_id=?;";
	//

	public static final String PARAM_USER_ID = "user_id";
	public static final String PARAM_EQUIPMENT_ID = "equipment_id";
	public static final String PARAM_DATE_START = "date_start";
	public static final String PARAM_DATE_END = "date_end";
	public static final int PARAM_MAX_COUNT_EQUIPMENT = 3;

	public static enum ROLE {
		Admin, User, Guest, Manager, Director
	};

	public static boolean check(Order order){
		Long orderId=order.getOrderId();
		Long equipmentId=order.getEquipmentId();
		Long userId=order.getUserId();
		String dateStart=order.getDateStart().toString();
		String dateEnd=order.getDateEnd().toString();
		if (orderId!=null && equipmentId != null && userId != null && dateStart != null && dateEnd != null) {
			return true;
		} else {
			return false;
		}
	}

}
