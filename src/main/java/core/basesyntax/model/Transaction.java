package core.basesyntax.model;

import java.util.Objects;

public class Transaction {

    private final Operation operation;
    private final String product;
    private final int quantity;

    public Transaction(Operation operation, String product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return quantity == that.quantity && operation == that.operation
                && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, product, quantity);
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "operation="
                + operation
                + ", product='"
                + product + '\''
                + ", quantity="
                + quantity
                + '}';
    }
}
