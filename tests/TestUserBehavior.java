package tests;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import users.*;

import java.util.List;
import java.util.Random;

public class TestUserBehavior{
    Random rand;
    @Before
    public void deterministicRandom(){
        rand = new TestRandom();

    }
    @Test
    public void testCasualLength(){
        BuyBehavior action = new Casual();
        User user = new User("casualDanny",action);
        List<RentRequest> request = user.rentCarReq();
        int len = request.size();
        assertEquals(1,len);
    }

    @Test
    public void testBusinessLength(){
        BuyBehavior action = new Business();
        User user = new User("BusinessDanny",action);
        List<RentRequest> request = user.rentCarReq();
        int len = request.size();
        assertEquals(3,len);
    }

//    @Test
//    public void testRegularLength(){
//        BuyBehavior action = new Regular();
//        User user = new User("RegularDanny",action);
//        List<RentRequest> request = user.rentCarReq();
//        int len = request.size();
//        assertEquals(1,len);
//    }
}

// blog for mocks
// http://jasonjl.me/blog/2014/11/03/testing-the-undeterministic-with-mocking/
// http://tutorials.jenkov.com/java-unit-testing/stub-mock-and-proxy-testing.html
//

// Mockito library for mocks
// https://stackoverflow.com/questions/40800467/how-to-test-method-which-uses-random-but-cant-pick-the-same-number-twice
// https://www.vogella.com/tutorials/Mockito/article.html