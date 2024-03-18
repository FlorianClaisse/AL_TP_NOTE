package composite_iterator.equipment;

import core.extension.StdExtension;
import core.BehaviorSoldier;

public final class Sword implements Equipment {
    @Override
    public BehaviorSoldier createExtension(BehaviorSoldier soldier) {
        return new StdExtension(5, 0, soldier);
    }
}
