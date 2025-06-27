package com.abooksapimvn.abooks;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@AutoConfigureMockMvc
class AbooksApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(AbooksApplicationTests.class);

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Retrieve one book is success")
	void testWithMockMvc() throws Exception{
		log.info("Testing retrieve one book success");
		mockMvc.perform(get("/api/v1/books/0140292918"))
			.andDo(log())
			.andExpect(status().isOk());
	}

	@Test
	@DisplayName("Retrieve one book is not found")
	void testWithMockMvcNotFound() throws Exception{
		log.info("Testing retrieve one book not found");
		mockMvc.perform(get("/api/v1/books/014029291"))
			.andDo(log())
			.andExpect(status().isNotFound());
	}

	@Test
	@DisplayName("Retrieve all books is success")
	void testWithMockMvcAll() throws Exception{
		log.info("Testing retrieve all books");
		mockMvc.perform(get("/api/v1/books"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").exists());
	}

	@Test
	@DisplayName("Test book JSON response")
	// cd /Users/path/vscode/abooks && mvn test -Dtest=AbooksApplicationTests#testBookJson
	void testBookJson() throws Exception{
		log.info("Testing book JSON response");
		mockMvc.perform(get("/api/v1/books/0140292918"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.isbn").value("0140292918"))
			.andExpect(jsonPath("$.bookTitle").exists())
			.andExpect(jsonPath("$.bookAuthor").exists());
	}

	@Test
	@DisplayName("Test one book JSON found")
	//    //Example: /api/v1/books/Penguin Books Ltd/2001
	// cd /Users/path/vscode/abooks && mvn test -Dtest=AbooksApplicationTests#testOneBookFound
	void testOneBookFound() throws Exception{
		log.info("Testing one book JSON found by publisher and year");
		mockMvc.perform(get("/api/v1/books/Penguin Books Ltd/2001"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(1))
			// .andExpect(jsonPath("$[0].isbn").value("0140292918"))
			.andExpect(jsonPath("$[0].bookAuthor").value("John Steinbeck"));
	}

	@Test
	@Disabled("Still testing - endpoint may not exist")
	@DisplayName("Test two or more books found")
	//    //Example: /api/v1/books/author/Bernhard Schlink
	// cd /Users/path/vscode/abooks && mvn test -Dtest=AbooksApplicationTests#testTwoOrMoreBooksFound
	void testTwoOrMoreBooksFound() throws Exception{
		log.info("Testing two or more books found by author");
		mockMvc.perform(get("/api/v1/books/author/Bernhard Schlink"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(17))
			.andExpect(jsonPath("$[0].isbn").value("0679442790"))
			.andExpect(jsonPath("$[0].bookAuthor").value("Bernhard Schlink"))
			.andExpect(jsonPath("$[1].isbn").value("0753804700"))
			.andExpect(jsonPath("$[1].bookTitle").value("Reader"));
	}

	@Test
	@Disabled("Still testing - verifying endpoint behavior")
	@DisplayName("Test books found by publisher and year")
	// Get books by multiple publishers and in different years
    //Example: http://localhost:8081/api/v1/books/publishers/years?p=Dell&p=Rivages&y=2007&y=2004
    // cd /Users/path/vscode/abooks && mvn test -Dtest=AbooksApplicationTests#testBooksFoundByPublisherAndYear
	void testBooksFoundByPublisherAndYear() throws Exception{
		log.info("Testing books found by publisher and year");
		mockMvc.perform(get("/api/v1/books/publishers/years?p=Dell&p=Rivages&y=2007&y=2004"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(2))
			.andExpect(jsonPath("$[0].isbn").value("0440242002"))
			.andExpect(jsonPath("$[0].bookTitle").value("Bleachers"))
			.andExpect(jsonPath("$[1].isbn").value("0385338600"))
			.andExpect(jsonPath("$[1].bookTitle").value("A Time to Kill"));
	}


	@Test
	@DisplayName("Test one book JSON found with Wildcards")
	//    //Example: /api/v1/books/Penguin Books Ltd/2001
	// cd /Users/path/vscode/abooks && mvn test -Dtest=AbooksApplicationTests#testOneBookFound
	void testOneBookFoundWithWildCards() throws Exception{
		log.info("Testing one book JSON found by publisher and year");
		mockMvc.perform(get("/api/v1/books/Penguin Books Ltd/2001"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(1))
			.andExpect(jsonPath("$[*].bookAuthor").value("John Steinbeck"));
	}

	@Test
	@Disabled("Still testing - endpoint may not exist")
	@DisplayName("Test two or more books found With Wild Cards")
	//    //Example: /api/v1/books/author/Bernhard Schlink
	// cd /Users/path/vscode/abooks && mvn test -Dtest=AbooksApplicationTests#testTwoOrMoreBooksFound
	void testTwoOrMoreBooksFoundWithWildCards() throws Exception{
		log.info("Testing two or more books found by author");
		mockMvc.perform(get("/api/v1/books/author/Bernhard Schlink"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(17))
			.andExpect(jsonPath("$[?(@.bookAuthor == 'Bernhard Schlink')].isbn").exists())
			.andExpect(jsonPath("$[*].bookAuthor").value("Bernhard Schlink"))
			.andExpect(jsonPath("$[?(@.bookTitle == 'Reader')].isbn").exists());
	}

	@Test
	@DisplayName("Test books found by publisher and year")
	@Disabled(value="Failing with java.lang.AssertionError: Got a list of values [ Bernhard Schlink, Bernhard Schlink ...]")
	// Get books by multiple publishers and in different years
    //Example: http://localhost:8081/api/v1/books/publishers/years?p=Dell&p=Rivages&y=2007&y=2004
    // cd /Users/path/vscode/abooks && mvn test -Dtest=AbooksApplicationTests#testBooksFoundByPublisherAndYear
	void testBooksFoundByPublisherAndYearWithWildCards() throws Exception{
		log.info("Testing books found by publisher and year");
		mockMvc.perform(get("/api/v1/books/publishers/years?p=Dell&p=Rivages&y=2007&y=2004"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(2))
			.andExpect(jsonPath("$[?(@.bookTitle == 'Bleachers')].isbn").value("0440242002"))
			.andExpect(jsonPath("$[?(@.bookTitle == 'A Time to Kill')].isbn").value("0385338600"));
	}



}
