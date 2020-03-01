package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRandom extends Random{
    int sequentialNum = 1;

    public TestRandom(){
        super();
    }

    public int nextInt(){
        return sequentialNum;
    }

}
