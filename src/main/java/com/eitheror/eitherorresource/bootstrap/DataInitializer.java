package com.eitheror.eitherorresource.bootstrap;

import com.eitheror.eitherorresource.domain.Option;
import com.eitheror.eitherorresource.repositories.OptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * User: Dave Harms
 * Date: 7/3/22
 * Time: 2:43 PM
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final OptionRepository optionRepository;

    public DataInitializer(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Option cinderella = new Option("Cinderella", "Disney Princess");

        System.out.println("Id: " + cinderella.getId());

        Option savedCinderella = optionRepository.save(cinderella);

        System.out.println("Id: " + savedCinderella.getId());

        Option snowWhite = new Option("Snow White", "Disney Princess");

        System.out.println("Id: " + snowWhite.getId());

        Option savedSnowWhite = optionRepository.save(snowWhite);

        System.out.println("Id: " + savedSnowWhite.getId());

        optionRepository.findAll().forEach(option -> {
            System.out.println("Option Id: " + option.getId());
            System.out.println("Option Name" + option.getName());
        });
    }
}
