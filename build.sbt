val scala3Version = "3.1.0"
val zioVersion = "1.0.12"
val slf4jVersion = "1.7.32"
val sttpVersion = "3.3.18"

lazy val root = project
  .in(file("."))
  .settings(
    name := "test-zio",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += "dev.zio" %% "zio" % zioVersion,
    libraryDependencies += "com.softwaremill.sttp.client3" %% "httpclient-backend-zio" % sttpVersion,
    
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % slf4jVersion,
      "org.slf4j" % "slf4j-simple" % slf4jVersion
    )
  )
