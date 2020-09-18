import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*

CreatedBy : Rishabh Gupta
EmailId: rishabh692gupta@gmail.com
Phone : 8826337690
Compiled and Tested In : JDK11 and Gradle 6
 */
public class BusinessHouseGameTest {

    private BusinessHouseGame businessHouseGame;

    @Before
    public void init() {
        businessHouseGame = new BusinessHouseGame();
    }


    //TestCase 1
    @Test
    public void testBusinessHouseGameWithMultipleInputs() {
        String result = businessHouseGame.play(new int[]{2, 2, 1, 4, 2, 3, 4, 1, 3, 2, 2, 7, 4, 7, 2, 4, 4, 2, 2, 2, 2}, 3);
        Assert.assertEquals(result, "Player-1 has total money 650 and asset of amount: 500\n" +
                "Player-2 has total money 750 and asset of amount: 300\n" +
                "Player-3 has total money 850 and asset of amount: 200\n" +
                "Balance at bank : 5750\n");
    }


    //TestCase 2
    @Test
    public void testBusinessHouseGameWithDifferentInputs() {
        String result = businessHouseGame.play(new int[]{2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1}, 3);
        Assert.assertEquals(result, "Player-1 has total money 1100 and asset of amount: 500\n" +
                "Player-2 has total money 600 and asset of amount: 0\n" +
                "Player-3 has total money 1150 and asset of amount: 0\n" +
                "Balance at bank : 5150\n");
    }


    //TestCase 1
    @Test
    public void testBusinessHouseGameWithSingleInput() {
        String result = businessHouseGame.play(new int[]{2, 2, 1}, 3);
        Assert.assertEquals(result, "Player-1 has total money 850 and asset of amount: 200\n" +
                "Player-2 has total money 950 and asset of amount: 0\n" +
                "Player-3 has total money 850 and asset of amount: 0\n" +
                "Balance at bank : 5350\n");
    }

}