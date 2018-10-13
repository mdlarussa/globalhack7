package gh7.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {

    @Autowired
    private ImmigrantRepository immigrantRepository;


    public ImmigrantRepository getImmigrantRepository() {
        return immigrantRepository;
    }
}
