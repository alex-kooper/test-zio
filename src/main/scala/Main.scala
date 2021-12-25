import zio.console.*
import zio.*

import sttp.model.*
import sttp.client3.*
import sttp.client3.httpclient.zio.HttpClientZioBackend

def getResponseBody(uri: Uri): Task[String] =
  HttpClientZioBackend.managed().use { sttp =>
    quickRequest
      .get(uri)
      .send(sttp)
      .map(_.body)
  }

object MyApp extends zio.App:
  def run(args: List[String]) =
    myAppLogic.exitCode

  val myAppLogic =
    for
      body <- getResponseBody(uri"http://headers.jsontest.com")
      _ <- putStrLn(s"Below is the response\n${body}")
      _ <- putStrLn("Exiting...")
    yield ()
