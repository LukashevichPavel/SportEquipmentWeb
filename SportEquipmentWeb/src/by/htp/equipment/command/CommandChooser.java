package by.htp.equipment.command;
import static by.htp.equipment.util.ConstantValue.*;

public class CommandChooser {

	public static CommandAction chooseAction(String action) {
		switch (action) {
		case ACTION_AUTHORISE:{
			System.out.println("Login action: ");
			return new LoginCommandAction();
			}
		case ACTION_MAKE_ORDER:{
			System.out.println("Create order action ");
			return new OrderCreateAction();
			}
		case ACTION_ORDER:{
			System.out.println("Make order action ");
			return new MakeOrderAction();
			}
		case ACTION_REGISTER:{
			System.out.println("Register page ");
			//return new ShowRegisterPage(); 
			}
		case ACTION_CREATE_USER:{
			System.out.println("Create user action ");
			return new RegisterCommandAction();
		}
		}
		///STUB!!!!
		return null;
	}
}