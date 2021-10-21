package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "Team")
@Getter
@Setter
public class Team extends AuditMetadata {

    private String name;
    private Archive archive;
    private Collection<User> userCollection;
}
