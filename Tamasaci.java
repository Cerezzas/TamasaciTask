package TamasaciTask;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tamasaci {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Integer [][] array = {{1,2,3},
                              {4,5,6},
                              {7,8,9}};


        System.out.println("Do you want to take a seat?");
        String answer = sc.nextLine();

        ArrayList<String> takenSeats = new ArrayList<>();
        Random random = new Random();

        while (answer.equalsIgnoreCase("Yes")) {

            if(takenSeats.size()==9){
                System.out.println("All seats are taken. There is no available seat");
                break;
            }

            int row = random.nextInt(array.length); // pick random position for 1st dimension (row)
            int column = random.nextInt(array[row].length); // pick random position for 2nd dimension (column) for previously selected row
            String selectedSeat = row + "," + column;
            if (takenSeats.contains(selectedSeat)) {
                continue;
            }
            takenSeats.add(selectedSeat);
            System.out.println("Your seat is: " + array[row][column]);

            System.out.println("Do you want to take another seat?");
            answer = sc.nextLine();


        }

        if (answer.equalsIgnoreCase("No")) {
            System.exit(0);
        }

        System.out.println("bye!");
        sc.close();


    }
}
