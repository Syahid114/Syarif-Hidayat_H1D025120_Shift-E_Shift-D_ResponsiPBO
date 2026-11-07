package ResponsiPBO;

public abstract class Player {

    public static final int TOTAL_ROUNDS = 3;
    private String name;
    private int wins;
    private int losses;
    private int draws;
    private final String playerId;

    public Player(String name) {
        this(name, "PLAYER-001");
    }
    public Player(String name, String playerId) {
        this.name = name;
        this.playerId = playerId;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }
    public abstract String chooseMove();
    public abstract void recordResult(String result);
    public void showStats() {
        System.out.println("Nama   : " + this.name);
        System.out.println("ID     : " + this.playerId);
        System.out.println("Menang : " + this.wins);
        System.out.println("Kalah  : " + this.losses);
        System.out.println("Seri   : " + this.draws);
    }
    public String getName() {
        return this.name;
    }
    public int getWins() {
        return this.wins;
    }
    public int getLosses() {
        return this.losses;
    }
    public int getDraws() {
        return this.draws;
    }
    public String getPlayerId() {
        return this.playerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }
    public void setDraws(int draws) {
        this.draws = draws;
    }
}