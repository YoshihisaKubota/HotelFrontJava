package objects;

import static constants.CommonConstants.*;

import java.util.Date;

/**
 * ユーザー情報を管理するクラス
 * @author yoshihisakubota
 *
 */
public class User {
	private String lName;
	private String fName;
	private Date birthDay;

	public User(String lName, String fName){
		this.lName = lName;
		this.fName = fName;
	}

	public User(String lName, String fName, Date birthDay){
		this.lName = lName;
		this.fName = fName;
		this.birthDay = birthDay;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * ユーザー情報を画面に表示する
	 */
	public void displayUserInfo(){
		System.out.println(USER_NAME_LABEL + this.lName + " " + this.fName);
		System.out.println(USER_BIRTHDAY_LABEL + this.birthDay);
	}

	/**
	 * 名前のみを返すようにする
	 */
	@Override
	public String toString(){
		return this.lName + " " + this.fName;
	}
}
