package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;

@Document(collection = "Project")
@Getter
@Setter
public class Project extends AuditMetadata {

    private String name;
    private String description;
    private Date dtIni;
    private Date dtEnd;
    private User user;
    private Archive archive;
    private Collection<Team> teamCollection;
    private Collection<Task> taskCollection;
}
