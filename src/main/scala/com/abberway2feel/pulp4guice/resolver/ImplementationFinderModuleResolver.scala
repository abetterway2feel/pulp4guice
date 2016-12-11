package com.abberway2feel.pulp4guice.resolver

import com.abberway2feel.pulp4guice.env.EnvironmentNameResolver
import com.abeterway2feel.pulp4guice.env.Environments
import com.google.inject.Module
import org.reflections.Reflections
import org.reflections.scanners.{SubTypesScanner, TypeAnnotationsScanner}
import scala.collection.JavaConverters._

final class ImplementationFinderModuleResolver(
  modulePackages: Seq[String],
  nameResolver: EnvironmentNameResolver
) extends ModuleResolver {

  override def abstractModules(): Iterable[Module] = Iterable.empty


  def getAbstractModuleCandidates = {
    val annotatedWithEnvironments = modulePackages.flatMap {
      packageName =>
        new Reflections(packageName, new SubTypesScanner(), new TypeAnnotationsScanner())
          .getTypesAnnotatedWith(classOf[Environments]).asScala
    }


    annotatedWithEnvironments.filter {
      candidate =>
        println(candidate)
        candidate.getAnnotations.exists{
          case env: Environments =>
            env.values().contains(nameResolver.getEnvironmentProperty)
          case other =>
            false
        }
    }
  }

}
