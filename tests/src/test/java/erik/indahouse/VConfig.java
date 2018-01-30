package erik.indahouse;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:VConfig.properties"})
public interface VConfig extends Config {

    String login();
    String password();
}