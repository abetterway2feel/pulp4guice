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
  "com.google.inject" % "guice" % "3.0"
)