import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

class HelloWorld {
    public static void main(String[] args) {
      ArrayList<Integer> calories = new ArrayList<Integer>();
      BufferedReader reader;
      try {
        int elfCalories = 0;
        reader = new BufferedReader(new FileReader("adv-2022-day-1"));
        String line = reader.readLine();
        while(line != null){
          System.out.println(line);
          if (line.isEmpty()) {
            calories.add(elfCalories);
            elfCalories = 0;
          }else{
            elfCalories = elfCalories + Integer.parseInt(line); 
          }
          line = reader.readLine();
        }
        int size = calories.size();
        int maxCalories =  Collections.max(calories);
        int indexOfMostCalorieElf = calories.indexOf(maxCalories) + 1 ;
        System.out.println("Size of arraylist: "+size);
        System.out.println("Elf with most calories: "+indexOfMostCalorieElf+"th elf with "+maxCalories);
        System.out.println("arrays:"+calories);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
