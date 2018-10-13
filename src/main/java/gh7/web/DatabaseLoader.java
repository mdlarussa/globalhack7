package gh7.web;

import gh7.domain.Immigrant;
import gh7.domain.Need;
import gh7.web.service.HelperUserRepository;
import gh7.web.service.ImmigrantUserRepository;
import gh7.web.service.NeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ImmigrantUserRepository immigrantUserRepository;
    private final HelperUserRepository helperUserRepository;
    private final NeedRepository needRepository;

    @Autowired
    public DatabaseLoader(ImmigrantUserRepository immigrantUserRepository, HelperUserRepository helperUserRepository, NeedRepository needRepository) {
        this.immigrantUserRepository = immigrantUserRepository;
        this.helperUserRepository = helperUserRepository;
        this.needRepository = needRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        long count = this.immigrantUserRepository.count();
        if (count == 0) {
            Immigrant anderson = this.immigrantUserRepository.save(new Immigrant("Anderson", "andy@wahoo.com"));
            this.immigrantUserRepository.save(new Immigrant("Bello", "bello@wahoo.com"));
            Need need = this.needRepository.save(new Need("To drive a car"));
            anderson.addNeed(need);
            this.immigrantUserRepository.save(anderson);
        }
    }
}