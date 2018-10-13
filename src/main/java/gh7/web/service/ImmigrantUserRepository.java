package gh7.web.service;

import gh7.domain.Immigrant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "immigrants", path = "immigrants")
public interface ImmigrantUserRepository extends PagingAndSortingRepository<Immigrant, Long> {
    List<Immigrant> findByName(@Param("name") String name);
}