package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Getter
@Setter
public class User extends AuditMetadata {

    private String name;
    private String email;
    private String password;
    private int xp;
    private int level;
    private Halo halo;
    private Skill skill;
    private Family family;
    private Kind kind;
    private Archive archive;
}
