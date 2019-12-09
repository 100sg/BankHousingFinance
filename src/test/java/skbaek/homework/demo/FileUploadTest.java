package skbaek.homework.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import skbaek.homework.demo.domain.CreditGuaranteeAmountVO;
import skbaek.homework.demo.repository.BankHousingFinanceRepository;
import skbaek.homework.demo.service.impl.FileUploadServiceImpl;
import skbaek.homework.demo.util.CreditGuaranteeAmountMapper;
import skbaek.homework.demo.util.FileCsvParser;

import static org.mockito.Mockito.mock;

public class FileUploadTest{
    private CreditGuaranteeAmountVO creditGuaranteeAmountVO;
    private CreditGuaranteeAmountMapper creditGuaranteeAmountMapper;
    private BankHousingFinanceRepository bankHousingFinanceRepository;
    private FileUploadServiceImpl fileUploadService;
    private FileCsvParser fileCsvParser;

    @BeforeEach
    public void mockUp() {
        creditGuaranteeAmountVO = mock(CreditGuaranteeAmountVO.class);
        creditGuaranteeAmountMapper = mock(CreditGuaranteeAmountMapper.class);
        fileCsvParser = mock(FileCsvParser.class);

        fileUploadService = new FileUploadServiceImpl(bankHousingFinanceRepository, creditGuaranteeAmountMapper);
    }

    @Test
    public void test_upload() {
        MockMultipartFile file = new MockMultipartFile("file", "orig", null, "test".getBytes());
        try {
            fileUploadService.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
