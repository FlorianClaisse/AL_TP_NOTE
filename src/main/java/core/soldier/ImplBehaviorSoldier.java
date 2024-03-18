package core.soldier;

import core.BehaviorSoldier;

public abstract class ImplBehaviorSoldier implements BehaviorSoldier {
    private final String m_name;
    private final float m_attack;
    private final float m_defense;
    private float m_health;

    public ImplBehaviorSoldier(float attack, float defense, float hp, String name) {
        this.m_attack = attack;
        this.m_defense = defense;
        this.m_health = hp;
        this.m_name = name;
    }

    @Override
    public String getName() { return this.m_name; }

    @Override
    public float getHealthPoints() { return this.m_health; }

    public void setHealthPoints(float value) { this.m_health = value; }

    @Override
    public boolean isAlive() { return this.m_health > 0; }

    public float getDefense() { return this.m_defense; }

    public float getAttack() { return this.m_attack; }
}
