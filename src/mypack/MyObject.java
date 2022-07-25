/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/05/16
* 説明:
*-----------------------------------------------------------*/

package mypack;

/**
 * Java基本演習で使用するオブジェクトクラス。
 * @author 20238436 三善大輔
 *
 */
public class MyObject {
    private String _name;
    private int _value;

    /**
     * 引数nameとvalueを保存するオブジェクト。
     */
    public MyObject(String name, int value) {
        _name = name;
        _value = value;
    }

    /**
     * オブジェクトを文字列に変換する関数。
     */
    public String toString() {
        return "name: " + _name + " value: " + _value;
    }
}