resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typsesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.4")

addSbtPlugin("com.vmunier" % "sbt-play-scalajs" % "0.3.1")

addSbtPlugin("de.surfice" % "sbt-angulate2" % "0.2-SNAPSHOT")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.10")
