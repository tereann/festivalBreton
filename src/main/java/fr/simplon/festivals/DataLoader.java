package fr.simplon.festivals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.festivals.dao.impl.FestivalRepository;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**

 A component that loads initial data into the database upon application startup.
 Implements the {@link org.springframework.boot.ApplicationRunner} interface to ensure that
 the data is loaded after the application context has been initialized.
 */
@Component
public class DataLoader implements ApplicationRunner {
    private final FestivalRepository mFestivalRepository;

    @Autowired
    public DataLoader(FestivalRepository pFestivalRepository) {
        this.mFestivalRepository = pFestivalRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (mFestivalRepository.count() == 0) {
            ClassPathResource resource = new ClassPathResource("static/festivals.json");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Festival> festivals = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Festival>>() {
                });
                mFestivalRepository.saveAll(festivals);
            } catch (IOException e) {
                throw new RuntimeException("Error loading festivals", e);
            }
        }
    }
}
