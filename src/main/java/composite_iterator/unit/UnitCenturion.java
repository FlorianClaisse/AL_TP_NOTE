package composite_iterator.unit;

import core.soldier.ConstBehavior;

public final class UnitCenturion extends UnitSimple {
    public UnitCenturion() {
        super(new ConstBehavior(3, 7, 10, "Arthur"));
    }
}
