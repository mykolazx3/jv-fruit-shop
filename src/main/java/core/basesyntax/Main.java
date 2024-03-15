package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConverterService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionExecutorService;
import core.basesyntax.service.impl.ConverterServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionExecutorServiceImpl;
import core.basesyntax.strategy.StrategyProviderService;
import core.basesyntax.strategy.impl.StrategyProviderServiceImpl;
import java.util.List;

public class Main {

    public static final String PATH_TO_READING_FILE = "src/main/resources/inputFile.csv";
    public static final String PATH_TO_WRITING_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        FileReaderService readerService = new CsvFileReaderServiceImpl();
        FileWriterService writerService = new CsvFileWriterServiceImpl();
        ConverterService converterService = new ConverterServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        StrategyProviderService strategyProviderService = new StrategyProviderServiceImpl();
        Storage storage = Storage.getInstance();
        TransactionExecutorService transactionExecutorService
                = new TransactionExecutorServiceImpl(storage, strategyProviderService);

        List<String> entriesList = readerService.readFromFile(PATH_TO_READING_FILE);
        List<Transaction> transactionsList = converterService.convert(entriesList);
        transactionExecutorService.executeTransactionList(transactionsList);
        String report = reportService.createReport(storage);
        writerService.writeToFile(PATH_TO_WRITING_FILE, report);
    }
}
