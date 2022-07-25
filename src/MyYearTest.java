import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/05/24
* 説明:
*-----------------------------------------------------------*/

/**
 * 西暦年のクラスMyYearをテストするクラス。
 * @author 20238436 三善大輔
 *
 */
class MyYearTest {

    @Test
    void testConstructor() {
        MyYear sut = new MyYear(1212);
        assertEquals("1212", sut.toString());
    }

    @Test
    void testIsLeap() {
        MyYear sut = new MyYear(1212);
        assertEquals(true, sut.isLeap());
    }

    @Test
    void testIsLeap100() {
        MyYear sut = new MyYear(1100);
        assertEquals(false, sut.isLeap());
    }

    @Test
    void testIsLeap400() {
        MyYear sut = new MyYear(1200);
        assertEquals(true, sut.isLeap());
    }

    @Test
    void testIsLeapNG() {
        MyYear sut = new MyYear(1213);
        assertEquals(false, sut.isLeap());
    }
}
