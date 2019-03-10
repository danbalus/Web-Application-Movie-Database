package ro.Final.project.ds.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.Final.project.ds.model.entity.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor,Long> {
}
