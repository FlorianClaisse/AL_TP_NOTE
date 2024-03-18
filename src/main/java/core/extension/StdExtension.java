package core.extension;

import core.BehaviorSoldier;

public final class StdExtension extends BehaviorExtension {
	private static final float wear_ratio = 2.5f;

	private float m_wear = 10;

	public StdExtension(float attack, float defense, BehaviorSoldier soldier) {
		super(soldier, attack, defense);
	}

	@Override
	public float strike() {
		float force = getParent().strike() + m_attack_bonus;
		m_wear -= wear_ratio * Math.min(m_wear, force) / m_wear;
		return force;
	}

	@Override
	public float parry(float force) {
		float taken_force;
		if(m_defense_bonus >= 0)
			taken_force = force / (1 + m_defense_bonus);
		else
			taken_force = force;

		m_wear -= wear_ratio * Math.min(m_wear, taken_force) / m_wear;
		return getParent().parry(taken_force);
	}
}
