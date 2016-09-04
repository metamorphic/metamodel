package metastore.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by markmo on 3/05/15.
 */
@Entity
@Table(name = "queries")
public class Query {

    @Id
    @SequenceGenerator(name = "query_id_seq", sequenceName = "queries_query_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "query_id_seq")
    @Column(name = "query_id")
    private Integer id;

    private String username;

    @Column(length = 8000)
    private String query;

    private String primaryTable;
    private String tables;
    private String columns;

    @Column(name = "created_ts")
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getPrimaryTable() {
        return primaryTable;
    }

    public void setPrimaryTable(String primaryTable) {
        this.primaryTable = primaryTable;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @PrePersist
    public void addAuditInfo() {
        this.created = new Date();
    }
}
