package mg.tokimahery.rmz.endpoint.rest.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;
import mg.tokimahery.rmz.exception.GlobalExceptionHandler;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.model.Book;
import mg.tokimahery.rmz.service.BookCopyService;
import mg.tokimahery.rmz.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({BookController.class, GlobalExceptionHandler.class})
class BookControllerTest {
  private Book harryPotter;
  private Book hungerGames;

  @Autowired private MockMvc mockMvc;

  @MockBean private BookService bookService;

  @MockBean private BookCopyService bookCopyService;

  @BeforeEach
  void setUp() {
    harryPotter = Book.builder().id(UUID.randomUUID()).title("Harry Potter").build();
    hungerGames = Book.builder().id(UUID.randomUUID()).title("Hunger Games").build();
  }

  @Test
  void getBooks_ok() throws Exception {
    given(bookService.findAll()).willReturn(List.of(harryPotter, hungerGames));

    mockMvc
        .perform(get("/books"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2));
  }

  @Test
  void getBookById_shouldReturn400_with_invalidUUID() throws Exception {
    mockMvc.perform(get("/books/1")).andExpect(status().isBadRequest());
  }

  @Test
  void getBookById_shouldReturn404_with_nonExistingBook() throws Exception {
    var randomUUID = UUID.randomUUID();
    given(bookService.findById(randomUUID))
        .willThrow(new NotFoundException("Book with id " + randomUUID + " not found"));

    mockMvc.perform(get("/books/" + randomUUID)).andExpect(status().isNotFound());
  }
}
