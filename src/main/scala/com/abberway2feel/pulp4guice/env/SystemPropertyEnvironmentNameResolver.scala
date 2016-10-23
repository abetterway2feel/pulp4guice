package com.abberway2feel.pulp4guice.env

import com.abeterway2feel.pulp4guice.env.Environment

final class SystemPropertyEnvironmentNameResolver extends EnvironmentNameResolver {

  override def getEnvironmentProperty = Environment.valueOf(System.getProperty("environment").toUpperCase)

}