/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/07/19
* 説明:
*-----------------------------------------------------------*/
package progex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author 20238436 三善大輔
 *
 */
public class ProblemManagerTest {
    
    @Test
    @DisplayName("generateProblems メソッドで生成された問題数が規定回数分生成されていること")
    void test01() {
        ProblemManager sut = new ProblemManager();
        sut.generateProblems();
        int count = 0;
        
        while(sut.hasNext()) {
            assertNotNull(sut.next());
            count ++;
        }
        
        //　規定数は10回
        assertEquals(ProblemManager.MAX_SIZE, count);
    }
    
    @Test
    @DisplayName("generateProblems メソッドで生成された問題が相互に重複していないこと")
    void test02() {
        ProblemManager sut = new ProblemManager();
        sut.generateProblems();
        
        Problem[] plist = new Problem[ProblemManager.MAX_SIZE];
        int index = 0;
        while (sut.hasNext()) {
            plist[index] = sut.next();
            index++;
        }
        
        for (int i=0; i<ProblemManager.MAX_SIZE; i++) {
            for (int j=i+1; j<ProblemManager.MAX_SIZE; j++) {
                if (plist[i].getX() == plist[j].getX() && plist[i].getY() == plist[j].getY()) {
                    fail();
                }
            }
        }
    }
    
    @Test
    @DisplayName("next メソッドが初回から規定回数まで hasNext が true となり，対応する正しい問題を返すこと")
    void test03() {
        ProblemManager sut = new ProblemManager();
        sut.generateProblems();
        
        // 規定回数はProblemManager.MAX_SIZE
        for (int i=0; i<ProblemManager.MAX_SIZE; i++) {
            assertEquals(true, sut.hasNext());
            Problem p = sut.next();
            assertEquals(i + 1, sut.getProblemNumber());
        }
    }
    
    @Test
    @DisplayName("next メソッドが規定回数を超えた場合は， hasNext が false となり next が null を返すこと")
    void test04() {
        ProblemManager sut = new ProblemManager();
        sut.generateProblems();
        Problem p;
        for (int i=0; i<ProblemManager.MAX_SIZE; i++) {
            p = sut.next();
        }
        assertEquals(false, sut.hasNext());
        assertEquals(null, sut.next());
    }
    
    
    
    
    
    
    
}
