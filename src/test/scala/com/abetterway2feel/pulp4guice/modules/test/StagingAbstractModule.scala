package com.abetterway2feel.pulp4guice.modules.test

import com.abeterway2feel.pulp4guice.env.{Environment, Environments}
import com.google.inject.AbstractModule

@Environments(values = Array(Environment.STAGING))
final case class StagingAbstractModule() extends AbstractModule{
  override def configure(): Unit = {}
}
