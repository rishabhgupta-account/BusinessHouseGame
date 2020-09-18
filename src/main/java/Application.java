/*

CreatedBy : Rishabh Gupta
EmailId: rishabh692gupta@gmail.com
Compiled and Tested In : JDK11 and Gradle 6
 */


public class Application {

    public static void main(String[] args) {


        BusinessHouseGame game = new BusinessHouseGame();
        String result = game.play(new int[]{2, 2, 1, 4, 2, 3, 4, 1, 3, 2, 2, 7, 4, 7, 2, 4, 4, 2, 2, 2, 2}, 3);

        System.out.println(result);

    }
}
