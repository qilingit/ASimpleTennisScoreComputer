import java.security.InvalidParameterException;

public class TennisGame {
    static Player playerA = new Player("Player A", 0, false);
    static Player playerB = new Player("Player B", 0, false);

    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();

        System.out.println("Game 1: ABABAA");
        tennisGame.tennisScoreComputer("ABABAA");
        tennisGame.newGame();

        System.out.println("Game 2: AAAA");
        tennisGame.tennisScoreComputer("AAAA");
        tennisGame.newGame();

        System.out.println("Game 3: AAABBBABAA");
        tennisGame.tennisScoreComputer("AAABBBABAA");
        tennisGame.newGame();

        System.out.println("Game 4: AAABBBABAA");
        tennisGame.tennisScoreComputer("AAABBBABBB");
        tennisGame.newGame();

        System.out.println("Game 5: ABABBABABB");
        tennisGame.tennisScoreComputer("ABABBABABB");
        tennisGame.newGame();

        System.out.println("Game 6: ABABAB");
        tennisGame.tennisScoreComputer("ABABAB");
        tennisGame.newGame();
    }

    public void tennisScoreComputer(String playersWinOrder) {
        if (playersWinOrder == null || playersWinOrder.isBlank() || (!playersWinOrder.matches("[AB]+"))) {
            throw new InvalidParameterException("Parameter is not valid, can only contain \"A\" or \"B\", must match the regex [AB]+");
        }

        for (int i = 0; i < playersWinOrder.length(); i++) {
            // When the two players both have 40 points
            if (playerA.getPoint() == 40 && playerA.getPoint() == playerB.getPoint()) {
                if (!playerA.getIsAdvantage() && !playerB.getIsAdvantage()) { // Game in deuce
                    if (playersWinOrder.charAt(i) == 'A') {
                        playerA.setAdvantage(true);
                    } else {
                        playerB.setAdvantage(true);
                    }
                } else if (playerA.getIsAdvantage()) {
                    if (playersWinOrder.charAt(i) == 'A') {

                        System.out.println("Player A wins the game\n");
                        return;
                    } else {
                        playerA.setAdvantage(false); // Game back to deuce
                    }
                } else {
                    if (playersWinOrder.charAt(i) == 'B') {

                        System.out.println("Player B wins the game\n");
                        return;
                    } else {
                        playerB.setAdvantage(false); // Game back to deuce
                    }
                }
            } else {
                // For player A
                if (playersWinOrder.charAt(i) == 'A') {
                    if (playerA.getPoint() < 30) {
                        playerA.setPoint(playerA.getPoint() + 15);
                    } else if (playerA.getPoint() == 30) {
                        playerA.setPoint(playerA.getPoint() + 10);
                    } else {
                        System.out.println("Player A wins the game\n");
                        return;
                    }
                }

                // For player B
                if (playersWinOrder.charAt(i) == 'B') {
                    if (playerB.getPoint() < 30) {
                        playerB.setPoint(playerB.getPoint() + 15);
                    } else if (playerB.getPoint() == 30) {
                        playerB.setPoint(playerB.getPoint() + 10);
                    } else {
                        System.out.println("Player A wins the game\n");
                        return;
                    }
                }
            }
            printGameStatus(playersWinOrder.charAt(i));
            System.out.println("Player A: " + playerA.getPoint() + " / Player B: " + playerB.getPoint());
        }
    }

    private void printGameStatus(char player) {
        if (player == 'A') {
            System.out.print(playerA.getName() + " wins, advantage: " + playerA.getIsAdvantage() + ", ");
        } else if (player == 'B') {
            System.out.print(playerB.getName() + " wins, advantage: " + playerB.getIsAdvantage() + ", ");
        }
    }

    public void newGame() {
        playerA.setPoint(0);
        playerA.setAdvantage(false);
        playerB.setPoint(0);
        playerB.setAdvantage(false);
    }
}