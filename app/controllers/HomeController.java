package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.Author;
import dto.Book;
import play.libs.Json;
import play.mvc.*;
import services.DateTime;
import services.WestminsterLibraryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class AppSummary {
    private String content;

    AppSummary(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class HomeController extends Controller {

    public Result appSummary() {
        JsonNode jsonNode = Json.toJson(new AppSummary("w1673695_WestminsterLibrary"));
        return ok(jsonNode).as("application/json");
    }

    public Result postTest() {
        JsonNode jsonNode = Json.toJson(new AppSummary("Post Request Test => Data Sending Success"));
        return ok(jsonNode).as("application/json");
    }

    public Result addBook() {
        JsonNode json = request().body().asJson();
        Book book = new Book();
        book.setItemISBN(json.get("itemISBN").asInt());
        book.setItemTitle(json.get("itemTitle").asText());
        book.setItemSector(json.get("itemTitle").asText());
        book.setPublicationDate(json.get("publicationDate").asText());
        book.setAuthor(json.get("author").asText());
        book.setPublisher(json.get("publisher").asText());
        book.setNumberOfPages(json.get("numberOfPages").asInt());
        WestminsterLibraryManager libraryManager = new WestminsterLibraryManager();
        libraryManager.addBook(book);
        return ok(Json.toJson(book)).as("application/json");
    }
}
