package metastore.models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by markmo on 5/07/2015.
 */
@Embeddable
public class MetricValuePK implements Serializable {

    private static final long serialVersionUID = 6586011138194981876L;

    @ManyToOne
    @JoinColumn(name = "analysis_type_id")
    private AnalysisType analysisType;

    @ManyToOne
    @JoinColumn(name = "metric_id")
    private Metric metric;

    @ManyToOne
    @JoinColumn(name = "column_id")
    private DataColumn column;

    public AnalysisType getAnalysisType() {
        return analysisType;
    }

    public void setAnalysisType(AnalysisType analysisType) {
        this.analysisType = analysisType;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public DataColumn getColumn() {
        return column;
    }

    public void setColumn(DataColumn column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetricValuePK that = (MetricValuePK) o;

        if (!analysisType.equals(that.analysisType)) return false;
        if (!metric.equals(that.metric)) return false;
        return column.equals(that.column);

    }

    @Override
    public int hashCode() {
        int result = analysisType.hashCode();
        result = 31 * result + metric.hashCode();
        result = 31 * result + column.hashCode();
        return result;
    }
}
