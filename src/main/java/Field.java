import java.io.PrintStream;

/**
 * Created by kirill on 11/11/15.
 */
public class Field {
    private boolean[][] field;
    private static String DEAD = "o ";
    private static String ALIVE = "x ";

    public Field(int size) {
        field = new boolean[size][size];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] outerArr: field) {
            for (boolean el: outerArr) {
                sb.append(el ? ALIVE : DEAD);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void setAlive(int x, int y) {
        field[x][y] = true;
    }

    public void live() {
        boolean[][] newField = new boolean[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            boolean[] outerArr = field[i];
            for (int j = 0; j < outerArr.length; j++) {
                boolean[] neighbours = getNeighbours(i,j);
                int aliveNeighbours = getAliveNeighbours(neighbours);
                if (aliveNeighbours == 3) {newField[i][j] = true;}
                else if (aliveNeighbours == 2 && field[i][j] == true) {newField[i][j] = true;}
                else {newField[i][j] = false;}
            }
        }
        field = newField;
    }

    private int getAliveNeighbours(boolean[] neighbours) {
        int neighoursAlive = 0;
        for (boolean neighbour: neighbours) {
            if (neighbour) neighoursAlive++;
        }
        return neighoursAlive;
    }

    private boolean[] getNeighbours(int i, int j) {
        boolean[] neighbours = new boolean[8];
        int li = field.length;
        int lj = field[0].length;
        int iMinusOne =  (i - 1 + li) % li;
        int iPlusOne =  (i + 1 + li) % li;
        int jMinusOne = (j - 1 + lj) % lj;
        int jPlusOne = (j + 1 + lj) % lj;
        neighbours[0] = field[iMinusOne][jMinusOne];
        neighbours[1] = field[iMinusOne][j];
        neighbours[2] = field[iMinusOne][jPlusOne];

        neighbours[3] = field[i][jMinusOne];
        neighbours[4] = field[i][jPlusOne];

        neighbours[5] = field[iPlusOne][jMinusOne];
        neighbours[6] = field[iPlusOne][j];
        neighbours[7] = field[iPlusOne][jPlusOne];


        return neighbours;
    }

    public void liveAndOutput(int steps, int delayInSec, PrintStream out, Thread thread) throws InterruptedException {
        out.println(this);
        for (int i = 0; i < steps; i++) {
            thread.sleep(delayInSec * 1000);
            live();
            out.println(this);
        }
    }
}
