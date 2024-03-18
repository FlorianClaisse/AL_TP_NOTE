package core.soldier;

public final class LogBehavior extends ImplBehaviorSoldier {

    public LogBehavior(float attack, float defense, float hp, String name) {
    	super(attack, defense, hp, name);
    }
    
	@Override
	public float parry(float force) {
		float strike = (float)Math.sqrt(force / this.getDefense() + 1);
		this.setHealthPoints(this.getHealthPoints() - strike);

		if(!isAlive())
			return -this.getHealthPoints();
		return 0.f;
	}

	@Override
	public float strike() { return this.getAttack() * (float)Math.log10(this.getHealthPoints() + 1.); }

	@Override
	public void heal() { this.setHealthPoints(10); }
}
