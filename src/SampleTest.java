import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/05/20
* 説明:
*-----------------------------------------------------------*/

/**
 * Java基本演習で使用するオブジェクトクラス。
 * @author 20238436 三善大輔
 *
 */
class SampleTest {

    /**
     * テスト対象（Subject Under Test)のSampleクラスのオブジェクト。
     */

    protected Sample sut;
    /**
     * テストメソッドの実行ごとにその前に呼ばれる初期化メソッド。
     * テスト対象のSampleクラスのオブジェクトを生成し格納する。
     */


    @BeforeEach
    void setUp() {
        sut = new Sample();
    }

    @Test
    void getGetHello() {
        String expected = "Hello World";
        assertEquals(expected, sut.getHello("World"));
    }

}
