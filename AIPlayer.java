package ResponsiPBO;

public class AIPlayer extends Player implements MoveChooser, StatViewer {

    private int choiceNumber;
    public AIPlayer (String name, String playerId) {
        super(name, playerId);
        this.choiceNumber = 0;
    }
    @Override
    public String chooseMove() {
        String move;
        if (choiceNumber == 0) {
            move = "Batu";
        } else if (choiceNumber == 1) {
            move = "Kertas";
        } else {
            move = "Gunting";
        }
        choiceNumber++;
        if (choiceNumber == 3) {
            choiceNumber = 0;
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
        System.out.println("\n=== STATISTIK KOMPUTER ===");
        super.showStats();
    }
}