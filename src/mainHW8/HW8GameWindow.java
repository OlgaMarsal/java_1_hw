package mainHW8;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class HW8GameWindow extends JFrame implements ResultCallback {
    static final int WINDOW_POS_X = 400;
    static final int WINDOW_POS_Y = 300;
    static final int WINDOW_HEIGHT = 455;
    static final int WINDOW_WIDTH = 405;

    private HW8SettingWindow settingWindow;
    private HW8BattleField battleField;


    public HW8GameWindow () {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");

        HW8Logic.registerWinnerCallback(this);
        settingWindow = new HW8SettingWindow(this);
        battleField = new HW8BattleField(this);

        add(battleField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonOK = new JButton("Start new game");
        panel.add(buttonOK);
        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        buttonOK.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winningLength){
        battleField.startNewGame(mode, fieldSize, winningLength);
    }

//    public void lastWindow(){
//        if (HW8Logic.isFull()) {
//            lastWindow.labelArea.setText(lastWindow.label[2]);
//        }
//        if (HW8Logic.checkWinLines(HW8Logic.DOT_X)) {
//            lastWindow.labelArea.setText(lastWindow.label[0]);
//        }
//        if (HW8Logic.checkWinLines(HW8Logic.DOT_O)) {
//            lastWindow.labelArea.setText(lastWindow.label[1]);
//        }
//        lastWindow.setVisible(true);
//    }

    @Override
    public void callingBack(String result) {
        System.out.println(result);
        JOptionPane.showMessageDialog(this,
                String.format("<html><h2>Result game</h2><i> %s </i>", result));
    }
    


}
