package com.rodrigosaito;

import jetcd.EtcdClient;
import jetcd.EtcdClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class EtcdPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EtcdPropertyPlaceholderConfigurer.class);

    private EtcdClient client;

    public void setServerUrl(final String serverUrl) {
        this.client = EtcdClientFactory.newInstance(serverUrl);
    }

    @Override
    protected String resolvePlaceholder(final String placeholder, final Properties props) {
        if (this.client != null) {
            try {
                return client.get(placeholder.replaceAll("\\.","/"));
            } catch (Exception e) {
                // ignore
            }
        }

        LOGGER.info("Failed to resolve property from etcd, falling back to default PropertyPlaceholderConfigurer implementation.");

        return super.resolvePlaceholder(placeholder, props);
    }
}
