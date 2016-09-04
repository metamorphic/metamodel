package metastore.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by markmo on 28/03/2015.
 */
@Embeddable
public class ColumnProfilePK implements Serializable {

    private static final long serialVersionUID = 6586011138194981461L;

    @ManyToOne
    @JoinColumn(name="column_id")
    private DataColumn column;

    @Column(name="profile_ts")
    private Date ts;

    public DataColumn getColumn() {
        return column;
    }

    public void setColumn(DataColumn column) {
        this.column = column;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColumnProfilePK that = (ColumnProfilePK) o;

        if (!column.equals(that.column)) return false;
        if (!ts.equals(that.ts)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = column.hashCode();
        result = 31 * result + ts.hashCode();
        return result;
    }
}
