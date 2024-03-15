package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionExecutorService;
import core.basesyntax.strategy.StrategyProviderService;
import core.basesyntax.strategy.StrategyService;
import java.util.List;

public class TransactionExecutorServiceImpl implements TransactionExecutorService {
    private final Storage storage;
    private final StrategyProviderService strategyProviderService;

    public TransactionExecutorServiceImpl(Storage storage,
                                          StrategyProviderService strategyProviderService) {
        this.storage = storage;
        this.strategyProviderService = strategyProviderService;
    }

    public void executeTransactionList(List<Transaction> transactionsList) {
        for (Transaction transaction : transactionsList) {
            StrategyService strategyService = strategyProviderService
                    .getStrategy(transaction.getOperation());
            int transactionValue = transaction.getQuantity();
            int storageValue = storage.getStorage().get(transaction.getProduct()) != null
                    ? storage.getStorage().get(transaction.getProduct()) : 0;
            int amount = strategyService.useStrategy(transactionValue, storageValue);

            if (amount < 0) {
                throw new RuntimeException("Amount can't be less than 0:  " + amount);
            } else {
                storage.getStorage()
                        .put(transaction.getProduct(), amount);
            }
        }
    }
}
