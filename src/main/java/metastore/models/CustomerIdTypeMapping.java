package metastore.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by markmo on 18/04/15.
 */
@Entity
@Table(name = "event_types_cust_id_types", schema = "meta")
public class CustomerIdTypeMapping {

    @EmbeddedId
    private CustomerIdTypeMappingPK pk;

    @Column(length = 8000)
    private String customerIdExpression;

    public CustomerIdTypeMappingPK getPk() {
        return pk;
    }

    public void setPk(CustomerIdTypeMappingPK pk) {
        this.pk = pk;
    }

    public String getCustomerIdExpression() {
        return customerIdExpression;
    }

    public void setCustomerIdExpression(String customerIdExpression) {
        this.customerIdExpression = customerIdExpression;
    }
}
