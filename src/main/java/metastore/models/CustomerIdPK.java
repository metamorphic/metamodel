package metastore.models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by markmo on 10/04/15.
 */
@Embeddable
public class CustomerIdPK implements Serializable {

    private static final long serialVersionUID = 6586011138194981461L;

    @ManyToOne
    @JoinColumn(name = "customer_surrogate_key")
    private CustomerProfile customerProfile;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id")
    private CustomerIdType customerIdType;

    private String customerId;

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerIdPK that = (CustomerIdPK) o;

        if (!customerProfile.equals(that.customerProfile)) return false;
        if (!customerIdType.equals(that.customerIdType)) return false;
        return customerId.equals(that.customerId);

    }

    @Override
    public int hashCode() {
        int result = customerProfile.hashCode();
        result = 31 * result + customerIdType.hashCode();
        result = 31 * result + customerId.hashCode();
        return result;
    }
}
