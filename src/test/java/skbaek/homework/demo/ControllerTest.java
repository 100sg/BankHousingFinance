package skbaek.homework.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import skbaek.homework.demo.controller.HousingFinanceController;
import skbaek.homework.demo.entity.BankCode;
import skbaek.homework.demo.repository.BankHousingFinanceRepository;
import skbaek.homework.demo.repository.BankRepository;
import skbaek.homework.demo.service.CRUDService;
import skbaek.homework.demo.service.FileUploadService;
import skbaek.homework.demo.service.impl.BankHousingFinanceService;
import skbaek.homework.demo.service.impl.BankService;
import skbaek.homework.demo.service.impl.FileUploadServiceImpl;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(HousingFinanceController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BankHousingFinanceService bankHousingFinanceService;

    @MockBean
    private FileUploadServiceImpl uploadService;;

    @MockBean
    private BankService bankService;

    @Test
    public void file_pasrsing_test() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file",
                "orig", null, "bar".getBytes());

        this.mockMvc.perform(MockMvcRequestBuilders
                .multipart("/fileupload")
                .file(file))
                .andDo(print())
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }

    @Test
    public void bank_list_test() throws Exception {
        this.mockMvc.perform(get("/banks")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void bank_total_test() throws Exception {
        this.mockMvc.perform(get("/banks/finance/total")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void bank_top_test() throws Exception {
        this.mockMvc.perform(get("/banks/finance/top")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .param("year","2007"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void bank_avd_test() throws Exception {
        this.mockMvc.perform(get("/banks/finance/avg")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .param("bankName", "국민은행"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void testGetPredictionOfBank() throws Exception {
        this.mockMvc.perform(get("/banks/prediction")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .param("bankName", "국민은행")
                .param("month", "2"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()));
    }

}
