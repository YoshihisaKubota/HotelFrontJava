package objects;

import static constants.CommonConstants.*;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yoshihisakubota
 *
 */
public class Room {

	/**
	 * 部屋の全予約を保持する配列
	 */
	private ArrayList<Reservation> reservations;

	/**
	 * 部屋番号
	 */
	private int roomNo;

	/**
	 * 部屋情報を初期化するコンストラクタ
	 * @param roomNo 部屋番号
	 */
	public Room(int roomNo){
		this.roomNo = roomNo;
		this.reservations = new ArrayList<Reservation>();
	}

	/**
	 * 予約処理を行うメソッド
	 */
	public boolean reserve(User user, Date date){
		this.reservations.add(new Reservation(date, user));

		return true;
	}

	/**
	 * 予約可能か確認を行うメソッド
	 * @param date 予約日
	 * @return 予約可能：true、予約不可：false
	 */
	public boolean checkReservationAvailable(Date date){
		for(Reservation rev: reservations){
			if(rev.getDate().compareTo(date) == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * チェックイン処理を行うメソッド
	 */
	public boolean checkIn(){

		return true;
	}

	/**
	 * 部屋に予約されている情報を全て返す
	 * @return 予約リスト
	 */
	public ArrayList<Reservation> getAllReservation(){
		return this.reservations;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public void displayReservation(){

	}

	public void displayAllReservation(){

	}

	@Override
	public String toString(){
		return ROOM_NO_LABEL + this.roomNo;
	}
}
