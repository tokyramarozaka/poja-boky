package mg.tokimahery.rmz.endpoint.rest.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;
import mg.tokimahery.rmz.exception.GlobalExceptionHandler;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.model.Customer;
import mg.tokimahery.rmz.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({CustomerController.class, GlobalExceptionHandler.class})
class CustomerControllerTest {
  @Autowired private MockMvc mockMvc;
  @MockBean private CustomerService customerService;
  private Customer rakoto;

  @BeforeEach
  void setUp() {
    rakoto =
        Customer.builder().id(UUID.randomUUID()).firstName("Rakoto").lastName("Kaname").build();
  }

  @Test
  void getById_shouldReturn200_when_customerExists() throws Exception {
    var existingUUID = UUID.randomUUID();
    when(customerService.findById(existingUUID)).thenReturn(rakoto);

    mockMvc.perform(get("/customers/" + existingUUID)).andExpect(status().isOk());
  }

  @Test
  void getById_shouldReturn404_when_customerDoesNotExist() throws Exception {
    var nonExistingUUID = UUID.randomUUID();
    when(customerService.findById(nonExistingUUID))
        .thenThrow(new NotFoundException("Customer with id " + nonExistingUUID + " not found"));

    mockMvc.perform(get("/customers/" + nonExistingUUID)).andExpect(status().isNotFound());
  }

  @Test
  void getById_shouldReturn400_when_customerIdIsInvalid() {}
}
