package metastore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by markmo on 17/05/15.
 */
@Entity
@DiscriminatorValue("TABLE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TableColumn extends DataColumn {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dataset_id")
    private TableDataset dataset;

    @Override
    public TableDataset getDataset() {
        return dataset;
    }

    public void setDataset(TableDataset dataset) {
        this.dataset = dataset;
    }
}
