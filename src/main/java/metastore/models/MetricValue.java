package metastore.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by markmo on 5/07/2015.
 */
@Entity
@Table(name = "metric_values", schema = "meta")
public class MetricValue extends AuditedModel {

    @EmbeddedId
    private MetricValuePK pk;

    private BigDecimal numericValue;

    private String stringValue;

    public MetricValuePK getPk() {
        return pk;
    }

    public void setPk(MetricValuePK pk) {
        this.pk = pk;
    }

    public BigDecimal getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(BigDecimal numericValue) {
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        if (numericValue != null) {
            return numericValue.toString();
        }
        return stringValue;
    }
}
