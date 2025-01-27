package Notes;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class JaonNestedMethods {
	/*
	 {
  "store": {
    "book": [
      {
        "category": "fiction",
        "author": "John Doe",
        "title": "The Great Adventure",
        "price": 10.99
      },
      {
        "category": "non-fiction",
        "author": "Jane Smith",
        "title": "Learning Java",
        "price": 15.49
      },
      {
        "category": "fiction",
        "author": "Emily Bronte",
        "title": "Wuthering Heights",
        "price": 12.99
      }
    ],
    "bicycle": {
      "color": "red",
      "price": 99.99
    }
  },
  "totalItems": 10,
  "sale": true
}

	 */
	// we can """(triple quotes we do not need to add escaping and adding new line character)
	public static void main(String[] args) {
        String json ="""
                {
                "store": {
                  "book": [
                    {
                      "category": "fiction",
                      "author": "John Doe",
                      "title": "The Great Adventure",
                      "price": 10.99
                    },
                    {
                      "category": "non-fiction",
                      "author": "Jane Smith",
                      "title": "Learning Java",
                      "price": 15.49
                    },
                    {
                      "category": "fiction",
                      "author": "Emily Bronte",
                      "title": "Wuthering Heights",
                      "price": 12.99
                    }
                  ],
                  "bicycle": {
                    "color": "red",
                    "price": 99.99
                  }
                },
                "totalItems": 10,
                "sale": true
              }
              """;


        // Parse the JSON string
        JsonPath jsonPath = new JsonPath(json);

        // Scalar value extraction
        int totalItems = jsonPath.getInt("totalItems");
        boolean isSale = jsonPath.getBoolean("sale");
        System.out.println("Total Items: " + totalItems);
        System.out.println("Is on Sale: " + isSale);

        // Extract nested object fields
        String bicycleColor = jsonPath.getString("store.bicycle.color");
        double bicyclePrice = jsonPath.getDouble("store.bicycle.price");
        System.out.println("Bicycle Color: " + bicycleColor);
        System.out.println("Bicycle Price: " + bicyclePrice);

        // Extract single fields from nested arrays
        String firstBookTitle = jsonPath.getString("store.book[0].title");
        System.out.println("First Book Title: " + firstBookTitle);

        // Extract all values for a field in an array
        List<String> allBookTitles = jsonPath.getList("store.book.title");
        System.out.println("All Book Titles: " + allBookTitles);

        // Extract values with a condition (filter)
        List<String> fictionAuthors = jsonPath.getList("store.book.findAll { it.category == 'fiction' }.author");
        System.out.println("Fiction Authors: " + fictionAuthors);

        // Extract first matching value with a condition
        String firstFictionBook = jsonPath.getString("store.book.find { it.category == 'fiction' }.title");
        System.out.println("First Fiction Book: " + firstFictionBook);

        // Extract all books with price greater than 12.0
        List<String> expensiveBooks = jsonPath.getList("store.book.findAll { it.price > 12.0 }.title");
        System.out.println("Books with Price > 12.0: " + expensiveBooks);
}
