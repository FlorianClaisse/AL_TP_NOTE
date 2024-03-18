package composite_iterator.unit;

import core.soldier.LogBehavior;

public final class UnitHorseMan extends UnitSimple {
    public UnitHorseMan() {
        super(new LogBehavior(3, 4, 12, "Georges"));
    }
}
