package gh7.web.service;

import gh7.domain.Immigrant;
import gh7.domain.Need;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface NeedRepository extends CrudRepository<Need, Long> {
}