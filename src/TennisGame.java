import java.security.InvalidParameterException;

public class TennisGame {
    public static void tennisScoreComputer(String playersWinOrder) {
        int playerAScore = 0, playerBScore = 0;
        boolean playerAIsAdvantage = false, playerBIsAdvantage = false;
        if (playersWinOrder == null || playersWinOrder.isBlank() || (!playersWinOrder.matches("[AB]+"))) {
            throw new InvalidParameterException("Parameter is not valid, can only contain \"A\" or \"B\", must match the regex [AB]+");
        }
        for (int i = 0; i < playersWinOrder.length(); i++) {
            printWhoWins(playersWinOrder.charAt(i));
            // When the two players both have 40 points
            if (playersBothHave40(playerAScore, playerBScore)) {
                if (!playerAIsAdvantage && !playerBIsAdvantage) {
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
                        playerAIsAdvantage = false;
                    }
                } else {
                    if (playersWinOrder.charAt(i) == 'B') {
                        System.out.println("Player B wins the game\n");
                        return;
                    } else {
                        playerBIsAdvantage = false;
                    }
                }
            } else {
                // For player A
                if (playerAScore < 30) {
                    if (playersWinOrder.charAt(i) == 'A') {
                        playerAScore += 15;
                    }
                } else if (playerAScore == 30){
                    if (playersWinOrder.charAt(i) == 'A') {
                        playerAScore += 10;
                    }
                } else if (playerAScore == 40) {
                    if (playersWinOrder.charAt(i) == 'A') {
                        System.out.println("Player A wins the game\n");
                        return;
                    }
                }

                // For player B
                if (playerBScore < 30) {
                    if (playersWinOrder.charAt(i) == 'B') {
                        playerBScore += 15;
                    }
                } else if (playerBScore == 30){
                    if (playersWinOrder.charAt(i) == 'B') {
                        playerBScore += 10;
                    }
                } else if (playerBScore == 40) {
                    if (playersWinOrder.charAt(i) == 'B') {
                        System.out.println("Player B wins the game\n");
                        return;
                    }
                }
            }

            System.out.println("Player A: " + playerAScore + " / Player B: " + playerBScore);
        }
    }
    public static void main(String[] args) {
        System.out.println("Game 1: ABABAA");
        tennisScoreComputer("ABABAA");

        System.out.println("Game 2: AAAA");
        tennisScoreComputer("AAAA");

        System.out.println("Game 3: AAABBBABAA");
        tennisScoreComputer("AAABBBABAA");

        System.out.println("Game 4: AAABBBABAA");
        tennisScoreComputer("AAABBBABBB");

        System.out.println("Game 5: ABABBABABB");
        tennisScoreComputer("ABABBABABB");
    }

    private static boolean playersBothHave40(int scoreA, int scoreB) {
        return scoreA == 40 && scoreA == scoreB;
    }

    private static void printWhoWins(char player) {
        if (player == 'A') {
            System.out.print("Player A wins, ");
        } else if (player == 'B') {
            System.out.print("Player B wins, ");
        }
    }
}