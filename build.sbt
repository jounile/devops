name := """newBlog"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.tzavellas" % "sse-guice" % "0.7.1",
  "com.google.inject" % "guice" % "3.0",
  "se.radley" %% "play-plugins-salat" % "1.5.0",
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


libraryDependencies += "junit" % "junit" % "4.11" % "test"
libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.

//routesGenerator := InjectedRoutesGenerator
libraryDependencies += "org.webjars" %% "webjars-play" % "2.4.0"
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.4"
libraryDependencies += "org.webjars" % "angularjs" % "1.4.9" exclude("org.webjars", "jquery")