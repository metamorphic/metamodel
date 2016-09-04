package metastore.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmo on 10/04/15.
 */
public class CustomerSurrogateKeyValue {

    private Long customerSurrogateKey;

    private String customerValue;

    private List<CustomerIdValue> resolutionPath;

    public CustomerSurrogateKeyValue(Long customerSurrogateKey, String customerValue, List<CustomerIdValue> resolutionPath) {
        this.customerSurrogateKey = customerSurrogateKey;
        this.customerValue = customerValue;
        this.resolutionPath = resolutionPath;
    }

    public Long getCustomerSurrogateKey() {
        return customerSurrogateKey;
    }

    public void setCustomerSurrogateKey(Long customerSurrogateKey) {
        this.customerSurrogateKey = customerSurrogateKey;
    }

    public String getCustomerValue() {
        return customerValue;
    }

    public void setCustomerValue(String customerValue) {
        this.customerValue = customerValue;
    }

    public List<CustomerIdValue> getResolutionPath() {
        return resolutionPath;
    }

    public void setResolutionPath(List<CustomerIdValue> resolutionPath) {
        this.resolutionPath = resolutionPath;
    }

    public void addCustomerIdValue(CustomerIdValue value) {
        if (resolutionPath == null) {
            resolutionPath = new ArrayList<CustomerIdValue>();
        }
        resolutionPath.add(value);
    }
}
