package core.extension;

import core.BehaviorSoldier;

public abstract class BehaviorExtension implements BehaviorSoldier {
	final float m_attack_bonus;
	final float m_defense_bonus;
	private BehaviorSoldier soldier;

	BehaviorExtension(BehaviorSoldier s, float attack, float defense) {
		this.m_attack_bonus = attack;
		this.m_defense_bonus = defense;
		this.soldier = s;
	}

	@Override
	public void heal() { this.soldier.heal(); }

	@Override
	public float parry(float force) { return this.soldier.parry(force); }
	
	BehaviorSoldier getParent() { return this.soldier; }

	void setParent(BehaviorSoldier soldier) { this.soldier = soldier; }
	
	@Override
	public String getName() { return this.soldier.getName(); }

	@Override
	public float getHealthPoints() { return this.soldier.getHealthPoints(); }

	@Override
	public boolean isAlive() { return this.soldier.isAlive(); }

	@Override
	public float strike() { return this.soldier.strike(); }
}
