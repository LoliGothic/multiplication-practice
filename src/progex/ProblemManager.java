/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/07/19
* 説明:
*-----------------------------------------------------------*/
package progex;

import java.util.Random;

/**
 * @author 20238436 三善大輔
 *
 */
public class ProblemManager {
    
    public static final int MAX_SIZE = 10;
    
    public int score = 0;
    
    public Problem[] problems;
    
//    重複している問題がないか調べる二次元配列
    private int[][] confirm = {
            {0,0},
            {0,0},
            {0,0},
            {0,0},
            {0,0},
            {0,0},
            {0,0},
            {0,0},
            {0,0},
            {0,0}
    };
    
    private int currentIndex;
    
    public void generateProblems() {
        Random rand = new Random();
        
        problems = new Problem[MAX_SIZE];
        
//        重複しない問題を10問生成
        for (int i=0; i<MAX_SIZE; i++) {
            int x = (int)rand.nextInt(90) + 10;
            int y = (int)rand.nextInt(90) + 10;
            if (confirmRandom(x,y)) {
                i--;
                continue;
            }
            else {
                confirm[i][0] = x;
                confirm[i][1] = y;
            }
            problems[i] = new Problem(x, y);
        }
        
    }

    public Problem next() {
        currentIndex ++;
        if (currentIndex - 1 < MAX_SIZE) {
            return problems[currentIndex - 1];
        }
        return null;
    }

    public boolean hasNext() {
        return currentIndex < MAX_SIZE;
    }

    public int getProblemNumber() {
        return currentIndex;
    }
    
//    重複確認
    public boolean confirmRandom(int x, int y) {
        int flag = 0;
        for (int i=0; i<10; i++) {
            if ((confirm[i][0] == x && confirm[i][1] == y) || (confirm[i][0] == y && confirm[i][1] == x)) {
                flag = 1;
            }
        }
        if (flag == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
