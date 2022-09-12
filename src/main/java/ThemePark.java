import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }
    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> result = new ArrayList<>();
        result.addAll(attractions);
        result.addAll(stalls);
        return result;
    }
    public void visit(Visitor visitor, Attraction attraction){
        attraction.incrementVisitCount();
        visitor.visitAttraction(attraction);
    }
    public HashMap<String, Integer> getAllReviews(){
        HashMap<String, Integer> result = new HashMap<>();
        ArrayList<IReviewed> allReviews = getAllReviewed();
        for (IReviewed x: allReviews){
            result.put(x.getName(), x.getRating());
        }
        return result;
    }
    public ArrayList<IReviewed> getAllAllowedForVisitor(Visitor visitor){
        ArrayList<IReviewed> result = new ArrayList<>();
        ArrayList<IReviewed> stallsAttracts = getAllReviewed();
        for (IReviewed x: stallsAttracts){
            if (x instanceof ISecurity&&((ISecurity) x).isAllowedTo(visitor)){
                    result.add(x);
                } else result.add(x);
            }


        return result;
    }
}
