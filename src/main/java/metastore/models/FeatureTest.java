package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 26/07/2015.
 */
@Entity
@Table(name="feature_tests", schema = "meta")
public class FeatureTest extends AuditedModel {

    @Id
    @SequenceGenerator(name = "feature_test_id_seq", sequenceName = "feature_tests_feature_test_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_test_id_seq")
    @Column(name="feature_test_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "feature_type_id")
    private FeatureType featureType;

    private String description;

    private String status;

    private String dbname;

    private String evalExpression;

    private String whereExpression;

    private String authorName;

    private String authorEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getEvalExpression() {
        return evalExpression;
    }

    public void setEvalExpression(String evalExpression) {
        this.evalExpression = evalExpression;
    }

    public String getWhereExpression() {
        return whereExpression;
    }

    public void setWhereExpression(String whereExpression) {
        this.whereExpression = whereExpression;
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
}
