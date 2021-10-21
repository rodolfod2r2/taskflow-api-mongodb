package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Kind")
@Getter
@Setter
public class Kind extends AuditMetadata {

    private String name;
    private String description;
}
