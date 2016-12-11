package com.abetterway2feel.pulp4guice.resolver

import com.abberway2feel.pulp4guice.env.EnvironmentNameResolver
import com.abberway2feel.pulp4guice.resolver.ImplementationFinderModuleResolver
import com.abeterway2feel.pulp4guice.env.Environment
import org.scalatest.{FlatSpec, Matchers}


final class ImplementationFinderModuleResolverSpec extends FlatSpec with Matchers {


}

object ImplementationFinderModuleResolverSpec {

  final val packageName = "com.abetterway2feel.pulp4guice.repositories"

  def main(args: Array[String]): Unit = {

    val moduleResolver = new ImplementationFinderModuleResolver(
      Seq(packageName),
      EnvironmentNameResolver.environmentNameResolver(Environment.DEV)
    )

    println(moduleResolver.getAbstractModuleCandidates)

  }
}

