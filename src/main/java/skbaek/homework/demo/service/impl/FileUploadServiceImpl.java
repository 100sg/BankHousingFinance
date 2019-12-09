package skbaek.homework.demo.service.impl;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import skbaek.homework.demo.domain.CreditGuaranteeAmountVO;
import skbaek.homework.demo.repository.BankHousingFinanceRepository;
import skbaek.homework.demo.service.FileUploadService;
import skbaek.homework.demo.util.FileHeader;
import skbaek.homework.demo.util.FileCsvParser;
import skbaek.homework.demo.util.CreditGuaranteeAmountMapper;

import java.util.Collection;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private BankHousingFinanceRepository bankHousingFinanceRepository;
    private CreditGuaranteeAmountMapper creditGuaranteeAmountMapper;

    public FileUploadServiceImpl(BankHousingFinanceRepository repository, CreditGuaranteeAmountMapper mapper){
        this.bankHousingFinanceRepository = repository;
        this.creditGuaranteeAmountMapper = mapper;
    }

    @Override
    public void upload(MultipartFile file) throws Exception {
        CsvSchema schema = createBankSchema();
        FileCsvParser parser = new FileCsvParser();
        List<CreditGuaranteeAmountVO> creditGuaranteeAmountVOS = parser.read(CreditGuaranteeAmountVO.class, file, schema);
        save(creditGuaranteeAmountVOS);
    }

    private CsvSchema createBankSchema() {
        return CsvSchema.builder()
                .addColumn(FileHeader.YEAR.getHeader())
                .addColumn(FileHeader.MONTH.getHeader())
                .addColumn(FileHeader.HOUSECITY_FUND.getHeader())
                .addColumn(FileHeader.KOOKMIN.getHeader())
                .addColumn(FileHeader.WOORI.getHeader())
                .addColumn(FileHeader.SHINHAN.getHeader())
                .addColumn(FileHeader.KOREACITY.getHeader())
                .addColumn(FileHeader.HANA.getHeader())
                .addColumn(FileHeader.NONGHYUP_SUHYUP.getHeader())
                .addColumn(FileHeader.KOREAEXCHANGE.getHeader())
                .addColumn(FileHeader.ETC.getHeader())
                .build().withHeader();
    }

    private void save(List<CreditGuaranteeAmountVO> creditGuaranteeAmountVOS) {
        creditGuaranteeAmountVOS.stream()
                .map(creditGuaranteeAmountMapper::toGuaranteeAmounts)
                .flatMap(Collection::stream)
                .forEach(bankHousingFinanceRepository::save);
    }
}