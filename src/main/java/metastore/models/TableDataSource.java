package metastore.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by markmo on 12/05/15.
 */
@Entity
@DiscriminatorValue("TABLE")
public class TableDataSource extends DataSource {

    private DatabaseServerType serverType;
    private String serverVersion;
    private String databaseName;
    private String connectionUrl;
    private String catalogName;
    private String schemaName;
    private String tableName;
    private String username;
    private String password;

    public DatabaseServerType getServerType() {
        return serverType;
    }

    public void setServerType(DatabaseServerType serverType) {
        this.serverType = serverType;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getConnectionUrl() {
        if (connectionUrl != null) {
            return connectionUrl;
        }
        if (DatabaseServerType.POSTGRESQL.equals(serverType)) {
            return "jdbc:postgresql://" + getHostname() + ":" + getPort() + "/" + databaseName;
        }
        return null;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
