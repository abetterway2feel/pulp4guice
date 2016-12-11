name := "pulp4guice"

version := "0.1.0"

scalaVersion := "2.11.8"

updateOptions := updateOptions.value.withCachedResolution(true)

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xlint",
  "-Xlint:-package-object-classes",
  "-Xlint:-missing-interpolator",
  "-Xfatal-warnings",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Ywarn-dead-code",
  "-Ywarn-nullary-unit",
  "-Yopt:l:project",
  "-encoding", "utf8"
)

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "3.0",
  "org.reflections" % "reflections" % "0.9.10",
  "org.slf4j" % "slf4j-api" % "1.7.21",
  "javax.servlet" % "servlet-api" % "2.3",

  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "org.codehaus.janino" % "janino" % "2.7.8",
  "org.tuxdude.logback.extensions" % "logback-colorizer" % "1.0.1" ,
  "org.slf4j" % "log4j-over-slf4j" % "1.7.21",

  //Test
  "org.scalatest" %% "scalatest" % "3.0.0" % Test,
  "org.mockito" % "mockito-core" % "1.8.5" % Test

)


lazy val pulp4guice = project in file(".")