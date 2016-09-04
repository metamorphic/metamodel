package metastore.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by markmo on 26/07/2015.
 */
@Entity
@Table(name="feature_test_results", schema = "meta")
public class FeatureTestResult {

    @EmbeddedId
    private FeatureTestResultPK pk;

    private Boolean outcome;

    private String message;

    public FeatureTestResultPK getPk() {
        return pk;
    }

    public void setPk(FeatureTestResultPK pk) {
        this.pk = pk;
    }

    public Boolean getOutcome() {
        return outcome;
    }

    public void setOutcome(Boolean outcome) {
        this.outcome = outcome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
