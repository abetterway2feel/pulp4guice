package com.abberway2feel.pulp4guice.env

import com.google.inject.AbstractModule
import com.abeterway2feel.pulp4guice.env.Environment

final class AbstractModuleResolver(
  modulePackages: Seq[String],
  nameResolver: EnvironmentNameResolver) {

  private[this] val logger = LoggerFactory.getLogger(getClass)

  lazy val abstractModules: Seq[AbstractModule] = {
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
    }
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