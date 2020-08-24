package mainHW8;

import javax.swing.*;
import java.awt.*;

public class HW8SettingWindow extends JFrame {
    private HW8GameWindow gameWindow;

    private static final int WINDOW_POS_X = HW8GameWindow.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y = HW8GameWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_HEIGHT = HW8GameWindow.WINDOW_HEIGHT - 100;
    private static final int WINDOW_WIDTH = HW8GameWindow.WINDOW_WIDTH - 100;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    static final int GAME_MODE_HUMAN_VS_AI = 0;
    static final int GAME_MODE_HUMAN_VS_HUMAN = 1;

    private JRadioButton jrbHumanVsAi;
    private JRadioButton jrbHumanVsHuman;
    private ButtonGroup bgGameMode;

    private JSlider jsFieldSize;
    private JSlider jsWinningLength;

    public HW8SettingWindow(HW8GameWindow gameWindow) {
        this.gameWindow = gameWindow;



        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe setting");

        setLayout(new GridLayout(8,1));

        add(new JLabel("Choose game mode:"));
        jrbHumanVsAi = new JRadioButton("HumanVsAi", true);
        jrbHumanVsHuman = new JRadioButton("HumanVsHuman");
        add(jrbHumanVsAi);
        add(jrbHumanVsHuman);
        bgGameMode = new ButtonGroup();
        bgGameMode.add(jrbHumanVsAi);
        bgGameMode.add(jrbHumanVsHuman);

        add(new JLabel("Choose fields size:"));

        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        jsFieldSize.setMajorTickSpacing(1);
        jsFieldSize.setPaintTicks(true);
        jsFieldSize.setPaintLabels(true);
        add(jsFieldSize);

        add(new JLabel("Choose winning length:"));

        jsWinningLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        jsWinningLength.setMajorTickSpacing(1);
        jsWinningLength.setPaintTicks(true);
        jsWinningLength.setPaintLabels(true);
        add(jsWinningLength);

        //обработчики событий
        jsFieldSize.addChangeListener(e -> {
            jsWinningLength.setMaximum(jsFieldSize.getValue());
        });

        JButton buttonStartGame = new JButton("Start new game");
        add(buttonStartGame);

        buttonStartGame.addActionListener(e -> {
            int mode;
            if (jrbHumanVsAi.isSelected()){
                mode = GAME_MODE_HUMAN_VS_AI;
            } else {
                mode = GAME_MODE_HUMAN_VS_HUMAN;
            }

            int fieldSize = jsFieldSize.getValue();
            int winningLength = jsWinningLength.getValue();

            HW8Logic.SIZE = fieldSize;
            HW8Logic.DOTS_TO_WIN = winningLength;
            HW8Logic.initMap();
            HW8Logic.isFinished = false;

            gameWindow.startNewGame(mode, fieldSize, winningLength);

            setVisible(false);
        });

        setVisible(false);

    }
}
