package metastore.elasticsearch;

import java.io.Serializable;

/**
 * Created by markmo on 2/05/15.
 */
public interface Searchable {

    Serializable getId();

    String getName();

    String getDescription();
}
