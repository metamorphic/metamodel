package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 10/04/15.
 */
@Entity
@Table(name = "customer_ids", schema = "meta")
public class CustomerId extends AuditedModel {

    @EmbeddedId
    private CustomerIdPK pk;

    private double confidence;

    private int version;

    public CustomerIdPK getPk() {
        return pk;
    }

    public void setPk(CustomerIdPK pk) {
        this.pk = pk;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
