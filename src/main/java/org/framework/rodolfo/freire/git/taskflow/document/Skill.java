package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Remark")
@Getter
@Setter
public class Skill extends AuditMetadata {

    private String name;
    private int level;
    private User user;
}
