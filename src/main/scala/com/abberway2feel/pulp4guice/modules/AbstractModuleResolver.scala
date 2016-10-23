package com.abberway2feel.pulp4guice.modules

import com.abberway2feel.pulp4guice.env.EnvironmentNameResolver
import com.abeterway2feel.pulp4guice.env.{Environment, Environments}
import com.google.inject.{AbstractModule, Module}
import org.reflections.Reflections
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

/**
  * The class will scan the classes in the given modulePackages and return the [[AbstractModule]]s
  * which match the environment given by teh [[EnvironmentNameResolver]]
  *
  */
final class AbstractModuleResolver(
  modulePackages: Seq[String],
  nameResolver: EnvironmentNameResolver
) extends ModuleResolver {

  private[this] val logger = LoggerFactory.getLogger(getClass)

  def abstractModules(): Iterable[Module] = {
    val environment = nameResolver.getEnvironmentProperty

    getAbstractModuleCandidates.flatMap {
      abstractModule =>
        val maybeAnnotation = abstractModule.getAnnotation(classOf[Environments])

        Option(maybeAnnotation) match {
          case None =>
            logger.info(s"Including module '${abstractModule.getSimpleName}' with No Environment annotation")
            Some(abstractModule.newInstance())
          case Some(annotation) =>
            if (equalTo(environment, maybeAnnotation)) {
              logger.info(s"Including module '${abstractModule.getClass.getSimpleName}' with ${environment.name()} annotation")
              Some(abstractModule.newInstance())
            }
            else {
              None
            }
        }
    }.toSet
  }

  private[this] def equalTo(environment: Environment, annotation: Environments): Boolean = {
    annotation.values().contains(environment)
  }

  private[this] def getAbstractModuleCandidates = {
    modulePackages.flatMap {
      packageName =>
        new Reflections(packageName).getSubTypesOf(classOf[AbstractModule]).asScala
    }
  }
}