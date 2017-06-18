
import java.util.Objects;
import java.util.Random;

public class sudoku {
    public static void main(String[] args) {
        sudokuMap sm = new sudokuMap();
        sm.visualMap();
    }
}

class sudokuMap {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    private int dimension = 9;
    private String[][] map = new String[dimension][dimension];

    //Genera un mapa de sudoku
    sudokuMap() {
        generateMap();
    }

    //Muestra el mapa del sudoku de una forma más humana
    public void visualMap() {
        System.out.println();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(map[i][j] + " ");
                if (j == 2 || j == 5 || j == 8)
                    System.out.print("  ");
            }
            System.out.println();
            if (i == 2 || i == 5 || i == 8)
                System.out.println();
        }
    }

    public void generateMap() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Random random = new Random();
                String number = checkNumber(String.valueOf(random.nextInt(9) + 1), 0, 0);

                map[i][j] = number;
                //String.valueOf(random.nextInt(9) + 1);
                //i + "-" + j
            }
        }
    }

    //wrong
    private String checkNumber(String currentNumber, int posX, int posY) {
        for (int l = 0; l < dimension; l++) {

            for (int i = 0; i < dimension; i++) {
                if (Objects.equals(map[l][i], currentNumber)) {
                    map[l][i] = ">" + map[l][i];
                }
            }
            for (int i = 0; i < dimension; i++) {
                if (Objects.equals(map[i][l], currentNumber)) {
                    map[i][l] = ">" + map[i][l];
                }
            }
        }
        return currentNumber;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }
}