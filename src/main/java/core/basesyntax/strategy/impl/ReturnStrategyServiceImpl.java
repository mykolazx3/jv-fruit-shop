package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.StrategyService;

public class ReturnStrategyServiceImpl implements StrategyService {

    @Override
    public int useStrategy(int amount, int storageAmount) {
        return storageAmount + amount;
    }
}
