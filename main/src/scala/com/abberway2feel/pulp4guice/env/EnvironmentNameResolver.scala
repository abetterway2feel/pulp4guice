package com.abberway2feel.pulp4guice.env

import com.abeterway2feel.pulp4guice.env.Environment

trait EnvironmentNameResolver {

  def getEnvironmentProperty: Environment
}
