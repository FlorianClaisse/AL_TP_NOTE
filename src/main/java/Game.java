import core.extension.StdExtension;
import core.BehaviorSoldier;
import core.soldier.ConstBehavior;
import core.soldier.LogBehavior;
import composite_iterator.equipment.Sword;
import composite_iterator.unit.Army;
import composite_iterator.unit.Unit;
import composite_iterator.unit.UnitCenturion;
import composite_iterator.unit.UnitHorseMan;

public class Game {

    public static void main(String[] argv) {
        Unit hm = new UnitHorseMan();
        Unit im = new UnitCenturion();
        Unit gr1 = new Army();
        gr1.addUnit(hm);
        gr1.addUnit(im);
        Unit hm2 = new UnitCenturion();
        Unit im2 = new UnitHorseMan();
        Unit gr2 = new Army();
        gr2.addUnit(hm2);
        gr2.addUnit(im2);
        Unit gr3 = new Army();
        gr3.addUnit(gr1);
        gr3.addUnit(gr2);
        gr1.addEquipment(new Sword());
    }

    public static void main1(String[] args) {
    	BehaviorSoldier s1 =
    			new StdExtension(5.f, 0.f,
    					//new StdExtension(0.f, 6.f,
    							new LogBehavior(3, 4, 12, "Georges"));//);
    	BehaviorSoldier s2 = 
    			new StdExtension(5.f, 0.f, 
    					//new StdExtension(0.f, 6.f,
    							new ConstBehavior(3, 7, 10, "Arthur"));//);
    	
        fight(s1, s2);
    }

    private static void fight(BehaviorSoldier s1, BehaviorSoldier s2) {
    	BehaviorSoldier attack = s1;
    	BehaviorSoldier defend = s2;
        while (s1.isAlive() && s2.isAlive()) {
        	defend.parry(attack.strike());
        	BehaviorSoldier tmpSwap = attack;
            attack = defend;
            defend = tmpSwap;
        }
        
        if (s1.isAlive())
            System.out.printf("%s Won", s1.getName());
        else
            System.out.printf("%s Won", s2.getName());
    }
}
