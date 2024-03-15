package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionExecutorService {
    void executeTransactionList(List<Transaction> transactionsList);
}
