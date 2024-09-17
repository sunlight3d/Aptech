package com.aptech.ex001.configurations;

import com.aptech.ex001.components.TripInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TripInfo tripInfo() {
        //Bean factory
        return new TripInfo();
    }
    //many other beans here...
}
