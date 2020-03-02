package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRandom extends Random{
    int sequentialNum = 1;
    boolean sequentialBool = true;

    public TestRandom(){

    }

    public int nextInt(){
        return 0;
    }
    public int nextInt(int bound){
        return 0;
    }
    public boolean nextBoolean(){
        return true;
    }

}
