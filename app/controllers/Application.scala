package controllers

import play.api._
import play.api.mvc._
import org.fusesource.scalate._
import java.io.File
import models.User

object Application extends Controller {
  val engine = new TemplateEngine(new File("app/scalate_views") :: Nil, "production")
  def index = Action {
    val template = engine.load("example.jade")
    Ok(engine.layout("/", template, Map("user" -> User("Bart")))).as("text/html")
  }
  
}