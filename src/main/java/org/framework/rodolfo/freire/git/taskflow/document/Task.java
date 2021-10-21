package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;

@Document(collection = "Task")
@Getter
@Setter
public class Task extends AuditMetadata {

    private String name;
    private String description;
    private Date dtIni;
    private Date dtEnd;
    private int priority;
    private int delivered;
    private int revised;
    private int completed;
    private Collection<Gamification> gamificationCollection;
    private Collection<Archive> archiveCollection;
    private Collection<Remark> remarkCollection;
}
