package ResponsiPBO;

import java.util.Scanner;
public class Game {
    private Scanner scanner;
    private HumanP humanP;
    private AIPlayer aiPlayer;
    private Battle battle;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }
    public void startGame() {
        System.out.println("==============================");
        System.out.println("     ROCK PAPER SCISSORS");
        System.out.println("==============================");
        System.out.print("Masukkan nama pemain: ");
        String playerName = scanner.nextLine();
        if (playerName.equals("")) {
            playerName = "Player";
        }
        boolean playAgain = true;
        while (playAgain) {
            humanP = new HumanP (playerName, "HUMAN-001", scanner);
            aiPlayer = new AIPlayer("Computer", "CPU-001");
            battle = new Battle();
            playMatch();
            showFinalResult();
            System.out.print("\nMain lagi? (y/n): ");
            String answer = scanner.nextLine();
            if (answer.equals("y") || answer.equals("Y")) {
                playAgain = true;
            } else {
                playAgain = false;
            }
        }
        System.out.println("\nTerima kasih sudah bermain!");
    }
    public void playMatch() {
        int round = 1;
        while (round <= Player.TOTAL_ROUNDS) {
            MoveChooser humanChooser = humanP;
            MoveChooser computerChooser = aiPlayer;
            battle.playRound(humanP, aiPlayer, humanChooser, computerChooser);
            round++;
        }
    }
    public void showFinalResult() {
        System.out.println("\n========== HASIL AKHIR ==========");
        System.out.println(humanP.getName() + " : " + humanP.getWins());
        System.out.println(aiPlayer.getName() + " : " + aiPlayer.getWins());
        if (humanP.getWins() > aiPlayer.getWins()) {
            System.out.println("PEMAIN MENANG!");
        } else if (humanP.getWins() < aiPlayer.getWins()) {
            System.out.println("KOMPUTER MENANG!");
        } else {
            System.out.println("PERTANDINGAN SERI!");
        }
        StatViewer humanStats = humanP;
        StatViewer computerStats = aiPlayer;
        humanStats.showStats();
        computerStats.showStats();
    }
}