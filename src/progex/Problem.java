/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/07/19
* 説明:
*-----------------------------------------------------------*/
package progex;

/**
 * @author 20238436 三善大輔
 *
 */
public class Problem {
    private int x;
    private int y;
    private int userAnswer;

    public Problem(int x, int y) {
//        xとおyが10以上100未満出ないとエラーを吐かせる
        try {
            if ((x>=10 && x<=99) && (y>=10 && y<=99)) {
                this.x = x;
                this.y = y;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        finally {}
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCorrectAnswer() {
        return x * y;
    }
    
    public int getUserAnswer() {
        return userAnswer;
    }
    
    public void setUserAnswer(int ans) {
        userAnswer = ans;
    }

}
