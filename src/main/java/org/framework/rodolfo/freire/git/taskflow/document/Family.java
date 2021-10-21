package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Family")
@Getter
@Setter
public class Family extends AuditMetadata {

    private String name;
    private String description;
}
