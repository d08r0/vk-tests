package erik.indahouse;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:Config.properties"})
public interface VConfig extends Config {
    String LOGIN();
    String PASSWORD();
    int maxThreads();
}