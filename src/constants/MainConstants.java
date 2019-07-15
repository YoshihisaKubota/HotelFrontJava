package constants;

/**
 * main パッケージ内で使用する定数をまとめたクラス
 * @author yoshihisakubota
 *
 */
public final class MainConstants {
    public static final String SYSTEM_START_MSG = "ホテルフロント受付システムを開始します。";
    public static final String SYSTEM_END_MSG = "ホテルフロント受付システムを終了します。";
    public static final String MENU_MSG = "予約:1、確認:2、チェックイン:3、チェックアウト:4、終了:0";
    public static final String INPUT_PRE_MSG = "行いたい操作を入力してください：";
    public static final String INPUT_DATE_PRE_MSG = "日付（yyyy/mm/dd）：";
    public static final String INPUT_DATETIME_PRE_MSG = "日時（yyyy/mm/dd hh:mm）：";
    public static final String INPUT_ROOM_PRE_MSG = "部屋番号[0でキャンセル]：";
    public static final String INPUT_ROOM_CHECK_PRE_MSG = "部屋番号[0で全て]：";
    public static final String INPUT_RESERVE_CHECK_PRE_MSG = "予約可能です。この上記で予約しますか？[y/n]";
    public static final String NOT_AVAILABLE_RESERVE_DATE_MSG = "指定した日付で予約可能な部屋はございませんは。";
    public static final String NOT_AVAILABLE_ROOM_MSG = "指定した日付の部屋は既に予約済みです。";
    public static final String INPUT_RESERVE_DATE_CONTINUE_CHECK = "他の条件で探しますか？[y/n]";
    public static final String INPUT_RESERVE_ROOM_NO_MISS_MSG = "予約可能な部屋番号を入力してください。";
    public static final String RESERVE_COMPLETE_MSG = "予約が完了しました。";
    public static final String RESERVE_COMPLETE_DATE = "予約日：";
    public static final String RESERVE_COMPLETE_USER = "予約者：";
    public static final int INPUT_VALUE_RESERVE = 1;
    public static final int INPUT_VALUE_CHECK = 2;
    public static final int INPUT_VALUE_CHECKIN = 3;
    public static final int INPUT_VALUE_CHECKOUT = 4;
    public static final int INPUT_VLAUE_END = 0;
    public static final String RESERVATION_ACCEPTANCE_PRE_MSG = "予約日と予約する部屋を入力してください";
    public static final String RESERVATION_CHECK_PRE_MSG = "予約確認したい部屋番号を入力してください。";
}