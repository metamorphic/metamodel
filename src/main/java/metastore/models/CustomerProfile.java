package metastore.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by markmo on 7/04/15.
 */
@Entity
@Table(name = "customers", schema = "meta")
public class CustomerProfile extends AuditedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_surrogate_key")
    private Long id;

    @OneToMany(mappedBy = "pk.customerProfile", cascade = CascadeType.ALL)
    @OrderBy("confidence DESC")
    private List<CustomerId> customerIds;

    @Column(length = 8000)
    private String value;

    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CustomerId> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<CustomerId> customerIds) {
        if (!(customerIds == null || customerIds.isEmpty())) {
            for (CustomerId cid : customerIds) {
                cid.getPk().setCustomerProfile(this);
            }
        }
        this.customerIds = customerIds;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
