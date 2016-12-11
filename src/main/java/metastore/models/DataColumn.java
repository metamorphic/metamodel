package metastore.models;

import metastore.elasticsearch.Searchable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name = "data_columns", schema = "meta")
@DiscriminatorColumn(name = "column_type", discriminatorType = DiscriminatorType.STRING, length = 10)
public abstract class DataColumn extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "column_id_seq", sequenceName = "data_columns_column_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "column_id_seq")
    @Column(name = "column_id")
    private Long id;

    @Column(name = "column_name")
    private String name;

    /**
     * The inferred data type.
     */
    @ManyToOne
    @JoinColumn(name = "data_type_id")
    private DataType dataType;

    @ManyToOne
    @JoinColumn(name = "original_data_type_id")
    private DataType originalDataType;

    @ManyToOne
    @JoinColumn(name = "value_type_id")
    private ValueType valueType;

    @Column(columnDefinition = "SMALLINT")
    private int columnIndex;

    private String description;
    private String characterSet;

    @Column(name = "collation_type")
    private String collation;

    @Column(name = "uniq")
    private boolean unique;

    @Enumerated(EnumType.STRING)
    private NullableType nullableType;

    @Column(columnDefinition = "SMALLINT")
    private int length;

    private String defaultValue;
    private boolean autoinc;
    private boolean dimension;

    @Column(columnDefinition = "SMALLINT")
    private int precision;

    @Column(columnDefinition = "SMALLINT")
    private int scale;

    private boolean featureParamCandidate;
    private boolean ignore;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "column_tags", schema = "meta",
            joinColumns = @JoinColumn(name = "column_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();

    private AnalysisStatus analysisStatus;

    public abstract Dataset getDataset();

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

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getDataTypeName() {
        return dataType == null ? null : dataType.getName();
    }

    public DataType getOriginalDataType() {
        return originalDataType;
    }

    public void setOriginalDataType(DataType originalDataType) {
        this.originalDataType = originalDataType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public String getValueTypeName() {
        return valueType == null ? null : valueType.getName();
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public NullableType getNullableType() {
        return nullableType;
    }

    public void setNullableType(NullableType nullableType) {
        this.nullableType = nullableType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isAutoinc() {
        return autoinc;
    }

    public void setAutoinc(boolean autoinc) {
        this.autoinc = autoinc;
    }

    public boolean isDimension() {
        return dimension;
    }

    public void setDimension(boolean dimension) {
        this.dimension = dimension;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public boolean isFeatureParamCandidate() {
        return featureParamCandidate;
    }

    public void setFeatureParamCandidate(boolean featureParamCandidate) {
        this.featureParamCandidate = featureParamCandidate;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public String getTagNames() {
        if (tags == null || tags.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for (Tag tag : tags) {
            sb.append(tag.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public AnalysisStatus getAnalysisStatus() {
        return analysisStatus;
    }

    public void setAnalysisStatus(AnalysisStatus analysisStatus) {
        this.analysisStatus = analysisStatus;
    }
}
