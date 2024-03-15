package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public interface StrategyProviderService {
    StrategyService getStrategy(Operation operation);
}
