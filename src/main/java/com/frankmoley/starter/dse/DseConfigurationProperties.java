package com.frankmoley.starter.dse;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties for DataStax Enterprise based connections
 * @author Frank Moley
 */
@ConfigurationProperties("dse.driver")
public class DseConfigurationProperties {

    private String credentialsFile = "creds.zip";

    public String getCredentialsFile() {
        return credentialsFile;
    }

    public void setCredentialsFile(String credentialsFile) {
        this.credentialsFile = credentialsFile;
    }
}
