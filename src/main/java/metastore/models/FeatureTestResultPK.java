package metastore.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by markmo on 26/07/2015.
 */
@Embeddable
public class FeatureTestResultPK implements Serializable {

    private static final long serialVersionUID = 6586011138194981461L;

    @ManyToOne
    @JoinColumn(name = "feature_test_id")
    private FeatureTest featureTest;

    @Column(name = "run_ts")
    private Date run;

    public FeatureTest getFeatureTest() {
        return featureTest;
    }

    public void setFeatureTest(FeatureTest featureTest) {
        this.featureTest = featureTest;
    }

    public Date getRun() {
        return run;
    }

    public void setRun(Date run) {
        this.run = run;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeatureTestResultPK that = (FeatureTestResultPK) o;

        if (!featureTest.equals(that.featureTest)) return false;
        return run.equals(that.run);

    }

    @Override
    public int hashCode() {
        int result = featureTest.hashCode();
        result = 31 * result + run.hashCode();
        return result;
    }
}
