package mg.tokimahery.rmz.endpoint.rest.controller;

import static mg.tokimahery.rmz.model.Language.ENG;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;
import mg.tokimahery.rmz.exception.GlobalExceptionHandler;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.model.Author;
import mg.tokimahery.rmz.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({AuthorController.class, GlobalExceptionHandler.class})
class AuthorControllerTest {
  private Author victorHugo;
  @Autowired private MockMvc mockMvc;
  @MockBean private AuthorService authorService;

  @BeforeEach
  void setUp() {
    victorHugo =
        Author.builder().id(UUID.randomUUID()).fullName("Victor Hugo").mainLanguage(ENG).build();
  }

  @Test
  void getById_withExistingId_shouldReturn200() throws Exception {
    when(authorService.getById(victorHugo.id())).thenReturn(victorHugo);

    mockMvc.perform(get("/authors/" + victorHugo.id())).andExpect(status().isOk());
  }

  @Test
  void getById_withNonExistingId_shouldThrow404() throws Exception {
    var nonExistingId = UUID.randomUUID();
    when(authorService.getById(nonExistingId))
        .thenThrow(new NotFoundException("Author with id " + nonExistingId + " not found"));

    mockMvc.perform(get("/authors/" + nonExistingId)).andExpect(status().isNotFound());
  }

  @Test
  void getById_withInvalidId_shouldThrow400() throws Exception {
    mockMvc.perform(get("/authors/1")).andExpect(status().isBadRequest());
  }
}
