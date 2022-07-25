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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 20238436 三善大輔
 *
 */
public class AnswerPage extends Panel {
    public String userAns;
    public int userAns1;
    
//    showProblemPageで問題を表示しているのでコンストラクタでは何もしない
    public AnswerPage() {}
    
    public void showProblemPage(Problem p, int problemNumber, MainFrame mainFrame) {
        
//        問題と問題番号取得
        int x = p.getX();
        int y = p.getY();
        int number = problemNumber;
        
//        問題と問題番号を文字列にキャスト
        Integer x1 = Integer.valueOf(x);
        Integer y1 = Integer.valueOf(y);
        Integer number1 = Integer.valueOf(number);
        String x2 = x1.toString();
        String y2 = y1.toString();
        String number2 = number1.toString();
      
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();
        Panel p5 = new Panel();
        Panel p6 = new Panel();
        Panel p7 = new Panel();
        
//        問題を表示
        p1.setLayout(new BorderLayout());
        p1.setPreferredSize(new Dimension(800, 200));
        p2.setLayout(new BorderLayout());
        p2.setPreferredSize(new Dimension(200, 300));
        p3.setLayout(new BorderLayout());
        p3.setPreferredSize(new Dimension(200, 300));
        p4.setLayout(new BorderLayout());
        p4.setPreferredSize(new Dimension(200, 300));
        p5.setLayout(new BorderLayout());
        p5.setPreferredSize(new Dimension(200, 100));
        p6.setLayout(new BorderLayout());
        p6.setPreferredSize(new Dimension(200, 100));
        p7.setLayout(new BorderLayout());
        p7.setPreferredSize(new Dimension(200, 100));
        Label text = new Label("第"+number2+"問", Label.CENTER);
        text.setFont(new Font("Arial", Font.PLAIN, 48));
        Label text1 = new Label(x2,  Label.CENTER);
        text1.setFont(new Font("Arial", Font.PLAIN, 48));
        Label text2 = new Label("×",  Label.CENTER);
        text2.setFont(new Font("Arial", Font.PLAIN, 48));
        Label text3 = new Label(y2,  Label.CENTER);
        text3.setFont(new Font("Arial", Font.PLAIN, 48));
        Label text4 = new Label("回答:",  Label.CENTER);
        text4.setFont(new Font("Arial", Font.PLAIN, 48));
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

//        テキストフィールドを表示
        setLayout(new FlowLayout());
        TextField t1 = new TextField("");
        t1.setFont(new Font("Arial", Font.PLAIN, 48));
        p6.add(t1);
        add(p6);
        
//        ボタンを表示
        Button nextButton = new Button("次へ");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 48));
        p7.add(nextButton);
        add(p7);
        
        nextButton.addActionListener(
            new ActionListener() { // 匿名クラスでアクションを指定
                
                @Override
                public void actionPerformed(ActionEvent e) {
//                    入力が空だったら0を保存．数字だったら整数にキャストして保存．
                    if (t1.getText().isEmpty()) {
                        userAns =  "0";
                        userAns1 = Integer.parseInt(userAns);
                        p.setUserAnswer(userAns1);
                    }
                    else {
                        userAns = t1.getText();
                        userAns1 = Integer.parseInt(userAns);
                        p.setUserAnswer(userAns1);
                    }
                    
                    mainFrame.count ++;
                    
//                    十問目が終わったら結果画面を表示する
                    if (mainFrame.count == 10) {
                        ResultPage resultPage = new ResultPage();
                        resultPage.showResultPage(mainFrame.getProblemManager(), mainFrame);
                        mainFrame.add(resultPage);
                        mainFrame.count = 0;
                    }
                    
                    Frame frame = (Frame) getParent();
                    CardLayout cardLayout = (CardLayout) frame.getLayout();
                    cardLayout.next(frame); //ページ名を指定して切り替え
                }
            }
        );
    }

}
