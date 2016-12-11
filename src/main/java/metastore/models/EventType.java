package metastore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import metastore.elasticsearch.Searchable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name = "event_types", schema = "cxp")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EventType extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "event_type_id_seq", sequenceName = "event_types_event_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_type_id_seq")
    @Column(name = "event_type_id")
    private Integer id;

    @Column(name = "event_type")
    private String name;

    private String namespace;
    private String description;

    @ManyToOne
    @JoinColumn(name = "value_type_id")
    private ValueType valueType;

//    @OneToMany(mappedBy = "pk.eventType", cascade = CascadeType.ALL)
//    private List<CustomerIdTypeMapping> customerIdTypeMappings;

    @Column(length = 8000)
    private String nestedDocumentExpression;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id1")
    private CustomerIdType customerIdType1;

    @Column(length = 8000)
    private String customerIdExpression1;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id2")
    private CustomerIdType customerIdType2;

    @Column(length = 8000)
    private String customerIdExpression2;

    @Column(length = 8000)
    private String filterExpression;

    @Column(length = 8000)
    private String valueExpression;

    @Column(length = 8000)
    private String tsExpression;

    private String datetimeFormat;

    private String timezone;

    @ManyToMany(mappedBy = "eventTypes")
    @JsonIgnore
    private List<Dataset> datasets = new ArrayList<Dataset>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

//    public List<CustomerIdTypeMapping> getCustomerIdTypeMappings() {
//        return customerIdTypeMappings;
//    }

//    public void setCustomerIdTypeMappings(List<CustomerIdTypeMapping> customerIdTypeMappings) {
//        this.customerIdTypeMappings = customerIdTypeMappings;
//    }

    public String getNestedDocumentExpression() {
        return nestedDocumentExpression;
    }

    public void setNestedDocumentExpression(String nestedDocumentExpression) {
        this.nestedDocumentExpression = nestedDocumentExpression;
    }

    public CustomerIdType getCustomerIdType1() {
        return customerIdType1;
    }

    public void setCustomerIdType1(CustomerIdType customerIdType1) {
        this.customerIdType1 = customerIdType1;
    }

    public Integer getCustomerIdType1Id() {
        return customerIdType1 == null ? null : customerIdType1.getId();
    }

    public String getCustomerIdExpression1() {
        return customerIdExpression1;
    }

    public void setCustomerIdExpression1(String customerIdExpression1) {
        this.customerIdExpression1 = customerIdExpression1;
    }

    public CustomerIdType getCustomerIdType2() {
        return customerIdType2;
    }

    public void setCustomerIdType2(CustomerIdType customerIdType2) {
        this.customerIdType2 = customerIdType2;
    }

    public Integer getCustomerIdType2Id() {
        return customerIdType2 == null ? null : customerIdType2.getId();
    }

    public String getCustomerIdExpression2() {
        return customerIdExpression2;
    }

    public void setCustomerIdExpression2(String customerIdExpression2) {
        this.customerIdExpression2 = customerIdExpression2;
    }

    public String getFilterExpression() {
        return filterExpression;
    }

    public void setFilterExpression(String filterExpression) {
        this.filterExpression = filterExpression;
    }

    public String getValueExpression() {
        return valueExpression;
    }

    public void setValueExpression(String valueExpression) {
        this.valueExpression = valueExpression;
    }

    public String getTsExpression() {
        return tsExpression;
    }

    public void setTsExpression(String tsExpression) {
        this.tsExpression = tsExpression;
    }

    public String getDatetimeFormat() {
        return datetimeFormat;
    }

    public void setDatetimeFormat(String datetimeFormat) {
        this.datetimeFormat = datetimeFormat;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public Long getPrimaryDatasetId() {
        if (datasets.isEmpty()) {
            return null;
        }
        return datasets.get(0).getId();
    }
}
