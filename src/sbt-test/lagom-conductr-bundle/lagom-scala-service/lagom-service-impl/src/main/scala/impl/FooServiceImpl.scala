package impl

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import scala.concurrent.Future
import api.FooService

class FooServiceImpl extends FooService {
  override def foo = ServiceCall { _ =>
    Future.successful(NotUsed)
  }
}
