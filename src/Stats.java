public class Stats {

    public String playerName;
    public static int wins = 0;
    public static int losses = 0;
    public static int handsDealt = 0;
    public static int timesHit = 0;
    public static int timesDoubledDown = 0;
    public static int handsSplit = 0;

    public Stats(String playerName) {
        this.playerName = playerName;
    }


    public static void win() {wins++;}
    public static void loss() {losses++;}
    public static void handDealt() {handsDealt++;}
    public static void hit() {timesHit++;}
    public static void doubleDown() {timesDoubledDown++;}
    public static void handSplit() {handsSplit++;}

    public void printStats() {
        System.out.println("--" + playerName + "'s Stats--");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Hands Dealt: " + handsDealt);
        System.out.println("Times Hit: " + timesHit);
        System.out.println("Times Doubled Down: " + timesDoubledDown);
        System.out.println("Hands Split: " + handsSplit);
    }





}
