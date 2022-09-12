import attractions.Attraction;
import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.Stall;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    ThemePark myThemePark;
    CandyflossStall myCandyStall;
    TobaccoStall myTobaccoStall;
    Playground myPlayground;
    Visitor myVisitor;
    @Before
    public void before(){
        myPlayground = new Playground("Keith Memorial Playground", 6);
        myCandyStall = new CandyflossStall("Mar Memorial Candy Floss", "Ceri", ParkingSpot.A4, 7);
        myTobaccoStall = new TobaccoStall("James Memorial Tobbaconist", "Tony", ParkingSpot.A3, 5);
        ArrayList<Attraction> testAttracts = new ArrayList<>(Collections.singleton(myPlayground));
        ArrayList<Stall> testStalls = new ArrayList<>();
        testStalls.add(myCandyStall);
        testStalls.add(myTobaccoStall);
        myThemePark = new ThemePark(testAttracts, testStalls);
        myVisitor = new Visitor(14, 140.0, 30.0);
    }
    @Test
    public void canReturnAllAllowedList(){
        assertEquals(2, myThemePark.getAllAllowedForVisitor(myVisitor).size());
    }
}
