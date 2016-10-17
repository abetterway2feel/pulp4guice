name := "pulp4guice"
version := "0.1.0"

scalaVersion := "2.11.8"

updateOptions := updateOptions.value.withCachedResolution(true)

lazy val bidder = (project in file("."))

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
  "org.slf4j" % "slf4j-api" % "1.7.21"
)