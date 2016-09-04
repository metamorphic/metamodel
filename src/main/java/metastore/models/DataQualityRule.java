package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 5/07/2015.
 */
@Entity
@Table(name = "dq_rules", schema = "meta")
public class DataQualityRule extends AuditedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dq_rule_id")
    private Integer id;

    @Column(name = "dq_rule_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "data_source_id")
    private DataSource dataSource;

    @Column(length = 8000)
    private String specification;

    @Column(length = 8000)
    private String script;

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

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
