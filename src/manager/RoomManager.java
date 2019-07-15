package manager;

import static constants.CommonConstants.*;
import static constants.ObjectsConstants.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import objects.Reservation;
import objects.Room;
import objects.User;

public class RoomManager {

	/**
	 * ホテル内の全ての部屋を保持する配列
	 */
	private static ArrayList<ArrayList<Room>> _allRooms = new ArrayList<ArrayList<Room>>();

	/**
	 *
	 */
	public static void initialize(){
		for(int i = INIT_FLOOR_NUMBER; i <= LIMIT_FLOOR_NUMBER; i+= INIT_FLOOR_NUMBER){
			ArrayList<Room> oneFloorRooms = new ArrayList<Room>();
			for(int j = INIT_ROOM_NUMBER; j <= LIMIT_ROOM_NUMBER; j+= INIT_ROOM_NUMBER){
				oneFloorRooms.add(new Room(i + j));
			}
			_allRooms.add(oneFloorRooms);
		}
	}

	public static ArrayList<ArrayList<Room>> getAllRooms(){
		return _allRooms;
	}

	public static Room getRoomByNo(int roomNo){
		for(ArrayList<Room> rooms:_allRooms){
			for(Room room: rooms){
				if(room.getRoomNo() == roomNo){
					return room;
				}
			}
		}
		return null;
	}


	public static HashMap<Room, Reservation> getReserveRoomListByUserName(User user){
		// 部屋番号に対応する予約情報を格納する
		HashMap<Room, Reservation> resultRoomResrevations = new HashMap<Room, Reservation>();

		// 全部屋を捜索し、名前が一致する予約情報を取り出す
		for(ArrayList<Room> eachFloorRoomList: _allRooms){
			for(Room room: eachFloorRoomList){
				for(Reservation rev: room.getAllReservation()){
					if(rev.getUser().getlName().equals(user.getlName()) &&
							rev.getUser().getfName().equals(user.getfName()) ){
						resultRoomResrevations.put(room, rev);
					}
				}
			}
		}

		return resultRoomResrevations;
	}

	public static int getAllRoomCount(ArrayList<ArrayList<Room>> allRoomList){
		int roomCount = 0;

		// 現在作られている部屋の数をカウントする
		for(ArrayList<Room> eachFloorRoomList: allRoomList){
			roomCount += eachFloorRoomList.size();
		}

		return roomCount;
	}


	/**
	 *
	 * @param revDate
	 * @return
	 */
	public static ArrayList<ArrayList<Room>> getReservationAvailableRoom(Date revDate){
		ArrayList<ArrayList<Room>> resultAllRoomList = new ArrayList<ArrayList<Room>>();

		// 予約可能な部屋を取り出し、階数毎に分け、リストに格納する
		for(ArrayList<Room> eachFloorRoomList:_allRooms){
			ArrayList<Room> resultEachFloorRoomList = new ArrayList<Room>();
			for(Room room: eachFloorRoomList){
				if(room.checkReservationAvailable(revDate)){
					resultEachFloorRoomList.add(room);
				}
			}
			resultAllRoomList.add(resultEachFloorRoomList);
		}

		return resultAllRoomList;
	}

	public static void displayRoom(int roomNo){

	}

	public static void displayRooms(int[] roomNos){

	}

	/**
	 * 引数の部屋リストの部屋情報を全て表示する
	 * @param roomList 表示する部屋情報のリスト
	 */
	public static void displayRooms(ArrayList<ArrayList<Room>> allFloorRoomList){
		System.out.println(ROOM_NO_LABEL);
		for(ArrayList<Room> rooms: allFloorRoomList){
			for(Room room: rooms){
				System.out.print(room.getRoomNo() + ", ");
			}
			System.out.println();
		}
	}

	public static void displayReservation(int roomNo, Date d){

	}

	/**
	 * 全ての部屋の全ての予約情報を表示する
	 */
	public static void displayAllReservation(){
		for(ArrayList<Room> rooms:_allRooms){
			for(Room room: rooms){
				System.out.println(room);
				for(Reservation rev: room.getAllReservation()){
					System.out.print(rev + " ");
				}
				System.out.println();
			}
		}
	}

	public static void displayAllRoom(){

	}
}
