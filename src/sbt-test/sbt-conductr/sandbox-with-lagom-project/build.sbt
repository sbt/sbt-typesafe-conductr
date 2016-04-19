import org.scalatest.Matchers._

version in ThisBuild := "0.1.0-SNAPSHOT"
scalaVersion in ThisBuild := "2.11.8"

lazy val `lagom-service-api` = (project in file("lagom-service-api"))
  .settings(libraryDependencies += lagomJavadslApi)

lazy val `lagom-service-impl` = (project in file("lagom-service-impl"))
  .enablePlugins(LagomJava)
  .dependsOn(`lagom-service-api`)

val checkConductrIsRunning = taskKey[Unit]("")
checkConductrIsRunning := s"docker ps -q -f name=cond-".lines_! should have size 1

val checkConductrIsStopped = taskKey[Unit]("")
checkConductrIsStopped := """docker ps --quiet --filter name=cond""".lines_! should have size 0