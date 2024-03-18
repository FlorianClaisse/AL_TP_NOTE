package core.soldier;

public final class ConstBehavior extends ImplBehaviorSoldier {
    public ConstBehavior(float attack, float defense, float hp, String name) {
    	super(attack, defense, hp, name);
    }
    
	@Override
	public float parry(float force) {
		float strike = Math.min(0, force - this.getDefense());
		this.setHealthPoints(this.getHealthPoints() - strike);
		
		if(!this.isAlive())
			return (float)-getHealthPoints();
		return 0.f;
	}

	@Override
	public float strike() { return getAttack(); }

	@Override
	public void heal() { this.setHealthPoints(4); }
}
