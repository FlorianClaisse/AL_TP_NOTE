package core;

public interface BehaviorSoldier {
	String getName();
	float getHealthPoints();
	boolean isAlive();
	void heal();
	float parry(float force);  // Returns the force that the soldier did not absorb
	float strike();
}
