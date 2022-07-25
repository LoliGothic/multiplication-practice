/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/07/19
* 説明:
*-----------------------------------------------------------*/
package progex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 20238436 三善大輔
 *
 */
public class StartPage extends Panel {;
    
    public StartPage() {
        showStartPage();
    }
    
    public void showStartPage(){
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();
        Panel p5 = new Panel();
        Panel p6 = new Panel();
        
//        スタート画面を表示
        p1.setLayout(new BorderLayout());
        p1.setPreferredSize(new Dimension(800, 200));
        p2.setLayout(new BorderLayout());
        p2.setPreferredSize(new Dimension(800, 80));
        p3.setLayout(new BorderLayout());
        p3.setPreferredSize(new Dimension(800, 80));
        p4.setLayout(new BorderLayout());
        p4.setPreferredSize(new Dimension(800, 80));
        p5.setLayout(new BorderLayout());
        p5.setPreferredSize(new Dimension(800, 50));
        p6.setLayout(new BorderLayout());
        p6.setPreferredSize(new Dimension(200, 80));
        Label text = new Label("二桁掛け算練習", Label.CENTER);
        text.setFont(new Font("Arial", Font.PLAIN, 36));
        Label text1 = new Label("二桁の数字の掛け算が",  Label.CENTER);
        text1.setFont(new Font("Arial", Font.PLAIN, 36));
        Label text2 = new Label("１０回表示されるので",  Label.CENTER);
        text2.setFont(new Font("Arial", Font.PLAIN, 36));
        Label text3 = new Label("回答を入力してください",  Label.CENTER);
        text3.setFont(new Font("Arial", Font.PLAIN, 36));
        Label text4 = new Label("",  Label.CENTER);
        text4.setFont(new Font("Arial", Font.PLAIN, 36));
        p1.add(text, BorderLayout.CENTER);
        p2.add(text1, BorderLayout.CENTER);
        p3.add(text2, BorderLayout.CENTER);
        p4.add(text3, BorderLayout.CENTER);
        p5.add(text4, BorderLayout.CENTER);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        
//        スタートボタンを表示
        Button startButton = new Button("スタート");
        startButton.setFont(new Font("Arial", Font.PLAIN, 48));
        p6.add(startButton);
        add(p6);
        
        startButton.addActionListener(
                new ActionListener() { // 匿名クラスでアクションを指定
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Frame frame = (Frame) getParent();
                        CardLayout cardLayout = (CardLayout) frame.getLayout();
                        cardLayout.next(frame); //ページ名を指定して切り替え
                    }
                }
        );
    }

}
