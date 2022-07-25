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
public class ResultPage extends Panel {

//    showResultPageで結果を表示しているのでコンストラクタでは何もしない
    public ResultPage() {}
    
    public void showResultPage(ProblemManager problemManager, MainFrame mainFrame) {
//        スコアを集計
        for (int i=0;i<10; i++) {
            int correctAns = problemManager.problems[i].getCorrectAnswer();
            int userAns = problemManager.problems[i].getUserAnswer();
            if (correctAns == userAns) {
                problemManager.score++;
            }
        }
        
        
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();
        Panel p5 = new Panel();
        Panel p10 = new Panel();
        Panel p11 = new Panel();

//        結果，問題，正答，回答，採点の文字だけを画面に表示
        p1.setLayout(new BorderLayout());
        p1.setPreferredSize(new Dimension(800, 50));
        p2.setLayout(new BorderLayout());
        p2.setPreferredSize(new Dimension(180, 50));
        p3.setLayout(new BorderLayout());
        p3.setPreferredSize(new Dimension(180, 50));  
        p4.setLayout(new BorderLayout());
        p4.setPreferredSize(new Dimension(180, 50));
        p5.setLayout(new BorderLayout());
        p5.setPreferredSize(new Dimension(180, 50));
        p10.setLayout(new BorderLayout());
        p10.setPreferredSize(new Dimension(200, 80));
        p11.setLayout(new BorderLayout());
        p11.setPreferredSize(new Dimension(200, 80));
        Label text = new Label("結果" + problemManager.score + "点", Label.CENTER);
        text.setFont(new Font("Arial", Font.PLAIN, 32));
        Label text1 = new Label("問題",  Label.CENTER);
        text1.setFont(new Font("Arial", Font.PLAIN, 32));
        Label text2 = new Label("正答",  Label.CENTER);
        text2.setFont(new Font("Arial", Font.PLAIN, 32));
        Label text3 = new Label("回答",  Label.CENTER);
        text3.setFont(new Font("Arial", Font.PLAIN, 32));
        Label text4 = new Label("採点",  Label.CENTER);
        text4.setFont(new Font("Arial", Font.PLAIN, 32));
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
        
//        十問分の問題，正答，回答，採点を画面に表示
        for (int i=0; i<10; i++) {
            String scoring;

//            問題，正答，回答を整数から文字列にキャスト
            int correctAns = problemManager.problems[i].getCorrectAnswer();
            int userAns = problemManager.problems[i].getUserAnswer();
            int x = problemManager.problems[i].getX();
            int y = problemManager.problems[i].getY();
            Integer correctAns1 = Integer.valueOf(correctAns);
            Integer userAns1 = Integer.valueOf(userAns);
            Integer x1 = Integer.valueOf(x);
            Integer y1 = Integer.valueOf(y);
            String correctAns2 = correctAns1.toString();
            String userAns2 = userAns1.toString();
            String x2 = x1.toString();
            String y2 = y1.toString();
            
//            回答があっていたら，●，間違っていたら，☓
            if (correctAns == userAns) {
                scoring = "●";
            }
            else {
                scoring = "☓";
            }
            
            Panel p6 = new Panel();
            Panel p7 = new Panel();
            Panel p8 = new Panel();
            Panel p9 = new Panel();
            
            p6.setLayout(new BorderLayout());
            p6.setPreferredSize(new Dimension(180, 50));
            p7.setLayout(new BorderLayout());
            p7.setPreferredSize(new Dimension(180, 50));
            p8.setLayout(new BorderLayout());
            p8.setPreferredSize(new Dimension(180, 50));
            p9.setLayout(new BorderLayout());
            p9.setPreferredSize(new Dimension(180, 50));
            Label text5 = new Label(x2+"×"+y2,  Label.CENTER);
            text5.setFont(new Font("Arial", Font.PLAIN, 32));
            Label text6 = new Label(correctAns2,  Label.CENTER);
            text6.setFont(new Font("Arial", Font.PLAIN, 32));
            Label text7 = new Label(userAns2,  Label.CENTER);
            text7.setFont(new Font("Arial", Font.PLAIN, 32));
            Label text8 = new Label(scoring,  Label.CENTER);
            text8.setFont(new Font("Arial", Font.PLAIN, 32));
            p6.add(text5, BorderLayout.CENTER);
            p7.add(text6, BorderLayout.CENTER);
            p8.add(text7, BorderLayout.CENTER);
            p9.add(text8, BorderLayout.CENTER);
            add(p6);
            add(p7);
            add(p8);
            add(p9);
        }
        
//        終了ボタンを画面に表示
        Button exitButton = new Button("終了");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 48));
        p10.add(exitButton);
        add(p10);

        exitButton.addActionListener(
                new ActionListener() { // 匿名クラスでアクションを指定
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );
        
//        もう一度ボタンを画面に表示
        Button restartButton = new Button("もう一度");
        restartButton.setFont(new Font("Arial", Font.PLAIN, 48));
        p11.add(restartButton);
        add(p11);
        
        restartButton.addActionListener(
                new ActionListener() { // 匿名クラスでアクションを指定
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
//                        現在のframeを閉じて新しいframeを表示
                        mainFrame.setVisible(false);
                        MainFrame nextMainFrame = new MainFrame("2桁掛け算");
                        nextMainFrame.setVisible(true);
                        
                        Frame frame = (Frame) getParent();
                        CardLayout cardLayout = (CardLayout) frame.getLayout();
                        cardLayout.next(frame); //ページ名を指定して切り替え
                    }
                }
        );
    }

}
