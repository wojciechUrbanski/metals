package docs

import mdoc.Reporter
import mdoc.StringModifier
import scala.meta.inputs.Input
import scala.meta.internal.metals.BuildInfo

class RequirementsModifier extends StringModifier {
  override val name: String = "requirements"

  def supportedScalaVersions =
    BuildInfo.supportedScalaVersions.dropRight(1).mkString(", ") +
      s" and ${BuildInfo.supportedScalaVersions.last}"

  override def process(
      info: String,
      code: Input,
      reporter: Reporter
  ): String = {
    s"""
       |## Requirements
       |
       |**OpenJDK or Oracle Java 8**. Eclipse OpenJ9 and Java 11 are not
       |supported, please make sure the `JAVA_HOME` environment variable
       |points to valid Java 8 installation.
       |
       |**macOS, Linux or Windows**. Metals is developed on macOS and every PR is
       |tested on Ubuntu+Windows.
       |
       |**Scala 2.13, 2.12 and 2.11**. Metals supports these Scala versions $supportedScalaVersions.
       |Note that 2.11.x support is deprecated and it will be removed in future releases.
       |It's recommended to upgrade to Scala 2.12 or Scala 2.13
       |""".stripMargin
  }
}
