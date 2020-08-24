package mainHW8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HW8BattleField extends JPanel {
    private HW8GameWindow gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public HW8BattleField(HW8GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });
    }

    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;

        if(!HW8Logic.isFinished){
            HW8Logic.humanTurn(cellX, cellY);
        }

        repaint();
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;


        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(!isInit){
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;

        //рисование сетки
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellWidth;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellHeight;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (HW8Logic.map[i][j] == HW8Logic.DOT_X){
                    drawX(g, j, i);
                }
                if (HW8Logic.map[i][j] == HW8Logic.DOT_O){
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawWinLine(Graphics g) {
        int x = HW8Logic.winCx;
        int y = HW8Logic.winCy;
        int x2 = HW8Logic.winCx + HW8Logic.winVx * (winningLength - 1);
        int y2 = HW8Logic.winCy + HW8Logic.winVy * (winningLength - 1);
        ((Graphics2D) g).setStroke(new BasicStroke(10));

        g.setColor(Color.GREEN);
        g.drawLine(cellWidth * x + cellWidth / 2, cellHeight * y + cellHeight / 2,
                cellWidth * x2 + cellWidth / 2, cellHeight * y2 + cellHeight / 2);
    }

    private void drawX(Graphics g, int x, int y){
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellWidth * x, cellHeight * y, cellWidth * (x + 1), cellHeight * (y + 1));
        g.drawLine(cellWidth * x, cellHeight * (y + 1), cellWidth * (x + 1), cellHeight * y);
    }

    private void drawO(Graphics g, int x, int y){
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawOval(cellWidth * x, cellHeight * y, cellWidth * 1, cellHeight * 1);
    }
}

