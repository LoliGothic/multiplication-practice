import mypack.MyObject;
import mypack.MyStack;
/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/05/16
* 説明:
*-----------------------------------------------------------*/

/**
 * Java基本演習で使用するオブジェクトクラス。
 * メインメソッドを持ち、このクラスから起動する。
 * @author 20238436 三善大輔
 *
 */
public class MyTest20238436 {
    
    /**
     * java基本演習で使用するメインメソッド。
     * @param args 実行時引数。
     */
    public static void main(String [] args) {
        System.out.println("Hello DaisukeMiyoshi");

        //java基本演習04.1
        int number = 436;

        MyObject[] obj = {
                new MyObject("No.1", number),
                new MyObject("No.2", number + 10),
                new MyObject("No.3", number + 20)
        };

        //java基本演習04.2
        MyStack stack = new MyStack(3);
        for (int i = 0; i < 3; i++) {
            stack.push(obj[i]);
        }

        //java基本演習04.3
        MyObject o = stack.pop();
        while (o != null) {
            System.out.println(o);
            o = stack.pop();
        }
    }
}
