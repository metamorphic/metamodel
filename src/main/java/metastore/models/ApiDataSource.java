package metastore.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@DiscriminatorValue("API")
public class ApiDataSource extends DataSource {

    private String apiUrl;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
