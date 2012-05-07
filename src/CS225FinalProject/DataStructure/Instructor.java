package CS225FinalProject.DataStructure;

/**
 * @author Zack
 */

public class Instructor extends User {

	public Instructor(String name, String password, int userID) {
		super(name, password, userID);
		this.setInstuctor(true);
	}

	@Override
	public String getClassName() {
		return null;
	}

	@Override
	public void setClassName(String className) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getRealName() {
		return "";
	}

	@Override
	public void setRealName(String realName) {
		// TODO Auto-generated method stub
	}
}
