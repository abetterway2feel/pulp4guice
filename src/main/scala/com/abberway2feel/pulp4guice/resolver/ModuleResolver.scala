package com.abberway2feel.pulp4guice.resolver

import com.google.inject.Module

import scala.collection.JavaConverters._

trait ModuleResolver {

  def abstractModules(): Iterable[Module]

  def abstractModulesAsJava: java.lang.Iterable[Module] = abstractModules().asJava

}
