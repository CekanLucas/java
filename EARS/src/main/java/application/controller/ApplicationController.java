package application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import application.model.Application;

import java.sql.*;

public class ApplicationController {

    @FXML
    private ListView<Application> applicationListView;
    private ObservableList<Application> applications = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configure the ListView to use the Application model
        applicationListView.setItems(applications);
        loadApplicationsFromDatabase();

        // Set the cell factory to render the HTML from Markdown
        applicationListView.setCellFactory(listView -> new ListCell<Application>() {
            private WebView webView = new WebView();

            @Override
            protected void updateItem(Application application, boolean empty) {
                super.updateItem(application, empty);
                if (empty || application == null) {
                    setGraphic(null);
                } else {
                    webView.getEngine().loadContent(convertMarkdownToHtml(application.getApplicationText()));
                    setGraphic(webView);
                }
            }
        });
    }

    private void loadApplicationsFromDatabase() {
        String url = "jdbc:sqlite:ears.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM applications")) {

            while (rs.next()) {
                String name = rs.getString("name");
                String markdown = rs.getString("applicationText");
                applications.add(new Application(name, markdown));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

    private String convertMarkdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}