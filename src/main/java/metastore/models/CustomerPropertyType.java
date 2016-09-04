package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name="customer_property_types", schema = "meta")
public class CustomerPropertyType extends AuditedModel {

    @Id
    @SequenceGenerator(name = "property_type_id_seq", sequenceName = "customer_property_types_property_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_type_id_seq")
    @Column(name="property_type_id")
    private Long id;

    @Column(name="property_type")
    private String name;

    @ManyToOne
    @JoinColumn(name="value_type_id")
    private ValueType valueType;

    @ManyToOne
    @JoinColumn(name="security_classification_id")
    private SecurityClassification securityClassification;

    private String description;

    @Column(length = 8000)
    private String mappingExpression;

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
}
