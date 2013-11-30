scalaVersion := "2.11.0-M7"

organization := "org.scala-lang"

name := "scala-spores"

version := "0.1-SNAPSHOT"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies <++= (scalaVersion) {
  sv => Seq(
    "org.scala-lang" % "scala-reflect" % sv % "provided",
    "org.scala-lang" % "scala-compiler" % sv % "provided"
  )
}

libraryDependencies += "junit" % "junit-dep" % "4.10" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10-M2" % "test"

libraryDependencies += "com.github.axel22" % "scalameter_2.11" % "0.5-SNAPSHOT"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v", "-s")

parallelExecution in Test := false

scalacOptions in Test ++= Seq("-Xlog-implicits"/*, "-Ybrowse:typer"*/)
