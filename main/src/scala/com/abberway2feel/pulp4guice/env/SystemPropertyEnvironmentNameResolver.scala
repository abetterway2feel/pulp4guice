spackage com.abberway2feel.pulp4guice.env

final class SystemPropertyEnvironmentNameResolver extends EnvironmentNameResolver {

  override def getEnvironmentProperty = Environment.valueOf(System.getProperty("environment").toUpperCase)

}