package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.Book;
import dto.DVD;
import play.libs.Json;
import play.mvc.*;
import services.WestminsterLibraryManager;

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

    public Result addDVD() {
        JsonNode json = request().body().asJson();
        DVD dvd = new DVD();
        dvd.setItemISBN(json.get("itemISBN").asInt());
        dvd.setItemTitle(json.get("itemTitle").asText());
        dvd.setItemSector(json.get("itemTitle").asText());
        dvd.setPublicationDate(json.get("publicationDate").asText());
        dvd.setLanguages(json.get("languages").asText());
        dvd.setSubtitles(json.get("subtitles").asText());
        dvd.setProducer(json.get("producer").asText());
        dvd.setActors(json.get("actors").asText());
        WestminsterLibraryManager libraryManager = new WestminsterLibraryManager();
        libraryManager.addDVD(dvd);
        return ok(Json.toJson(dvd)).as("application/json");
    }

    public Result deleteLibraryItem(String isbn){
        WestminsterLibraryManager libraryManager = new WestminsterLibraryManager();
        String itemType = libraryManager.deleteLibraryItem(Integer.parseInt(isbn));
        if (itemType == null) {
            return ok(Json.toJson("This item does not exist in the library")).as("application/json");
        }
        return ok(Json.toJson(itemType)).as("application/json");
    }
}
