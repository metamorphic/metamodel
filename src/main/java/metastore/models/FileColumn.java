package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 29/03/2015.
 */
@Entity
@DiscriminatorValue("FILE")
public class FileColumn extends DataColumn {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dataset_id")
    private FileDataset dataset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="record_id")
    private Record record;

    @Override
    public FileDataset getDataset() {
        return dataset;
    }

    public void setDataset(FileDataset dataset) {
        this.dataset = dataset;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
