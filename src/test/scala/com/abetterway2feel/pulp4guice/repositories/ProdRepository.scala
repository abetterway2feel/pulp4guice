package com.abetterway2feel.pulp4guice.repositories

import com.abeterway2feel.pulp4guice.env.Environment._
import com.abeterway2feel.pulp4guice.env.Environments

@Environments(values = Array(PROD))
final class ProdRepository extends SomethingRepository {
  override def someMethod: String = PROD.toString
}
