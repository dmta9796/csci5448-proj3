package tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import automobiles.*;
import ledger.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.ArrayEquals;
import users.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUserBehavior{
    @Test
    public void testCasualLength(){
        BuyBehavior action = new Casual();
        User user = new User("casualDanny",action);
        List<RentRequest> request = user.rentCarReq();
        int len = request.size();
        try {
            assertEquals(1,len);
            System.out.println("Casual number of requests tested successfully");
        } catch(AssertionError e){
            System.out.println("Casual number of requests tested in error");
        }
    }

    @Test
    public void testBusinessLength(){
        BuyBehavior action = new Business();
        User user = new User("BusinessDanny",action);
        List<RentRequest> request = user.rentCarReq();
        int len = request.size();

        try {
            assertEquals(3,len);
            System.out.println("Business number of requests tested successfully");
        } catch(AssertionError e){
            System.out.println("Business number of requeststested in error");
        }
    }

    @Test
    public void testRegularLength(){
        final BuyBehavior action = Mockito.spy(new Regular());
        when(action.makeRandom()).thenReturn(new FakeRandom());


        User user = new User("RegularDanny",action);
        List<RentRequest> request = user.rentCarReq();
        int len = request.size();
        assertEquals(1,len);
        try {
            assertEquals(1,len);
            System.out.println("Regular number of requests tested successfully");
        } catch(AssertionError e){
            System.out.println("Regular number of requests tested in error");
        }
    }
    @Test
    public void SimCustomerChoice(){
        final BuyBehavior action = Mockito.spy(new Regular());
        when(action.makeRandom()).thenReturn(new FakeRandom(1));


        User user = new User("PickyDanny",action);
        List<RentRequest> request = user.rentCarReq();
        List<RentRequest> expected = new ArrayList<RentRequest>();
        expected.add(new RentRequest(4,1,true,true));
        expected.add(new RentRequest(4,1,true,true));
        List<RentRequest> actual = request;
        try {
            assertEquals(actual.size(),expected.size());
            for(int i = 0; i<actual.size();i++) {
                RentRequest a = actual.get(i);
                RentRequest b = expected.get(i);
                assertEquals(a.carSeats, b.carSeats);
                assertEquals(a.duration, b.duration);
                assertEquals(a.satRadio, b.satRadio);
                assertEquals(a.gps, b.gps);
            }

            System.out.println("request features fields check tested successfully");
        } catch(AssertionError e){
            System.out.println("request features fields check tested in error");
        }
    }
    @Test
    public void BaseModelRequest(){
        final BuyBehavior action = Mockito.spy(new Regular());
        when(action.makeRandom()).thenReturn(new FakeRandom(0));

        User user = new User("CheapDanny",action);
        List<RentRequest> request = user.rentCarReq();
        List<RentRequest> expected = new ArrayList<RentRequest>();
        expected.add(new RentRequest(3,0,false,false));
        List<RentRequest> actual = request;
        try {
            assertEquals(actual.size(),expected.size());
            for(int i = 0; i<actual.size();i++) {
                RentRequest a = actual.get(i);
                RentRequest b = expected.get(i);
                assertEquals(a.carSeats, b.carSeats);
                assertEquals(a.duration, b.duration);
                assertEquals(a.satRadio, b.satRadio);
                assertEquals(a.gps, b.gps);
            }
            System.out.println("request base fields check tested successfully");
        } catch(AssertionError e){
            System.out.println("request base fields check tested in error");
        }
    }
    @Test
    public void CheckType(){
        final BuyBehavior action = Mockito.spy(new Regular());
        when(action.makeRandom()).thenReturn(new FakeRandom(0));

        User user = new User("CheapDanny",action);
        List<RentRequest> request = user.rentCarReq();
        List<RentRequest> expected = new ArrayList<RentRequest>();
        expected.add(new RentRequest(3,0,false,false));
        List<RentRequest> actual = request;
        try {
            assertEquals(actual.size(),expected.size());
            for(int i = 0; i<actual.size();i++) {
                RentRequest a = actual.get(i);
                RentRequest b = expected.get(i);
                assertThat(a, instanceOf(RentRequest.class));
                assertThat(b, instanceOf(RentRequest.class));
            }
            System.out.println("request type check tested successfully");
        } catch(AssertionError e){
            System.out.println("request type check tested in error");
        }
    }
}

// blog for mocks
// http://jasonjl.me/blog/2014/11/03/testing-the-undeterministic-with-mocking/
// http://tutorials.jenkov.com/java-unit-testing/stub-mock-and-proxy-testing.html
//

// Mockito library for mocks
// https://stackoverflow.com/questions/40800467/how-to-test-method-which-uses-random-but-cant-pick-the-same-number-twice
// https://www.vogella.com/tutorials/Mockito/article.html
//https://dzone.com/articles/a-guide-to-mocking-with-mockitos
// https://stackoverflow.com/questions/53110890/how-to-test-a-method-that-uses-random-without-arguments-and-return-value-usi


// pesky equality issue between objects.  (ES 6 is alot better with handling the issue without libraries)
// https://dzone.com/articles/comparing-two-objects-using-assertareequal

//resolve a warning about illegal reflective access
//