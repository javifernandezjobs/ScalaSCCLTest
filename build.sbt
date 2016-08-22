name := "SCCLTest"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "2.4.2",
  "com.h2database"  %  "h2"                % "1.4.192",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.7"
)
    