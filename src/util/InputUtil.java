package util;

import static constants.CommonConstants.*;
import static constants.UtilConstants.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import objects.User;

/**
 * I/Oに関する機能をまとめたクラス
 * @author yoshihisakubota
 *
 */
public class InputUtil {
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

    /**
     * キーボードより入力された値を取得し、 String として返すメソッド
     * @param msg どのような文字列を入力するかを補足するメッセージ
     * @return 入力された文字列を String として返す
     */
    public static String readLineStr(String msg){
        if(!msg.equals("")){
            System.out.print(msg);
        }
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

    /**
     * キーボードより入力された値を取得し、 Int として返すメソッド
     * @param msg どのような文字列を入力するかを補足するメッセージ
     * @return 入力された数値を Int として返す
     */
    public static int readLineNum(String  msg){
        int num = -1;
        while(true){
            try {
                num = Integer.parseInt(readLineStr(msg));
                break;
            } catch (NumberFormatException ne) {
                System.out.println(ERROR_NUM_INPUT_MSG);
                continue;
            } catch (Exception e){
            	e.printStackTrace();
            	System.out.println(UNEXPECTED_ERROR_MSG);
            	break;
            }
        }
        return num;
    }

    /**
     * キーボードより入力された値を取得し、 Date として返すメソッド
     * @param msg どのような文字列を入力するかを補足するメッセージ
     * @param format 日付の形式
     * @return 入力された日付を Date として返す
     */
    public static Date readLineDate(String msg, String format){
    	Date date = null;
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	while(true){
    		try {
    			date = sdf.parse(readLineStr(msg));
    			break;
    		} catch (ParseException pe){
    			System.out.println(ERROR_DATE_INPUT_MSG);
    			continue;
    		} catch (Exception e) {
    			e.printStackTrace();
    			System.out.println(UNEXPECTED_ERROR_MSG);
    			break;
    		}
    	}

    	return date;
    }

    /**
     *
     * @param msg どのような事柄に対してYES、NOを問うかを補足するメッセージ
     * @return 入力された問いを boolean で返す
     */
    public static boolean readLineYN(String msg){
    	return readLineStr(msg).equals(YES_STR);
    }

    /**
     *
     * @return
     */
    public static User readLineUserName(){
    	System.out.println(INPUT_USER_INFO_PRE_MSG);
    	while(true){
    		String lName = InputUtil.readLineStr(LAST_NAME_LABEL);
    		String fName = InputUtil.readLineStr(FIRST_NAME_LABEL);

    		if(readLineYN(INPUT_USER_INFO_CHECK_MSG)){
    			return new User(lName, fName);
    		}
    	}
    }

    /**
     * ユーザー情報を全て入力する。
     * @return
     */
    public static User readLineUserAllInfo(){
    	System.out.println(INPUT_USER_INFO_PRE_MSG);
    	while(true){
    		String lName = InputUtil.readLineStr(LAST_NAME_LABEL);
    		String fName = InputUtil.readLineStr(FIRST_NAME_LABEL);
    		Date birthDay = InputUtil.readLineDate(BIRTH_DAY_LABEL, DATE_FORMAT);

    		if(readLineYN(INPUT_USER_INFO_CHECK_MSG)){
    			return new User(lName, fName, birthDay);
    		}
    	}
    }

}