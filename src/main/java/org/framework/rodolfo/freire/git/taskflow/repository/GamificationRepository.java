package org.framework.rodolfo.freire.git.taskflow.repository;


import org.framework.rodolfo.freire.git.taskflow.document.Gamification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamificationRepository extends MongoRepository<Gamification, String> {

}
