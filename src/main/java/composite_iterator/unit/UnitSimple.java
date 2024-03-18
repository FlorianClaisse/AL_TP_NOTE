package composite_iterator.unit;

import core.BehaviorSoldier;
import composite_iterator.equipment.Equipment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class UnitSimple implements Unit {
    private BehaviorSoldier soldier;
    private final BehaviorSoldier base_soldier;
    private final List<Equipment> equipments;

    public UnitSimple(BehaviorSoldier soldier) {
        this.soldier = soldier;
        this.base_soldier = soldier;
        this.equipments = new ArrayList<>();
    }

    @Override
    public boolean isAlive() { return this.soldier.isAlive(); }

    @Override
    public float getHealthPoints() { return this.soldier.getHealthPoints(); }

    @Override
    public void heal() { this.soldier.heal(); }

    @Override
    public float parry(float force) { return this.soldier.parry(force); }

    @Override
    public float strike() { return this.soldier.strike(); }

    @Override
    public String getName() { return this.soldier.getName(); }

    @Override
    public void addUnit(Unit unit) { throw new UnsupportedOperationException(); }

    @Override
    public void removeUnit(Unit unit) { throw new UnsupportedOperationException(); }

    @Override
    public Iterator<Unit> getUnits() { throw new UnsupportedOperationException(); }

    @Override
    public boolean addEquipment(Equipment equipment) {
        if (this.isAlive()) {
            this.equipments.add(equipment);
            this.updateSoldier();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEquipment(Equipment equipment) {
        if (isAlive() && this.equipments.contains(equipment)) {
            this.equipments.remove(equipment);
            this.updateSoldier();
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Equipment> getEquipments() { return this.equipments.iterator(); }

    private void updateSoldier() {
        BehaviorSoldier new_soldier = this.base_soldier;
        for (Equipment e: this.equipments)
            new_soldier = e.createExtension(new_soldier);
        this.soldier = new_soldier;
    }
}
