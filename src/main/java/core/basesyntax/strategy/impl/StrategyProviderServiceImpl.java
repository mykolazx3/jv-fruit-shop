package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StrategyProviderService;
import core.basesyntax.strategy.StrategyService;
import java.util.HashMap;
import java.util.Map;

public class StrategyProviderServiceImpl implements StrategyProviderService {
    private final Map<Operation, StrategyService> strategies = new HashMap<>();

    public StrategyProviderServiceImpl() {
        strategies.put(Operation.BALANCE, new BalanceStrategyServiceImpl());
        strategies.put(Operation.SUPPLY, new SupplyStrategyServiceImpl());
        strategies.put(Operation.PURCHASE, new PurchaseStrategyServiceImpl());
        strategies.put(Operation.RETURN, new ReturnStrategyServiceImpl());
    }

    @Override
    public StrategyService getStrategy(Operation operation) {
        for (Map.Entry<Operation, StrategyService> strategy : strategies.entrySet()) {
            if (strategy.getKey().equals(operation)) {
                return strategy.getValue();
            }
        }
        throw new RuntimeException("Incorrect strategy" + operation);
    }
}
