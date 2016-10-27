package metastore.models;

import metastore.elasticsearch.Searchable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name="feature_types", schema = "meta")
public class FeatureType extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "feature_type_id_seq", sequenceName = "feature_types_feature_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_type_id_seq")
    @Column(name="feature_type_id")
    private Long id;

    @Column(name="feature_name")
    private String name;

    private AttributeType attributeType;

    private String status;

    @ManyToOne
    @JoinColumn(name="security_classification_id")
    private SecurityClassification securityClassification;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id")
    private CustomerIdType customerIdType;

    @ManyToOne
    @JoinColumn(name="value_type_id")
    private ValueType valueType;

    @ManyToOne
    @JoinColumn(name="data_type_id")
    private DataType dataType;

    private String columnName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date snapshotTs;

    private String description;

    private String referenceType;

    private String reference;

    private String authorName;

    private String authorEmail;

    @Column(name = "lang")
    private Language language;

    private String dbname;

    @Column(length = 8000)
    private String expression;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "feature_family_types", schema = "meta",
            joinColumns = @JoinColumn(name = "feature_type_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_family_id")
    )
    private List<FeatureFamily> featureFamilies = new ArrayList<FeatureFamily>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "feature_type_tags", schema = "meta",
            joinColumns = @JoinColumn(name = "feature_type_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<Tag>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "feature_type_dependencies", schema = "meta",
            joinColumns = @JoinColumn(name = "dependent_feature_type_id", referencedColumnName = "feature_type_id"),
            inverseJoinColumns = @JoinColumn(name = "independent_feature_type_id", referencedColumnName = "feature_type_id")
    )
    private List<FeatureType> dependencies = new ArrayList<FeatureType>();

    private int version;

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

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SecurityClassification getSecurityClassification() {
        return securityClassification;
    }

    public void setSecurityClassification(SecurityClassification securityClassification) {
        this.securityClassification = securityClassification;
    }

    public CustomerIdType getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(CustomerIdType customerIdType) {
        this.customerIdType = customerIdType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Date getSnapshotTs() {
        return snapshotTs;
    }

    public void setSnapshotTs(Date snapshotTs) {
        this.snapshotTs = snapshotTs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<FeatureFamily> getFeatureFamilies() {
        return featureFamilies;
    }

    public void setFeatureFamilies(List<FeatureFamily> featureFamilies) {
        this.featureFamilies = featureFamilies;
    }

    public String getFeatureFamiliesId() {
        if (featureFamilies == null) {
            return null;
        }
        int n = featureFamilies.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = featureFamilies.get(i).getId().toString();
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

    public String getFeatureFamiliesName() {
        if (featureFamilies == null) {
            return null;
        }
        int n = featureFamilies.size();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = featureFamilies.get(i).getName();
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getTagsId() {
        if (tags == null) {
            return null;
        }
        int n = tags.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = tags.get(i).getId().toString();
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

    public String getTagsName() {
        if (tags == null) {
            return null;
        }
        int n = tags.size();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = tags.get(i).getName();
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

    public List<FeatureType> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<FeatureType> dependencies) {
        this.dependencies = dependencies;
    }

    public String getDependenciesId() {
        if (dependencies == null) {
            return null;
        }
        int n = dependencies.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = dependencies.get(i).getId().toString();
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
