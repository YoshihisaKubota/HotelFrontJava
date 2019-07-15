package objects;

import static constants.CommonConstants.*;

import java.util.Date;

/**
 * 予約情報を保持するクラス
 * @author yoshihisakubota
 *
 */
public class Reservation {

	/**
	 * 予約日
	 */
	private Date date;

	/**
	 * 予約ユーザー
	 */
	private User user;

	/**
	 * 予約情報を初期化するコンストラクタ
	 * @param date 予約する日付
	 * @param user 予約するユーザー
	 */
	public Reservation(Date date, User user){
		this.date = date;
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString(){
		return RESERVATION_DATE_LABEL + this.date +
				" " + RESERVATION_USER_LABEL + this.user;
	}
}
