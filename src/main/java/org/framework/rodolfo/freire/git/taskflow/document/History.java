package org.framework.rodolfo.freire.git.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "History")
@Getter
@Setter
public class History extends AuditMetadata {

    private User user;
    private String action;
    private Date dateAction;
}
