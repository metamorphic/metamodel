package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name="column_profile", schema = "meta")
public class ColumnProfile extends AuditedModel {

    @EmbeddedId
    private ColumnProfilePK pk;

    private long rowCount;
    private long distinctCount;

    @Column(length=8000)
    private String distinctValues;

    private boolean nulls;

    @Column(columnDefinition = "SMALLINT")
    private int minLength;

    @Column(columnDefinition = "SMALLINT")
    private int maxLength;

    public ColumnProfilePK getPk() {
        return pk;
    }

    public void setPk(ColumnProfilePK pk) {
        this.pk = pk;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public long getDistinctCount() {
        return distinctCount;
    }

    public void setDistinctCount(long distinctCount) {
        this.distinctCount = distinctCount;
    }

    public String getDistinctValues() {
        return distinctValues;
    }

    public void setDistinctValues(String distinctValues) {
        this.distinctValues = distinctValues;
    }

    public boolean isNulls() {
        return nulls;
    }

    public void setNulls(boolean nulls) {
        this.nulls = nulls;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
