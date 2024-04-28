package com.kvsinyuk.mongoquartz

import com.kvsinyuk.mongoquartz.config.MongoQuartzStarterConfiguration
import com.kvsinyuk.mongoquartz.config.TestEnvConfig
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TestEnvConfig::class, MongoQuartzStarterConfiguration::class])
class MongoQuartzApplicationTests {

	@Test
	fun contextLoads() {
	}

}
