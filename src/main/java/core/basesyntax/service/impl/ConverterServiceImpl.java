package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConverterService;
import java.util.ArrayList;
import java.util.List;

public class ConverterServiceImpl implements ConverterService {
    public static final String ALLOWED_CODE_B = "b";
    public static final String ALLOWED_CODE_S = "s";
    public static final String ALLOWED_CODE_P = "p";
    public static final String ALLOWED_CODE_R = "r";

    @Override
    public List<Transaction> convert(List<String> entriesList) {
        List<Transaction> fruitTransactions = new ArrayList<>();

        for (String s : entriesList) {
            String[] splittedEntry = s.split(",");

            if (checkCode(splittedEntry[0])) {
                Transaction transaction = new Transaction(
                        Operation.getByCode(splittedEntry[0]),
                        splittedEntry[1],
                        Integer.parseInt(splittedEntry[2])
                );
                fruitTransactions.add(transaction);
            }
        }

        return fruitTransactions;
    }

    private boolean checkCode(String code) {
        return code.equals(ALLOWED_CODE_B)
                || code.equals(ALLOWED_CODE_S)
                || code.equals(ALLOWED_CODE_P)
                || code.equals(ALLOWED_CODE_R);
    }
}
