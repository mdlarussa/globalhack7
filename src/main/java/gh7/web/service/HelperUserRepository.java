package gh7.web.service;

import gh7.domain.Helper;
import gh7.domain.Immigrant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface HelperUserRepository extends PagingAndSortingRepository<Helper, Long> {
    List<Helper> findByName(@Param("name") String name);
}