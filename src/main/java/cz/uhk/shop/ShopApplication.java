package cz.uhk.shop;


import cz.uhk.shop.domain.Katalog;
import cz.uhk.shop.domain.Polozka;
import cz.uhk.shop.domain.SimpleKatalog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ShopApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    // view-resolver je konfigurovan v application.properties, ale slo by ho konfigurovat i zde

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // namapovat URL / na view jmenem index (tedy pres view-resolver na /WEB-INF/jsp/index.jsp)
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    @Primary    // prioritne pouzit tuto definici beany misto definice zpusobene anotaci @Service u tridy SimpleKatalog
    Katalog getKatalog() {
        Katalog k = new SimpleKatalog();
        k.pridej(new Polozka(1, "Čepice FIM", 123.5, 19));
        k.pridej(new Polozka(2, "FIMíček", 30, 19));
        k.pridej(new Polozka(3, "FIM Kravata", 180.5, 19));
        k.pridej(new Polozka(4, "Modrý index", 12, 5));
        return k;
    }
}
