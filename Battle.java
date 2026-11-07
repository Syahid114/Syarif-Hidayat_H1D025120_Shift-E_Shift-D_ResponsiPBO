package ResponsiPBO;

public class Battle {
    private int roundNumber;
    private String humanMove;
    private String computerMove;
    private String result;

    public Battle() {
        this.roundNumber = 0;
        this.result = "BELUM DIMULAI";
    }
    public void playRound(Player human, Player computer, MoveChooser humanChooser, MoveChooser computerChooser) {
        this.roundNumber++;
        System.out.println("\n========== RONDE " + this.roundNumber + " ==========");
        this.humanMove = humanChooser.chooseMove();
        this.computerMove = computerChooser.chooseMove();
        System.out.println(human.getName() + " memilih: " + this.humanMove);
        System.out.println(computer.getName() + " memilih: " + this.computerMove);
        determineWinner(human, computer);
        System.out.println("Hasil ronde: " + this.result);
    }
    public void determineWinner(
            Player human, Player computer) {
        if (this.humanMove.equals(this.computerMove)) {
            this.result = "SERI";
            human.recordResult("SERI");
            computer.recordResult("SERI");
        } else if (
                (this.humanMove.equals("Batu")
                        && this.computerMove.equals("Gunting"))
                        || (this.humanMove.equals("Kertas")
                        && this.computerMove.equals("Batu"))
                        || (this.humanMove.equals("Gunting")
                        && this.computerMove.equals("Kertas"))
        ) {
            this.result = "PEMAIN MENANG";
            human.recordResult("MENANG");
            computer.recordResult("KALAH");
        } else {
            this.result = "KOMPUTER MENANG";
            human.recordResult("KALAH");
            computer.recordResult("MENANG");
        }
    }
    public int getRoundNumber() {
        return this.roundNumber;
    }
    public String getResult() {
        return this.result;
    }
}