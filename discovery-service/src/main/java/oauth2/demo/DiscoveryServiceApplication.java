package oauth2.demo;

import lombok.extern.slf4j.Slf4j;
import oauth2.demo.config.EurekaSettings;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;

@Slf4j
@SpringBootApplication
@EnableEurekaServer
@EnableConfigurationProperties(value = {EurekaSettings.class})
public class DiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(InetUtils inetUtils) {
        return args -> {
            InetAddress inetAddress = inetUtils.findFirstNonLoopbackAddress();
            InetUtils.HostInfo hostInfo = inetUtils.convertAddress(inetAddress);
            log.debug("inetAddress = {}, hostInfo = {}", inetAddress, hostInfo);
        };
    }
}


