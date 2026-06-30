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

                Plant snakePlant = new Plant();
                snakePlant.setName("Snake Plant");
                snakePlant.setCategory(PlantCategory.FOLIAGE_INTERIOR);
                snakePlant.setWateringInterval(14);
                snakePlant.setDescription("Low-maintenance indoor plant with upright sword-like leaves.");
                snakePlant.setLight(LightRequirement.INDIRECT_BRIGHT);
                snakePlant.setQuantity(3);
                snakePlant.setImgLink("https://cdn.mos.cms.futurecdn.net/FHwTzjwh5yHHPgSupKhavY.jpg");

                Plant peaceLily = new Plant();
                peaceLily.setName("Peace Lily");
                peaceLily.setCategory(PlantCategory.FLOWERING);
                peaceLily.setWateringInterval(7);
                peaceLily.setDescription("Elegant indoor plant with glossy leaves and white flowers.");
                peaceLily.setLight(LightRequirement.LOW_LIGHT);
                peaceLily.setQuantity(2);
                peaceLily.setImgLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYnIPaq_oyp7mb-iIFbCKEOSvgGJP8WiOHcQ&s");

                Plant ficus = new Plant();
                ficus.setName("Ficus Elastica");
                ficus.setCategory(PlantCategory.FOLIAGE_INTERIOR);
                ficus.setWateringInterval(10);
                ficus.setDescription("Rubber plant with thick, glossy dark green leaves.");
                ficus.setLight(LightRequirement.INDIRECT_BRIGHT);
                ficus.setQuantity(1);
                ficus.setImgLink("https://viveroflorecer.com/cdn/shop/files/ficus-elastica-black-knight-709958.jpg?v=1749661258&width=1946");

                Plant zzPlant = new Plant();
                zzPlant.setName("ZZ Plant");
                zzPlant.setCategory(PlantCategory.FOLIAGE_INTERIOR);
                zzPlant.setWateringInterval(21);
                zzPlant.setDescription("Drought-tolerant plant with shiny dark green foliage.");
                zzPlant.setLight(LightRequirement.LOW_LIGHT);
                zzPlant.setQuantity(4);
                zzPlant.setImgLink("https://www.houseplant.co.uk/cdn/shop/articles/zzplants.webp?v=1709932857");

                Plant aloe = new Plant();
                aloe.setName("Aloe Vera");
                aloe.setCategory(PlantCategory.SUCCULENT);
                aloe.setWateringInterval(21);
                aloe.setDescription("Succulent known for its medicinal gel-filled leaves.");
                aloe.setLight(LightRequirement.DIRECT_SUN);
                aloe.setQuantity(5);
                aloe.setImgLink("https://media.v2.siweb.es/uploaded_thumb_big/af31b8ffd55e9bc92c93c04c7f3fdd12/aloe_hercules.jpeg");

                Plant jade = new Plant();
                jade.setName("Jade Plant");
                jade.setCategory(PlantCategory.SUCCULENT);
                jade.setWateringInterval(14);
                jade.setDescription("Popular succulent with thick oval leaves and woody stems.");
                jade.setLight(LightRequirement.DIRECT_SUN);
                jade.setQuantity(2);
                jade.setImgLink("https://content.elmueble.com/medio/2021/12/01/planta-de-jade_89d72781_1000x1000.jpeg");

                Plant chineseMoneyPlant = new Plant();
                chineseMoneyPlant.setName("Chinese Money Plant");
                chineseMoneyPlant.setCategory(PlantCategory.FOLIAGE_INTERIOR);
                chineseMoneyPlant.setWateringInterval(7);
                chineseMoneyPlant.setDescription("Popular houseplant with distinctive round green leaves on long stems.");
                chineseMoneyPlant.setLight(LightRequirement.INDIRECT_BRIGHT);
                chineseMoneyPlant.setQuantity(2);
                chineseMoneyPlant.setImgLink("https://www.gardenia.net/wp-content/uploads/2024/03/shutterstock_2431416235.jpg");

                plantRepository.saveAll(List.of(pothos, fern, monstera, orchid, spiderPlant, snakePlant, peaceLily, ficus, jade, aloe, chineseMoneyPlant, zzPlant));

                log.info("10 sample plants successfully loaded into KeyBlooms inventory!");
        }
    }
}