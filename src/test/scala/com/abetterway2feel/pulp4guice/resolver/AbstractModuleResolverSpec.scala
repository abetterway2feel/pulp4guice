package com.abetterway2feel.pulp4guice.resolver

import com.abberway2feel.pulp4guice.resolver.AbstractModuleResolver
import com.abeterway2feel.pulp4guice.env.Environment
import com.abetterway2feel.pulp4guice.modules.test.{DevAndProdAbstractModule, StagingAbstractModule, NoEnvSpecifiedAbstractModule, ProdAbstractModule}
import org.scalatest.{FlatSpec, Matchers}
import AbstractModuleResolverSpec._
import com.abberway2feel.pulp4guice.env.EnvironmentNameResolver

class AbstractModuleResolverSpec extends FlatSpec with Matchers {

  behavior of "AbstractModuleResolver"

  it should "return the LocalAbstractModule when the env property is DEV" in {
    val expectedModules = Set(NoEnvSpecifiedAbstractModule(), DevAndProdAbstractModule())

    testAbstractModuleResolver(Environment.DEV).toSet should be(expectedModules)
  }

  it should "return the LocalAbstractModule when the env property is STAGING" in {
    val expectedModules = Set(NoEnvSpecifiedAbstractModule(), StagingAbstractModule())

    testAbstractModuleResolver(Environment.STAGING).toSet should be(expectedModules)
  }

  it should "return the ProdAbstractModule and the DevAndProdAbstractModule when the env property is DEV" in {
    val expectedModules = Set(NoEnvSpecifiedAbstractModule(), DevAndProdAbstractModule(), ProdAbstractModule())

    testAbstractModuleResolver(Environment.PROD).toSet should be(expectedModules)
  }

}

object AbstractModuleResolverSpec {

  final val packageName = "com.abetterway2feel.pulp4guice.modules.test"

  def testAbstractModuleResolver(environment: Environment) = {
    new AbstractModuleResolver(
      List(packageName),
      EnvironmentNameResolver.environmentNameResolver(environment)
    ).abstractModules()
  }
}
