package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.StrategyService;

public class SupplyStrategyServiceImpl implements StrategyService {

    @Override
    public int useStrategy(int amount, int storageAmount) {
        return storageAmount + amount;
    }
}
