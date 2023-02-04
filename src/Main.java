public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossAttackType = "";

    public static int[] heroesHealth = {270, 280, 260};
    public static int[] heroesDamage = {20, 15, 25};
    public static String[] heroesAttackType = {"phisical", "magic", "kinetic"};

    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatistic();
        while (!isGameFinished()){
            round();
        }

    }

    public static void printStatistic() {
        System.out.println("-------------" + roundNumber + "-------------");
        System.out.println("Boss health: " + bossHealth + " Damage:[" + bossDamage + "] ");
        for (int i = 0; i < heroesAttackType.length; i++) {
            System.out.println(heroesAttackType[i] + "Health: " + heroesHealth[i] + " Damage[" + heroesDamage + "]");
        }
        System.out.println();
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i]<=0){
                System.out.println("Boss won! ");
            }
            bossHealth = heroesHealth[i] - bossDamage;
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (bossHealth<=0){
                System.out.println("Heroes won! ");
            }
            heroesHealth[i] = bossHealth - heroesDamage[i];

        }
    }

    public static void round() {
        roundNumber++;
        bossHit();
        heroesHit();
        printStatistic();
    }

    public static Boolean isGameFinished() {
        if (bossHealth == 0) {
            System.out.println("Heroes won!");
            return true;
        }

        if (heroesHealth[0]<=0 && heroesHealth[1]<=0 && heroesHealth[2]<=0){
            System.out.println("Boss won!");
            return true;
        }
        return false;
    }
}