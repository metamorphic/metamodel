package metastore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

/**
 * Created by markmo on 3/04/15.
 */
@Entity
@Table(name = "customer_id_types", schema = "cxp")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CustomerIdType extends AuditedModel {

    @Id
    @SequenceGenerator(name = "customer_id_type_id_seq", sequenceName = "customer_id_mapping_rules_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_type_id_seq")
    @Column(name = "customer_id_type_id")
    private Integer id;

    @Column(name = "customer_id_type_name")
    private String name;

    @Column(length = 8000)
    private String description;

    private boolean composite = false;

    @Column(length = 8000)
    private String compositionRule;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CustomerIdType parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy("name")
    private List<CustomerIdType> children;

    @ManyToOne
    @JoinColumn(name = "data_type_id")
    private DataType dataType;

    @ManyToOne
    @JoinColumn(name = "value_type_id")
    private ValueType valueType;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComposite() {
        return composite;
    }

    public void setComposite(boolean composite) {
        this.composite = composite;
    }

    public String getCompositionRule() {
        return compositionRule;
    }

    public void setCompositionRule(String compositionRule) {
        this.compositionRule = compositionRule;
    }

    public CustomerIdType getParent() {
        return parent;
    }

    public void setParent(CustomerIdType parent) {
        this.parent = parent;
    }

    public List<CustomerIdType> getChildren() {
        return children;
    }

    public void setChildren(List<CustomerIdType> children) {
        this.children = children;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }
}
