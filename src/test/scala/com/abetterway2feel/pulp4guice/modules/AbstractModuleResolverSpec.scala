package com.abetterway2feel.pulp4guice.modules

import com.abberway2feel.pulp4guice.env.EnvironmentNameResolver
import com.abberway2feel.pulp4guice.modules.AbstractModuleResolver
import com.abeterway2feel.pulp4guice.env.Environment
import com.abetterway2feel.pulp4guice.modules.test.{DevAndProdAbstractModule, LocalAbstractModule, NoEnvSpecifiedAbstractModule, ProdAbstractModule}
import org.scalatest.{FlatSpec, Matchers}
import AbstractModuleResolverSpec._


class AbstractModuleResolverSpec extends FlatSpec with Matchers {

  behavior of "AbstractModuleResolver"

  it should "return the LocalAbstractModule when the env property is LOCAL" in {
    val expectedModules = Set(NoEnvSpecifiedAbstractModule(), LocalAbstractModule())

    testAbstractModuleResolver(Environment.LOCAL).toSet should be(expectedModules)
  }

  it should "return the ProdAbstractModule and the DevAndProdAbstractModule when the env property is DEV" in {
    val expectedModules = Set(NoEnvSpecifiedAbstractModule(), DevAndProdAbstractModule(), ProdAbstractModule())

    testAbstractModuleResolver(Environment.PROD).toSet should be(expectedModules)
  }

}

object AbstractModuleResolverSpec {

  val packageName = "com.abetterway2feel.pulp4guice.modules.test"

  def testAbstractModuleResolver(environment: Environment) = {
    new AbstractModuleResolver(
      List(packageName),
      new EnvironmentNameResolver {
        override def getEnvironmentProperty: Environment = environment
      }
    ).abstractModules()
  }
}
