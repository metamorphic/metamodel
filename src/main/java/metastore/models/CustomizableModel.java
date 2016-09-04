package metastore.models;

import javax.persistence.MappedSuperclass;

/**
 * Created by markmo on 21/06/15.
 */
@MappedSuperclass
public class CustomizableModel extends AuditedModel implements Customizable {

    private String customAttributes;

    public String getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(String customAttributes) {
        this.customAttributes = customAttributes;
    }
}
