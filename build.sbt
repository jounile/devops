name := """devops"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"
val reactiveMongoVer = "0.11.14"

val appDependencies = Seq(
  "postgresql" % "postgresql" % "8.4-702.jdbc4"
)

libraryDependencies ++= Seq(
  jdbc,
  "com.typesafe.play" %% "anorm" % "2.5.0",
  evolutions,
  cache,
  ws,
  "com.tzavellas" % "sse-guice" % "0.7.1",
  "com.google.inject" % "guice" % "3.0",
  "se.radley" %% "play-plugins-salat" % "1.5.0",
  specs2 % Test

)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

libraryDependencies += "junit" % "junit" % "4.11" % "test"
libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.

//routesGenerator := InjectedRoutesGenerator
libraryDependencies += "org.webjars" %% "webjars-play" % "2.4.0"
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.4"
libraryDependencies += "org.webjars" % "angularjs" % "1.4.9" exclude("org.webjars", "jquery")
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.4.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "com.novus" %% "salat" % "1.9.9"
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.1"
