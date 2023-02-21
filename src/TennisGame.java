import java.security.InvalidParameterException;

public class TennisGame {
    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();

        System.out.println("Game 1: ABABAA");
        tennisGame.tennisScoreComputer("ABABAA");

        System.out.println("Game 2: AAAA");
        tennisGame.tennisScoreComputer("AAAA");

        System.out.println("Game 3: AAABBBABAA");
        tennisGame.tennisScoreComputer("AAABBBABAA");

        System.out.println("Game 4: AAABBBABAA");
        tennisGame.tennisScoreComputer("AAABBBABBB");

        System.out.println("Game 5: ABABBABABB");
        tennisGame.tennisScoreComputer("ABABBABABB");
    }

    public void tennisScoreComputer(String playersWinOrder) {
        int playerAScore = 0, playerBScore = 0;
        boolean playerAIsAdvantage = false, playerBIsAdvantage = false;
        if (playersWinOrder == null || playersWinOrder.isBlank() || (!playersWinOrder.matches("[AB]+"))) {
            throw new InvalidParameterException("Parameter is not valid, can only contain \"A\" or \"B\", must match the regex [AB]+");
        }
        for (int i = 0; i < playersWinOrder.length(); i++) {
            printWhoWins(playersWinOrder.charAt(i));
            // When the two players both have 40 points
            if (playerAScore == 40 && playerAScore == playerBScore) {
                if (!playerAIsAdvantage && !playerBIsAdvantage) { // Game in deuce
                    if (playersWinOrder.charAt(i) == 'A') {
                        playerAIsAdvantage = true;
                    } else {
                        playerBIsAdvantage = true;
                    }
                } else if (playerAIsAdvantage) {
                    if (playersWinOrder.charAt(i) == 'A') {
                        System.out.println("Player A wins the game\n");
                        return;
                    } else {
                        playerAIsAdvantage = false; // Game back to deuce
                    }
                } else {
                    if (playersWinOrder.charAt(i) == 'B') {
                        System.out.println("Player B wins the game\n");
                        return;
                    } else {
                        playerBIsAdvantage = false; // Game back to deuce
                    }
                }
            } else {
                // For player A
                if (playersWinOrder.charAt(i) == 'A') {
                    if (playerAScore < 30) {
                        playerAScore += 15;
                    } else if (playerAScore == 30) {
                        playerAScore += 10;
                    } else {
                        System.out.println("Player A wins the game\n");
                        return;
                    }
                }

                // For player A
                if (playersWinOrder.charAt(i) == 'B') {
                    if (playerBScore < 30) {
                        playerBScore += 15;
                    } else if (playerBScore == 30) {
                        playerBScore += 10;
                    } else {
                        System.out.println("Player B wins the game\n");
                        return;
                    }
                }
            }

            System.out.println("Player A: " + playerAScore + " / Player B: " + playerBScore);
        }
    }

    private void printWhoWins(char player) {
        if (player == 'A') {
            System.out.print("Player A wins, ");
        } else if (player == 'B') {
            System.out.print("Player B wins, ");
        }
    }
}