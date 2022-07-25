/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/05/16
* 説明:
*-----------------------------------------------------------*/

package mypack;

import java.util.Vector;

/**
 * Java基本演習で使用するオブジェクトクラス。
 * @author 20238436 三善大輔
 *
 */
public class MyStack {

    private Vector<MyObject> _container;

    /**
     * スタックを定義するオブジェクト。
     */
    public MyStack(int size) {
        _container = new Vector<MyObject>(size);
    }

    /**
     * スタックに要素を追加するオブジェクト。
     */
    public void push(MyObject obj) {
        _container.add(obj);
    }

    /**
     * スタックから要素を取り除くオブジェクト。
     */
    public MyObject pop() {
        if (_container.isEmpty()) {
            return null;
        }
        return _container.remove(_container.size() - 1);
    }
}
