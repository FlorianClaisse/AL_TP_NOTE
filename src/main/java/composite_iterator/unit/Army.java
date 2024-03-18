package composite_iterator.unit;

import composite_iterator.equipment.Equipment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Army implements Unit {
    private final List<Unit> units;
    private final String name;

    public Army() { this("army"); }

    public Army(String name) {
        this.units = new ArrayList<>();
        this.name = name;
    }

    @Override
    public boolean isAlive() {
        for (Unit unit: units)
            if (unit.isAlive())
                return true;
        return false;
    }

    @Override
    public float getHealthPoints() {
        float total = 0;
        for (Unit unit: this.units)
            if (unit.isAlive())
                total += unit.getHealthPoints();
        return total;
    }

    @Override
    public void heal() {
        for (Unit unit: this.units)
            if (unit.isAlive())
                unit.heal();
    }

    @Override
    public float parry(float force) {
        int unitAlive = this.unitAlive();
        if (unitAlive < 0) return force;

        float value = force / unitAlive;
        float res = 0;
        for (Unit unit: this.units)
            if (unit.isAlive())
                res += unit.parry(value);

        if (res > 0)
            return this.parry(res);
        return res;
    }

    @Override
    public float strike() {
        float total = 0;
        for (Unit unit: this.units) {
            if (unit.isAlive())
                total += unit.strike();
        }
        return total;
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public void addUnit(Unit unit) { this.units.add(unit); }

    @Override
    public void removeUnit(Unit unit) { this.units.remove(unit); }

    @Override
    public Iterator<Unit> getUnits() { return this.units.iterator(); }

    @Override
    public boolean addEquipment(Equipment equipment) {
        for (Unit unit: this.units)
            if (unit.addEquipment(equipment))
                return true;
        return false;
    }

    @Override
    public boolean removeEquipment(Equipment equipment) {
        for (Unit unit: this.units)
            if (unit.removeEquipment(equipment))
                return true;
        return false;
    }

    @Override
    public Iterator<Equipment> getEquipments() {
        List<Equipment> result = new ArrayList<>();
        for (Unit unit: this.units) {
            Iterator<Equipment> equipments = unit.getEquipments();
            while (equipments.hasNext())
                result.add(equipments.next());
        }

        return result.iterator();
    }

    private int unitAlive() {
        int count = 0;
        for (Unit unit: this.units)
            if (unit.isAlive())
                count++;
        return count;
    }
}
