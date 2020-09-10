package nl.icisoft.blogpost.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;
import org.springframework.stereotype.Component;

import nl.icisoft.blogpost.model.Blog;
import nl.icisoft.blogpost.repository.BlogRepository;

/**
 * 
 * Deze class wordt gebruikt om de data te preloaden met data. Er wordt gebruik
 * gemaakt van een example matcher.
 * 
 * Dit component is uitgezet om ervaring op te doen met liquibase
 * 
 */
@Component
@Profile("!db")
public class DataLoader implements ApplicationRunner {

        private BlogRepository blogRepository;

        @Autowired
        public DataLoader(BlogRepository userRepository) {
                this.blogRepository = userRepository;
        }

        /**
         * @param args
         */
        public void run(ApplicationArguments args) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!hello");
                ExampleMatcher modelMatcher = ExampleMatcher.matching().withIgnorePaths("id", "content")
                                .withMatcher("title", ignoreCase());
                Blog probe = new Blog("Go up, up and away with your Google Assistant", "");
                Example<Blog> example = Example.of(probe, modelMatcher);
                if (!blogRepository.exists(example)) {
                        blogRepository.save(new Blog("Go up, up and away with your Google Assistant",
                                        "With holiday travel coming up, and 2018 just around the corner, "
                                                        + "you may be already thinking about getaways for next year. Consider "
                                                        + "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport"));
                }
                probe = new Blog("Get local help with your Google Assistant", "");
                example = Example.of(probe, modelMatcher);
                if (!blogRepository.exists(example)) {
                        blogRepository.save(new Blog("Get local help with your Google Assistant",
                                        "No matter what questions you’re asking—whether about local traffic or "
                                                        + "a local business—your Google Assistant should be able to help. And starting "
                                                        + "today, it’s getting better at helping you, if you’re looking for nearby services "
                                                        + "like an electrician, plumber, house cleaner and more"));
                }
                probe = new Blog("The new maker toolkit: IoT, AI and Google Cloud Platform", "");
                example = Example.of(probe, modelMatcher);
                if (!blogRepository.exists(example)) {
                        blogRepository.save(new Blog("The new maker toolkit: IoT, AI and Google Cloud Platform",
                                        "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices "
                                                        + "that use technology like the Google Assistant. And with the availability of maker-friendly "
                                                        + "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action "
                                                        + "and adding voice to their Internet of Things (IoT) projects."));
                }
                probe = new Blog("Learn more about the world around you with Google Lens and the Assistant", "");
                example = Example.of(probe, modelMatcher);
                if (!blogRepository.exists(example)) {
                        blogRepository.save(new Blog(
                                        "Learn more about the world around you with Google Lens and the Assistant",
                                        "Looking at a landmark and not sure what it is? Interested in learning more about a movie as "
                                                        + "you stroll by the poster? With Google Lens and your Google Assistant, you now have a helpful "
                                                        + "sidekick to tell you more about what’s around you, right on your Pixel."));
                }
                probe = new Blog("7 ways the Assistant can help you get ready for Turkey Day", "");
                example = Example.of(probe, modelMatcher);
                if (!blogRepository.exists(example)) {
                        blogRepository.save(new Blog("7 ways the Assistant can help you get ready for Turkey Day",
                                        "Thanksgiving is just a few days away and, as always, your Google Assistant is ready to help. "
                                                        + "So while the turkey cooks and the family gathers, here are some questions to ask your Assistant."));
                }
        }
}