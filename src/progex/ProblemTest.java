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
public class ProblemTest {
    
    @Test
    @DisplayName("Xの有効同値クラスのテスト，下限")
    void testX_Lowest() {
        Problem sut = new Problem(10, 33);
        assertEquals(10, sut.getX());
        assertEquals(33, sut.getY());
        assertEquals(0, sut.getUserAnswer());
    }

    @Test
    @DisplayName("Xの有効同値クラスのテスト，上限")
    void testX_Highest() {
        Problem sut = new Problem(99, 46);
        assertEquals(99, sut.getX());
        assertEquals(46, sut.getY());
        assertEquals(0, sut.getUserAnswer());
    }
    
    
    @Test
    @DisplayName("Yの有効同値クラスのテスト，下限")
    void testY_Lowest() {
        Problem sut = new Problem(50, 10);
        assertEquals(50, sut.getX());
        assertEquals(10, sut.getY());
        assertEquals(0, sut.getUserAnswer());
    }

    @Test
    @DisplayName("Yの有効同値クラスのテスト，上限")
    void testY_Highest() {
        Problem sut = new Problem(21, 99);
        assertEquals(21, sut.getX());
        assertEquals(99, sut.getY());
        assertEquals(0, sut.getUserAnswer());
    }
    
    @Test
    @DisplayName("Xの上限オーバーでコンストラクタで例外が発生する")
    public void testXOverException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Problem(100, 12));
    }
    
    @Test
    @DisplayName("Xの下限オーバーでコンストラクタで例外が発生する")
    public void testXUnderException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Problem(9, 89));
    }
    
    @Test
    @DisplayName("Yの上限オーバーでコンストラクタで例外が発生する")
    public void testYOverException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Problem(52, 100));
    }
    
    @Test
    @DisplayName("Yの下限オーバーでコンストラクタで例外が発生する")
    public void testYUnderException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Problem(98, 9));
    }
    
    @Test
    @DisplayName("userAnsの有効同値クラスのテスト，下端1")
    void testUserAns_Lowest1() {
        Problem sut = new Problem(50,50);
        sut.setUserAnswer(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, sut.getUserAnswer());
    }
    
    @Test
    @DisplayName("userAnsの有効同値クラスのテスト，上端1")
    void testUserAns_Highest1() {
        Problem sut = new Problem(50,50);
        sut.setUserAnswer(99);
        assertEquals(99, sut.getUserAnswer());
    }
    
    @Test
    @DisplayName("userAnsの有効同値クラスのテスト，下端2")
    void testUserAns_Lowest2() {
        Problem sut = new Problem(50,50);
        sut.setUserAnswer(100);
        assertEquals(100, sut.getUserAnswer());
    }
    
    @Test
    @DisplayName("userAnsの有効同値クラスのテスト，上端2")
    void testUserAns_Highest2() {
        Problem sut = new Problem(50,50);
        sut.setUserAnswer(9801);
        assertEquals(9801, sut.getUserAnswer());
    }
    
    @Test
    @DisplayName("userAnsの有効同値クラスのテスト，下端3")
    void testUserAns_Lowest3() {
        Problem sut = new Problem(50,50);
        sut.setUserAnswer(9802);
        assertEquals(9802, sut.getUserAnswer());
    }
    
    @Test
    @DisplayName("UserAnsの有効同値クラスのテスト，上端3")
    void testUserAns_Highest3() {
        Problem sut = new Problem(50,50);
        sut.setUserAnswer(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, sut.getUserAnswer());
    }
    
    @Test
    @DisplayName("correctAnswerの有効同値クラスのテスト，xの下端")
    void testCorrectAnsX_Lowest() {
        Problem sut = new Problem(10,50);
        assertEquals(500, sut.getCorrectAnswer());
    }
    
    @Test
    @DisplayName("correctAnswerの有効同値クラスのテスト，xの上端")
    void testCorrectAnsX_Highest() {
        Problem sut = new Problem(99,30);
        assertEquals(2970, sut.getCorrectAnswer());
    }
    
    @Test
    @DisplayName("correctAnswerの有効同値クラスのテスト，yの下端")
    void testCorrectAnsY_Lowest() {
        Problem sut = new Problem(33,10);
        assertEquals(330, sut.getCorrectAnswer());
    }
    
    @Test
    @DisplayName("correctAnswerの有効同値クラスのテスト，yの上端")
    void testCorrectAnsY_Highest() {
        Problem sut = new Problem(20,99);
        assertEquals(1980, sut.getCorrectAnswer());
    }
}
