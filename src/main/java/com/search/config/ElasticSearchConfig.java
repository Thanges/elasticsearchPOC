/**
 * 
 */
package com.search.config;

import java.io.File;
import java.io.IOException;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author Thanges
 *
 */

/**
 * 
 * This class is used to configure the data while loading the Elastic Search
 *
 */
@Configuration
@EnableElasticsearchRepositories(basePackages="com.search.repo")
public class ElasticSearchConfig {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(ElasticSearchConfig.class);
	
	//Create the Node 
	@Bean
	public NodeBuilder nodeBuilder(){
		return new NodeBuilder();
	}
	
	//This operation will create the temporary file for holding the data
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws IOException{
		File file = null;
		try {
			log.info("Creating temp file");
			file = File.createTempFile("temp-elastic", Long.toString(System.nanoTime()));
		} catch (IOException e) {
			log.info("Error creating the file");
			e.printStackTrace();
		}
		
		// This will have default elastic search settings. This can be in xml. 
		// Since we are using Spring Boot, so using the code here.
		
		Settings.Builder elasticsearchSettings =
                Settings.settingsBuilder()
                        .put("http.enabled", "true") // 1
                        .put("index.number_of_shards", "1")
                        .put("path.data", new File(file, "data").getAbsolutePath()) // 2
                        .put("path.logs", new File(file, "logs").getAbsolutePath()) // 2
                        .put("path.work", new File(file, "work").getAbsolutePath()) // 2
                        .put("path.home", file); // 3

        return new ElasticsearchTemplate(nodeBuilder()
                .local(true)
                .settings(elasticsearchSettings.build())
                .node()
                .client());
	}

}