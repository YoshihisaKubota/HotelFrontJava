package main;

import static constants.CommonConstants.*;
import static constants.MainConstants.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import manager.RoomManager;
import objects.Reservation;
import objects.Room;
import objects.User;
import util.InputUtil;

/**
 * ホテルフロント受付システムのメインクラス
 * @author yoshihisakubota
 */
public class Main {

    private static boolean endFlag = false;

    private Main(){
    	RoomManager.initialize();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
        main.run();
        main.end();
    }

    /**
     * システムの開始処理を行うメソッド
     */
    private void start(){
        System.out.println(SYSTEM_START_MSG);
    }

    /**
     * システムのメイン処理を行うメソッド
     */
    private void run(){
        int inNum;
        while(!endFlag){
            System.out.println(MENU_MSG);
            inNum = InputUtil.readLineNum(INPUT_PRE_MSG);

            switch(inNum) {
                case INPUT_VALUE_RESERVE:
                	this.reservationAcceptance();
                    break;
                case INPUT_VALUE_CHECK:
                	this.reservationcheck();
                	break;
                case INPUT_VALUE_CHECKIN:
                	this.checkInAcceptance();
                	break;
                case INPUT_VALUE_CHECKOUT:
                	this.checkOutAcceptance();
                	break;
                case INPUT_VLAUE_END:
                    endFlag = true;
                    break;
                default:
                    System.out.println("try agein");
            }
        }
    }

    /**
     * システムの終了処理を行うメソッド
     */
    private void end(){
        System.out.println(SYSTEM_END_MSG);
    }

    /**
     * 部屋の予約受付処理を行うメソッド
     */
    private void reservationAcceptance(){
    	// 予約受付処理開始メッセージの表示
    	System.out.println(RESERVATION_ACCEPTANCE_PRE_MSG);

    	boolean reserveEndFlag = false;

    	while(!reserveEndFlag){
    		// 予約する日付を入力
    		Date revDate = InputUtil.readLineDate(INPUT_DATE_PRE_MSG, DATE_FORMAT);
    		ArrayList<ArrayList<Room>> roomList = RoomManager.getReservationAvailableRoom(revDate);

    		int roomCount = RoomManager.getAllRoomCount(roomList);

    		if(roomCount == 0){
    			// 予約可能な部屋がない旨を表示する
    			System.out.println(NOT_AVAILABLE_RESERVE_DATE_MSG);

    			// 他の日付の予約を行うか問う
    			if(InputUtil.readLineYN(INPUT_RESERVE_DATE_CONTINUE_CHECK)){
    				continue;
    			} else {
    				break;
    			}
    		}

    		// 予約可能な部屋のリストを表示する
    		RoomManager.displayRooms(roomList);

    		System.out.println();

    		// 予約する部屋を決める
    		while(true){
    			// 予約する部屋番号を入力
            	int roomNo = InputUtil.readLineNum(INPUT_ROOM_PRE_MSG);

            	// 0 を入力で予約をキャンセル （メソッドの終端まで行く）
            	if (roomNo == 0){
            		reserveEndFlag = true;
            		break;
            	}
            	Room r = RoomManager.getRoomByNo(roomNo);

            	// 該当の部屋番号があった場合
            	if(r != null){
            		User user = InputUtil.readLineUserAllInfo();
            		r.reserve(user, revDate);

            		System.out.println(RESERVE_COMPLETE_MSG);
            		System.out.println(RESERVE_COMPLETE_DATE + revDate + " " + RESERVE_COMPLETE_USER + user);;
            		reserveEndFlag = true;
            		break;
            	} else {
            		// 部屋番号の再入力を促すメッセージを表示する。
            		System.out.println(INPUT_RESERVE_ROOM_NO_MISS_MSG);
            		continue;
            	}
    		}
    	}
    }

    /**
     * 予約確認を行う処理
     */
    private void reservationcheck(){
    	System.out.println(RESERVATION_CHECK_PRE_MSG);

    	//
    	User user = InputUtil.readLineUserName();
    	HashMap<Room, Reservation> roomReservationMap = new HashMap<Room, Reservation>();

    	// 入力数値が0で全ての部屋の予約を確認
    	for(Room room: roomReservationMap.keySet()){
    		RoomManager.displayAllReservation();
    	}
    }

    /**
     * チェックイン受付処理を行うメソッド
     */
    private void checkInAcceptance(){

    }

    /**
     * チェックアウト受付処理を行うメソッド
     */
    private void checkOutAcceptance(){

    }
}