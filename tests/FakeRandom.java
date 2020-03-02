package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeRandom extends Random{
    int sequentialNum = 0;
    boolean sequentialBool = true;

    public FakeRandom(){

    }
    public FakeRandom(int num){
        sequentialNum = num;
        sequentialBool = (num!=0);
    }

    public int nextInt(){
        return sequentialNum;
    }
    public int nextInt(int bound){
        return sequentialNum;
    }
    public boolean nextBoolean(){
        return sequentialBool;
    }

}
