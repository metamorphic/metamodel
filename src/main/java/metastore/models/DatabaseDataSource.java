package metastore.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@DiscriminatorValue("DATABASE")
public class DatabaseDataSource extends DataSource {

    private String databaseName;
    private String schema;
    private String connectionUrl;
    private String tableName;
    private String viewName;
    private String query;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
