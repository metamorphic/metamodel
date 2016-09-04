package metastore.models;

/**
 * Created by markmo on 10/04/15.
 */
public class CustomerIdValue {

    private CustomerIdType customerIdType;

    private String customerId;

    public CustomerIdValue(CustomerIdType customerIdType, String customerId) {
        this.customerIdType = customerIdType;
        this.customerId = customerId;
    }

    public CustomerIdType getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(CustomerIdType customerIdType) {
        this.customerIdType = customerIdType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
