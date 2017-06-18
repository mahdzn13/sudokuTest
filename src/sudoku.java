import java.util.Arrays;
import java.util.Random;

public class sudoku {
    public static void main(String[] args) {
        sudokuMap sm = new sudokuMap();
        String[][] sMap = sm.getMap();
        System.out.println(sMap[0][0]);
        System.out.println(Arrays.deepToString(sMap));
        sm.visualMap();
    }
}

class sudokuMap{

    private int dimension = 9;
    private String[][] map = new String[dimension][dimension];

    //Genera un mapa de sudoku
    sudokuMap(){
        generateMap();
    }

    //Muestra el mapa del sudoku de una forma más humana
    public void visualMap(){
        System.out.println();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(map[i][j] + " ");
                if ( j == 2 || j == 5 || j == 8)
                System.out.print("  ");
            }
            System.out.println();
            if ( i == 2 || i == 5 || i == 8)
                System.out.println();
        }
    }
    public void generateMap(){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Random random = new Random();
                map[i][j] = i + "-" + j;
                //String.valueOf(random.nextInt(9) + 1);
                //i + "-" + j
            }
        }
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