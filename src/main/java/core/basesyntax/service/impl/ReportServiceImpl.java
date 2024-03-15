package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(Storage storage) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(TITLE + LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : storage.getStorage().entrySet()) {
            stringBuilder.append(entry.getKey() + "," + entry.getValue() + LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
