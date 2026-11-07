package ResponsiPBO;

import java.util.Scanner;

public class HumanP extends Player implements MoveChooser, StatViewer {
    private Scanner scanner;
    public HumanP(String name, String playerId, Scanner scanner) {
        super(name, playerId);
        this.scanner = scanner;
    }
    @Override
    public String chooseMove() {
        String move = "";
        while (move.equals("")) {
            System.out.println("\nPilih gerakan:");
            System.out.println("1. Batu");
            System.out.println("2. Kertas");
            System.out.println("3. Gunting");
            System.out.print("Pilihan: ");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                move = "Batu";
            } else if (input.equals("2")) {
                move = "Kertas";
            } else if (input.equals("3")) {
                move = "Gunting";
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
        return move;
    }
    @Override
    public void recordResult(String result) {
        if (result.equals("MENANG")) {
            setWins(getWins() + 1);
        } else if (result.equals("KALAH")) {
            setLosses(getLosses() + 1);
        } else if (result.equals("SERI")) {
            setDraws(getDraws() + 1);
        }
    }
    @Override
    public void showStats() {
        System.out.println("\n=== STATISTIK PEMAIN ===");
        super.showStats();
    }
}