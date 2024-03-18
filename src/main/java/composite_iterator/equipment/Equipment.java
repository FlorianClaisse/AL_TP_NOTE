package composite_iterator.equipment;

import core.BehaviorSoldier;

public interface Equipment {
    BehaviorSoldier createExtension(BehaviorSoldier soldier);
}
