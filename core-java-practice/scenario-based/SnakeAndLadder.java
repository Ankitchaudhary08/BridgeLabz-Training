public class SnakeAndLadder {

    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;

    public static void main(String[] args) {

        int player1Pos = 0;
        int player2Pos = 0;

        int diceCount = 0;
        int currentPlayer = 1;

        System.out.println("Welcome to Snake and Ladder Game 🎲");

        while (player1Pos < 100 && player2Pos < 100) {

            int die = rollDie();
            int option = checkOption();
            diceCount++;

            System.out.println("\nPlayer " + currentPlayer + " rolled: " + die);

            if (currentPlayer == 1) {
                player1Pos = movePlayer(player1Pos, die, option);
                System.out.println("Player 1 position: " + player1Pos);

                if (player1Pos == 100) {
                    System.out.println("\n🏆 Player 1 wins!");
                    break;
                }

                if (option != LADDER) {
                    currentPlayer = 2;
                }

            } else {
                player2Pos = movePlayer(player2Pos, die, option);
                System.out.println("Player 2 position: " + player2Pos);

                if (player2Pos == 100) {
                    System.out.println("\n🏆 Player 2 wins!");
                    break;
                }

                if (option != LADDER) {
                    currentPlayer = 1;
                }
            }
        }

        System.out.println("\nTotal dice rolls: " + diceCount);
    }

    // UC1: Roll Die
    static int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    // UC2: Check Option
    static int checkOption() {
        return (int) (Math.random() * 3);
    }

    // UC3 & UC4: Player Movement
    static int movePlayer(int position, int die, int option) {

        if (option == NO_PLAY) {
            return position;
        }

        if (option == LADDER) {
            if (position + die <= 100) {
                position += die;
            }
        }

        if (option == SNAKE) {
            position -= die;
            if (position < 0) {
                position = 0;
            }
        }

        return position;
    }
}
