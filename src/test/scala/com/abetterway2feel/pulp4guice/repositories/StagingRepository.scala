package com.abetterway2feel.pulp4guice.repositories

import com.abeterway2feel.pulp4guice.env.Environment._
import com.abeterway2feel.pulp4guice.env.Environments

@Environments(values = Array(STAGING))
final class StagingRepository extends SomethingRepository {
  override def someMethod: String = STAGING.toString
}
