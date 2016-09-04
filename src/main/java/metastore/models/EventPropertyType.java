package metastore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import metastore.elasticsearch.Searchable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name = "event_property_types", schema = "cxp")
public class EventPropertyType extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "property_type_id_seq", sequenceName = "event_property_types_property_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_type_id_seq")
    @Column(name = "property_type_id")
    private Long id;

    @Column(name = "property_type")
    private String name;

    @ManyToOne
    @JoinColumn(name = "value_type_id")
    private ValueType valueType;

    @ManyToOne
    @JoinColumn(name = "security_classification_id")
    private SecurityClassification securityClassification;

    private String description;

    @Column(length = 8000)
    private String mappingExpression;

    @ManyToMany(mappedBy = "eventPropertyTypes")
    @JsonIgnore
    private List<DataColumn> columns;

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

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public String getValueTypeName() {
        if (valueType == null) return null;
        return valueType.getName();
    }

    public SecurityClassification getSecurityClassification() {
        return securityClassification;
    }

    public void setSecurityClassification(SecurityClassification securityClassification) {
        this.securityClassification = securityClassification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMappingExpression() {
        return mappingExpression;
    }

    public void setMappingExpression(String mappingExpression) {
        this.mappingExpression = mappingExpression;
    }

    public List<DataColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<DataColumn> columns) {
        this.columns = columns;
    }

    public String getFirstDatasetName() {
        if (columns == null || columns.isEmpty()) return null;
        FileDataset fileDataset = ((FileColumn) columns.get(0)).getDataset();
        if (fileDataset == null) return null;
        return fileDataset.getName();
    }
}
