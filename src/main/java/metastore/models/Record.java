package metastore.models;

import metastore.elasticsearch.Searchable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmo on 22/04/15.
 */
@Entity
@Table(name = "records", schema = "meta")
public class Record extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "record_id_seq", sequenceName = "records_record_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_id_seq")
    @Column(name = "record_id")
    private Long id;

    @Column(name = "record_name")
    private String name;

    private String prefix;

    @Column(length = 8000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "dataset_id")
    private FileDataset dataset;

    @OneToMany(mappedBy = "record", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("columnIndex")
    private List<FileColumn> columns;

    @ManyToMany
    @JoinTable(
            name = "event_types_records", schema = "meta",
            joinColumns = @JoinColumn(name = "record_id"),
            inverseJoinColumns = @JoinColumn(name = "event_type_id")
    )
    private List<EventType> eventTypes = new ArrayList<EventType>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FileDataset getDataset() {
        return dataset;
    }

    public void setDataset(FileDataset dataset) {
        this.dataset = dataset;
    }

    public List<FileColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<FileColumn> columns) {
        this.columns = columns;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public void addEventType(EventType eventType) {
        if (eventTypes == null) {
            eventTypes = new ArrayList<EventType>();
        }
        eventTypes.add(eventType);
    }

    public String getEventTypesId() {
        if (eventTypes == null) {
            return null;
        }
        int n = eventTypes.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = eventTypes.get(i).getId().toString();
        }
        //return String.join(",", ids);
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
