/*----------------------------------------------------------
* 佐賀大学理工学部情報部門
* プログラミング演習 III 第 x 回 xx 演習
* 作成者: 20238436 三善大輔
* 作成日: 2022/07/19
* 説明:
*-----------------------------------------------------------*/
package progex;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 20238436 三善大輔
 *
 */
public class MainFrame extends Frame {
    
//    何問解いたかカウント
    public int count = 0;
    
    private  ProblemManager problemManager;
    
    public MainFrame(String appName) {
        super(appName);
        
//        　問題管理者の初期化
        problemManager = new ProblemManager();
        createProblemManager();
        
//        画面サイズ設定
        setSize(800, 800);
        
        CardLayout cardLayout = new CardLayout(); //addしたものが1ページずつ紙芝居のように表示
        setLayout(cardLayout);
        
//        スタートページを表示
        StartPage startPage = new StartPage();
        add(startPage);
        
//        アンサーページを10回表示
        while(true) {
            AnswerPage answerPage = new AnswerPage();
            answerPage.showProblemPage(problemManager.next(), problemManager.getProblemNumber(), this);
            add(answerPage);
            if (!problemManager.hasNext()) {
                break;
            }
        }
              
//         閉じボタンイベントに対応する
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }
        });
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("2桁掛け算");
        
        // Frameを表示する
        mainFrame.setVisible(true);
    }
    
    public ProblemManager getProblemManager() {
        return problemManager;
    }
    
    public void createProblemManager() {
        problemManager.generateProblems();
    }
}
