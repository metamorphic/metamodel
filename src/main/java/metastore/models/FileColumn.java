package metastore.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "event_property_types_columns", schema = "meta",
            joinColumns = @JoinColumn(name = "column_id"),
            inverseJoinColumns = @JoinColumn(name = "property_type_id")
    )
    private List<EventPropertyType> eventPropertyTypes = new ArrayList<EventPropertyType>();

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

    public List<EventPropertyType> getEventPropertyTypes() {
        return eventPropertyTypes;
    }

    public void setEventPropertyTypes(List<EventPropertyType> eventPropertyTypes) {
        this.eventPropertyTypes = eventPropertyTypes;
    }

    public String getEventPropertyTypesId() {
        if (eventPropertyTypes == null) {
            return null;
        }
        int n = eventPropertyTypes.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = eventPropertyTypes.get(i).getId().toString();
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

    public String getEventPropertyTypesName() {
        if (eventPropertyTypes == null) {
            return null;
        }
        int n = eventPropertyTypes.size();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = eventPropertyTypes.get(i).getName();
        }
        if (n == 0) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String name : names) {
                sb.append(name).append(',');
            }
            return sb.substring(0, sb.length() - 1);
        }
    }

    public void addEventPropertyType(EventPropertyType eventPropertyType) {
        if (eventPropertyTypes == null) {
            eventPropertyTypes = new ArrayList<EventPropertyType>();
        }
        eventPropertyTypes.add(eventPropertyType);
    }
}
