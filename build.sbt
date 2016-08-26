name := """devops"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

//scalaVersion := "2.11.8"
scalaVersion := "2.10.5"

//standard
libraryDependencies ++= Seq(
  jdbc,
  evolutions,
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.

//routesGenerator := InjectedRoutesGenerator


libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "org.webjars" %% "webjars-play" % "2.4.0",
  "org.webjars" % "bootstrap" % "3.3.4",
  "org.webjars" % "angularjs" % "1.4.9" exclude("org.webjars", "jquery"),
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.novus" %% "salat" % "1.9.9",
  "com.typesafe.play" %% "anorm" % "2.5.0",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  "com.tzavellas" % "sse-guice" % "0.7.1",
  "com.google.inject" % "guice" % "3.0",
  "se.radley" %% "play-plugins-salat" % "1.5.0",
  "org.webjars" % "mocha" % "1.17.1",
  "com.novocode" % "junit-interface" % "0.10" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.9" % "test->default",
  "org.mockito" % "mockito-core" % "1.9.5"
)

logBuffered in Test := false
