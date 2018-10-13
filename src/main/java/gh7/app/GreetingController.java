package gh7.app;

import java.util.concurrent.atomic.AtomicLong;

import gh7.web.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        long count = repositoryService.getImmigrantRepository().count();
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name + count));
    }
}
