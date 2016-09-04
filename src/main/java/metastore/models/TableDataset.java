package metastore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

/**
 * Created by markmo on 17/05/15.
 */
@Entity
@DiscriminatorValue("TABLE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TableDataset extends Dataset {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_source_id")
    private TableDataSource dataSource;

    @OneToMany(mappedBy = "dataset", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("columnIndex")
    private List<TableColumn> columns;

    @OneToMany
    @JoinTable(
            name = "natural_key",
            joinColumns = @JoinColumn(name = "dataset_id"),
            inverseJoinColumns = @JoinColumn(name = "column_id")
    )
    private List<TableColumn> naturalKeyColumns;

    @Override
    public String getType() {
        return "Table";
    }

    @Override
    public TableDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(TableDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }

    public List<TableColumn> getNaturalKeyColumns() {
        return naturalKeyColumns;
    }

    public void setNaturalKeyColumns(List<TableColumn> naturalKeyColumns) {
        this.naturalKeyColumns = naturalKeyColumns;
    }

    public String getNaturalKeyColumnsId() {
        if (naturalKeyColumns == null) {
            return null;
        }
        int n = naturalKeyColumns.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = naturalKeyColumns.get(i).getId().toString();
        }
        if (n == 0) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String id : ids) {
                sb.append(id).append(',');
            }
            return sb.substring(0, sb.length() - 1);
        }
    }
}
