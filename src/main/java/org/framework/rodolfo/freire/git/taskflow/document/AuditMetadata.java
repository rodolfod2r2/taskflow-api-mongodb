package org.framework.rodolfo.freire.git.taskflow.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AuditMetadata {

    @Id
    private String id;
    @CreatedBy
    private String createdByUser;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @LastModifiedBy
    private String modifiedByUser;
}
