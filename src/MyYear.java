/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/05/24
* 説明:
*-----------------------------------------------------------*/

/**
 * JUnit演習で使用するオブジェクトクラス。
 * @author 20238436 三善大輔
 *
 */
public class MyYear {
    private int _year;
    
    /**
     * 与えられた数値を西暦年として保持するコンストラクタ。
     * @param year 西暦年
     */
    public MyYear(int year) {
        _year = year;

    }

    /**
     * 保持している西暦年を文字列として返すメソッド。
     * java.lang.ObjectのtoString()をオーバーライドしている。
     */
    public String toString() {
        return Integer.toString(_year);
    }

    /**
     * 閏年かを判定する関数。
     */
    public boolean isLeap() {
        if (_year % 400 == 0 || (_year % 4 == 0 && _year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }
}
