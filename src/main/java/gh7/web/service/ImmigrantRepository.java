package gh7.web.service;

import gh7.domain.Immigrant;
import org.springframework.data.repository.CrudRepository;

public interface ImmigrantRepository extends CrudRepository<Immigrant, Integer> {
}
