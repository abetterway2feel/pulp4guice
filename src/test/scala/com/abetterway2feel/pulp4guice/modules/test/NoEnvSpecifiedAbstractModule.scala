package com.abetterway2feel.pulp4guice.modules.test

import com.google.inject.AbstractModule

final case class NoEnvSpecifiedAbstractModule() extends AbstractModule{
  override def configure(): Unit = {}
}
