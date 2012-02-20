import sbt._
import Keys._
import PlayProject._
import com.mojolly.scalate.ScalatePlugin._

object ApplicationBuild extends Build {

    val appName         = "play-scalate"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.fusesource.scalate" % "scalate-core" % "1.5.3"
    )

    val myScalateSettings = scalateSettings ++ Seq(
      scalateTemplateDirectory in Compile <<= (baseDirectory) { _ / "app/scalate_views" }
    )
    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      myScalateSettings:_*
    )

}
