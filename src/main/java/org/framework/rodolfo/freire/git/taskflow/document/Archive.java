package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Archive")
@Getter
@Setter
public class Archive extends AuditMetadata {

    private String path;
    private String name;
}


