resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

lazy val commonSettings = Seq(
// Refine scalac params from tpolecat
  scalacOptions --= Seq(
    "-Xfatal-warnings"
  ),
  scalacOptions ++= Seq(
    "-Xsource:2.11",
    "-language:reflectiveCalls",
    "-language:postfixOps",
    "-unchecked",
    "-deprecation"
  )
)

lazy val chiselDeps = libraryDependencies ++= Seq(
  "edu.berkeley.cs" %% "chisel3"          % Version.chisel,
  "edu.berkeley.cs" %% "firrtl"           % Version.firrtl,
  "edu.berkeley.cs" %% "chisel-iotesters" % Version.testers
)

lazy val zioDeps = libraryDependencies ++= Seq(
  "dev.zio" %% "zio-test"     % Version.zio % "test",
  "dev.zio" %% "zio-test-sbt" % Version.zio % "test"
)

lazy val root = (project in file("."))
  .settings(
    organization := "Neurodyne",
    name := "hello",
    version := "0.0.1",
    scalaVersion := "2.12.10",
    maxErrors := 3,
    commonSettings,
    zioDeps,
    chiselDeps,
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )

// Aliases
addCommandAlias("rel", "reload")
addCommandAlias("com", "all compile test:compile it:compile")
addCommandAlias("fix", "all compile:scalafix test:scalafix")
addCommandAlias("fmt", "all scalafmtSbt scalafmtAll")

scalafixDependencies in ThisBuild += "com.nequissimus" %% "sort-imports" % "0.5.0"
