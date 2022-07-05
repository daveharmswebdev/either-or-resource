package com.eitheror.eitherorresource.bootstrap;

import com.eitheror.eitherorresource.domain.Option;
import com.eitheror.eitherorresource.repositories.OptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * User: Dave Harms
 * Date: 7/3/22
 * Time: 2:43 PM
 */
@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final OptionRepository optionRepository;

    public DataInitializer(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        optionRepository.deleteAll();
        Option cinderella = new Option("Cinderella", "Disney Princess");
        Option savedCinderella = optionRepository.save(cinderella);

        Option snowWhite = new Option("Snow White", "Disney Princess");
        Option savedSnowWhite = optionRepository.save(snowWhite);

        optionRepository.findAll().forEach(option -> {
            System.out.println("Option Id: " + option.getId());
            System.out.println("Option Name" + option.getName());
        });
    }
}
