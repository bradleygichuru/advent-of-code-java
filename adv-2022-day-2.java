import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class AdvDay2 {

  static final int ROCK_SCORE = 1;
  static final int SCISSORS_SCORE = 3;
  static final int PAPER_SCORE = 2;
  static final int OUTCOME_SCORE_LOST = 0;
  static final int OUTCOME_SCORE_DRAW = 3;
  static final int OUTCOME_SCORE_WIN = 6;
  static final String ROCK_CHOICE = "X";
  static final String SCISSORS_CHOICE = "Z";
  static final String PAPER_CHOICE = "Y";
  static final String ROCK_OPPONENT_CHOICE = "A";
  static final String PAPER_OPPONENT_CHOICE = "B";
  static final String SCISSORS_OPPONENT_CHOICE = "C";

  public static void main(String[] args) {
    BufferedReader reader;
    try {

      int score = 0;
      reader = new BufferedReader(new FileReader("./adv-2022-day-2"));
      String line = reader.readLine();
      while (line != null) {

        String[] choices = line.split("\\s+");
        String opponentsChoice = choices[0];
        String myChoice = choices[1];
        System.out.println("my choice: "+myChoice); 
        if (myChoice.equals(ROCK_CHOICE)) {

          System.out.println("you chose rock");
          switch (opponentsChoice) {
            case ROCK_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_DRAW*2;
              break;
            case SCISSORS_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_WIN + ROCK_SCORE;
              System.out.println("won round");
              break;
            case PAPER_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_LOST ;
              break;
            default:
              break;
          }
        }
        if (myChoice.equals(PAPER_CHOICE)) {

          System.out.println("you chose paper");
          switch (opponentsChoice) {
            case ROCK_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_WIN + PAPER_SCORE;

              System.out.println("won round");
              break;
            case SCISSORS_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_LOST ;
              break;
            case PAPER_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_DRAW*2 ;
              break;
            default:
              break;
          }

        }
        if (myChoice.equals(SCISSORS_CHOICE)) {

          System.out.println("you chose scissors");
          switch (opponentsChoice) {
            case ROCK_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_LOST;
            case SCISSORS_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_DRAW*2 ;
              break;
            case PAPER_OPPONENT_CHOICE:
              score = score + OUTCOME_SCORE_WIN + SCISSORS_SCORE;

              System.out.println("won round");
              break;

            default:
              break;
          }
        }
        System.out.println(choices[0] + choices[1] + " scores: " + score);

        line = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
