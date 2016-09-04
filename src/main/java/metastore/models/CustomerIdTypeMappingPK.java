package metastore.models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by markmo on 18/04/15.
 */
@Embeddable
public class CustomerIdTypeMappingPK implements Serializable {

    private static final long serialVersionUID = 6586011138194981461L;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id")
    private CustomerIdType customerIdType;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public CustomerIdType getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(CustomerIdType customerIdType) {
        this.customerIdType = customerIdType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerIdTypeMappingPK that = (CustomerIdTypeMappingPK) o;

        if (!eventType.equals(that.eventType)) return false;
        return customerIdType.equals(that.customerIdType);

    }

    @Override
    public int hashCode() {
        int result = eventType.hashCode();
        result = 31 * result + customerIdType.hashCode();
        return result;
    }
}
