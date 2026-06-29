package com.keydan.keyblooms.service;

import com.keydan.keyblooms.model.Plant;
import com.keydan.keyblooms.model.PlantCategory;
import com.keydan.keyblooms.model.LightRequirement;
import com.keydan.keyblooms.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final PlantRepository plantRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Initializing sample plant data...");

            if (plantRepository.count() == 0) {

            Plant pothos = new Plant();
            pothos.setName("Golden Pothos");
            pothos.setCategory(PlantCategory.FOLIAGE_INTERIOR);
            pothos.setWateringInterval(7);
            pothos.setDescription("Very hardy indoor vine with heart-shaped green and yellow leaves.");
            pothos.setLight(LightRequirement.INDIRECT_BRIGHT);
            pothos.setQuantity(2);
            pothos.setImgLink("https://plantpropagation.org/wp-content/uploads/2023/08/52bd56ac-1135-436b-bf9e-87cc6ce9e50d.jpg");

            Plant fern = new Plant();
            fern.setName("Boston Fern");
            fern.setCategory(PlantCategory.FERN);
            fern.setWateringInterval(4);
            fern.setDescription("Loves high humidity and damp soil. Perfect for bathrooms.");
            fern.setLight(LightRequirement.LOW_LIGHT);
            fern.setQuantity(1);
            fern.setImgLink("https://gardenerspath.com/wp-content/uploads/2023/03/How-to-Water-a-Boston-Fern-Featured.jpg");

            Plant monstera = new Plant();
            monstera.setName("Monstera Deliciosa");
            monstera.setCategory(PlantCategory.FOLIAGE_INTERIOR);
            monstera.setWateringInterval(9);
            monstera.setDescription("Famous swiss cheese plant. Fast grower during spring.");
            monstera.setLight(LightRequirement.INDIRECT_BRIGHT);
            monstera.setQuantity(1);
            monstera.setImgLink("https://liarock.com/wp-content/uploads/2022/11/monstera-deliciosa-1024x768.jpeg");

            Plant orchid = new Plant();
            orchid.setName("Phalaenopsis Orchid");
            orchid.setCategory(PlantCategory.FLOWERING);
            orchid.setWateringInterval(12);
            orchid.setDescription("Stunning flowers. Water only when roots turn grayish.");
            orchid.setLight(LightRequirement.INDIRECT_BRIGHT);
            orchid.setQuantity(3);
            orchid.setImgLink("https://www.epicgardening.com/wp-content/uploads/2023/11/orchid-pots.jpeg");

            Plant spiderPlant = new Plant();
            spiderPlant.setName("Spider Plant");
            spiderPlant.setCategory(PlantCategory.TRAILING);
            spiderPlant.setWateringInterval(6);
            spiderPlant.setDescription("Also known as Cintas. Produces beautiful baby plantlets hanging down.");
            spiderPlant.setLight(LightRequirement.INDIRECT_BRIGHT);
            spiderPlant.setQuantity(4);
            spiderPlant.setImgLink("https://www.thespruce.com/thmb/UjlXNIgQM-WV4ivm-0nveevtPwc=/3000x0/filters:no_upscale():max_bytes(150000):strip_icc()/spider-plants-chlorophytum-definition-1902773-01b-b3f60dce30a64c399d52b5538417cc7d.jpg");

            plantRepository.saveAll(List.of(pothos, fern, monstera, orchid, spiderPlant));
            log.info("5 sample plants successfully loaded into KeyBlooms inventory!");
        }
    }
}