package metastore.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by markmo on 8/04/15.
 */
@Entity
@Table(name = "customer_id_mapping", schema = "cxp")
public class CustomerIdMapping extends AuditedModel {

    @Id
    @SequenceGenerator(name = "customer_id_mapping_id_seq", sequenceName = "customer_id_mapping_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_mapping_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id_1")
    private CustomerIdType customerIdType1;

    private String customerId1;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id_2")
    private CustomerIdType getCustomerIdType2;

    private String customerId2;

    private double confidence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerIdType getCustomerIdType1() {
        return customerIdType1;
    }

    public void setCustomerIdType1(CustomerIdType customerIdType1) {
        this.customerIdType1 = customerIdType1;
    }

    public String getCustomerId1() {
        return customerId1;
    }

    public void setCustomerId1(String customerId1) {
        this.customerId1 = customerId1;
    }

    public CustomerIdType getGetCustomerIdType2() {
        return getCustomerIdType2;
    }

    public void setGetCustomerIdType2(CustomerIdType getCustomerIdType2) {
        this.getCustomerIdType2 = getCustomerIdType2;
    }

    public String getCustomerId2() {
        return customerId2;
    }

    public void setCustomerId2(String customerId2) {
        this.customerId2 = customerId2;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
