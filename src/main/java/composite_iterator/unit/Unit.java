package composite_iterator.unit;

import composite_iterator.equipment.Equipment;

import java.util.Iterator;

public interface Unit {
    boolean isAlive();
    float getHealthPoints();
    void heal();
    float parry(float force);
    float strike();

    String getName();

    void addUnit(Unit unit);
    void removeUnit(Unit unit);
    Iterator<Unit> getUnits();

    boolean addEquipment(Equipment equipment);
    boolean removeEquipment(Equipment equipment);
    Iterator<Equipment> getEquipments();
}
