package org.jbake.app;

import org.apache.commons.configuration.CompositeConfiguration;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author yangxiaochen
 * @date 2017/9/12 00:29
 */
public class PublishTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    public CompositeConfiguration config;
    private File rootPath;
    private File outputPath;


    @Before
    public void before() throws Exception {
        URL sourceUrl = this.getClass().getResource("/fixture");
        rootPath = new File(sourceUrl.getFile());
        if (!rootPath.exists()) {
            throw new Exception("Cannot find base path for test!");
        }
        outputPath = folder.newFolder("destination");
        config = ConfigUtil.load(rootPath);
    }

    @Test
    public void publish() throws Exception {
        final Oven oven = new Oven(rootPath, outputPath, config, true);
        oven.setupPaths();
        oven.bake();

        assertThat("There shouldn't be any errors: " + oven.getErrors(), oven.getErrors().isEmpty());
    }
}
