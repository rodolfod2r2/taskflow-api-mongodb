package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Remark")
@Getter
@Setter
public class Remark extends AuditMetadata {

    private String name;
    private String description;
    private User user;
}
