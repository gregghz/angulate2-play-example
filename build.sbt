import Angulate2Plugin._

lazy val commonSettings = Seq(
  organization := "com.lucidchart",
  version := "1.0.0",
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-Xfatal-warnings"
  ),
  resolvers += Resolver.sonatypeRepo("snapshots")
)

lazy val server = project.in(file("server")).
  enablePlugins(PlayScala, PlayScalaJS, SbtWeb).
  settings(commonSettings: _*).
  settings(
    compile in Compile <<= (compile in Compile) dependsOn (fastOptJS in (ngClient, Compile)),
    unmanagedResources in Assets += baseDirectory.value / "../ngClient/target/scala-2.11/ngclient-sjsx.js",
    scalaJSProjects := Seq(ngClient),
    routesGenerator := InjectedRoutesGenerator,
    pipelineStages := Seq(scalaJSProd),
    libraryDependencies ++= Seq(
      "com.softwaremill.macwire" %% "macros" % "2.2.2" % "provided"
    )
  ).
  aggregate(Project.projectToRef(ngClient)).
  dependsOn(sharedJvm)

lazy val ngClient = project.in(file("ngClient")).
  settings(commonSettings: _*).
  enablePlugins(Angulate2Plugin, ScalaJSPlugin, ScalaJSPlay).
  dependsOn(sharedJs).
  settings(
    scalaJSOutputMode := org.scalajs.core.tools.javascript.OutputMode.ECMAScript6,
    relativeSourceMaps := true,
    //sjsxLoader := SJSXLoader.SystemJS,
    //sjsxDeps ++= Seq(
    //  SJSXDependency("angulate2.router", "angular2/router"),
    //  SJSXDependency("ng.router", "angular2/router"),
    //  SJSXDependency("ng.routerDeprecated", "@angular/router-deprecated"),
    //  SJSXDependency("ng.http", "angular2/http"),
    //  SJSXDependency("ng.platform.browser", "@angular/platform-browser-dynamic")
    //),
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0"
    )//,
    //ngBootstrap := Some("com.lucidchart.AppComponent")
  )

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).
  settings(commonSettings: _*).
  jsConfigure(_ enablePlugins ScalaJSPlay)

lazy val sharedJvm = shared.jvm

lazy val sharedJs = shared.js
