import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    private static int attempts;
    private int randomNumber;
    private int maxNumber;
    private static int totalGames = 0;
    private static int bestAttempt = Integer.MAX_VALUE;
    private static int totalAttempts = 0;

    public  NumberGame(int maxNumber){
        this.maxNumber = maxNumber;
        Random r = new Random();
        this.randomNumber = r.nextInt(maxNumber)+1;
        this.attempts = 0;
    }

    public void game(){
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        while(guess!=randomNumber){
            System.out.println("Enter your number between 1 to "+maxNumber+" : ");
            try{
                guess = Integer.parseInt(sc.nextLine());
                attempts++;
                if (guess<randomNumber){
                    System.out.println("Tow low!!");
                } else if (guess>randomNumber) {
                    System.out.println("Too high!!");
                }else {
                    System.out.println("Congratulations, you guessed the correct number in "+attempts+" attempts.");
                    totalGames++;
                    totalAttempts+=attempts;
                    if(attempts<bestAttempt){
                        bestAttempt = attempts;
                    }
                }

            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please input valid number.");
            }
        }
    }

    public static boolean askToPlayAgain(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play again(yes or no): ");
        String response = sc.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    public static int askForMaxNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the maximum number:");
        int maxNumber = 100;
        try{
            maxNumber = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Enter valid number, setting it to 100.");
        }
        return maxNumber;
    }

    public static void displayStatistics(){
        if (totalGames>0){
            System.out.println("Total games played: "+totalGames);
            System.out.println("Total attempts made: "+attempts);
            System.out.println("Average attempts per game: "+(float)(totalGames/attempts));
            System.out.println("Your best attempt is: "+bestAttempt);
        }else{
            System.out.println("No games played yet.");
        }
    }

    public static void main(String[] args) {

        do{
            int maxNumber = askForMaxNumber();
            NumberGame ng = new NumberGame(maxNumber);
            ng.game();

        }while(askToPlayAgain());
        displayStatistics();
        System.out.println("Thankyou for playing the game.");
    }
}
