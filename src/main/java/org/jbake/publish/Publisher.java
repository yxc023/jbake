package org.jbake.publish;

import org.apache.commons.configuration.CompositeConfiguration;
import org.jbake.launcher.LaunchOptions;

/**
 * @author yangxiaochen
 * @date 2017/9/12 00:24
 */
public class Publisher {
    public void publish(final LaunchOptions options, final CompositeConfiguration config) {
        String urlString = config.getString("publish.url");
    }
}
