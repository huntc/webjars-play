package org.webjars

import play.api.mvc.PathBindable
import controllers.LocatedPath
import controllers.WebJarAssets

package object binders {

  implicit def locatedPathBindable =
    new PathBindable[LocatedPath] {

      def bind(key: String, file: String): Either[String, LocatedPath] = {
        Right(LocatedPath(WebJarAssets.locate(file)))
      }

      def unbind(key: String, locatedPath: LocatedPath): String = {
        locatedPath.file
      }
    }

}