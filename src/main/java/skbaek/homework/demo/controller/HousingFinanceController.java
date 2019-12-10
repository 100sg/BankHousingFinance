package skbaek.homework.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import skbaek.homework.demo.domain.*;
import skbaek.homework.demo.entity.BankCode;
import skbaek.homework.demo.service.CRUDService;
import skbaek.homework.demo.service.FileUploadService;
import skbaek.homework.demo.service.impl.BankHousingFinanceService;
import skbaek.homework.demo.service.impl.BankService;
import skbaek.homework.demo.service.impl.FileUploadServiceImpl;

import java.util.*;

@Slf4j
@RestController
public class HousingFinanceController {

    private CRUDService<BankCode> bankService;
    private FileUploadService uploadService;
    private BankHousingFinanceService bankHousingFinanceService;

    public HousingFinanceController(BankService bankService,
                                    FileUploadServiceImpl uploadService,
                                    BankHousingFinanceService service){
        this.uploadService = uploadService;
        this.bankService = bankService;
        this.bankHousingFinanceService = service;
    }

    @PostMapping("/fileupload")
    public ResponseEntity uploadFile(@RequestBody MultipartFile file) throws Exception {
        ApiResponseVO res = new ApiResponseVO();
        uploadService.upload(file);
        res.setResultOK(HttpStatus.OK);
        return ResponseEntity.ok( res );
    }

    @GetMapping("/banks")
    public ResponseEntity bankList() throws Exception {
        ApiResponseVO<List<BankCode>> res = new ApiResponseVO<>();
        res.setTitle("주택금융 공급 기관 목록");
        res.setData( bankService.findAll() );
        return ResponseEntity.ok( res );
    }

    @GetMapping("/banks/finance/total")
    public ResponseEntity banksFinanceTotal() throws Exception {
        ApiResponseVO<List<ResDetailTotalAmountVO>> res = new ApiResponseVO<>();
        res.setTitle("연도별 주택금융 공급현황");
        res.setData(bankHousingFinanceService.getListBanksFinanceTotal());
        return ResponseEntity.ok( res );
    }

    @PostMapping("/banks/finance/top")
    public ResponseEntity bankFinanceTop(@RequestBody RequestVO param) throws Exception {
        ApiResponseVO<List<ResultTypeVO>> res = new ApiResponseVO<>();
        res.setTitle("연도별 최대 지원금액");
        res.setData(bankHousingFinanceService.getBankFinanceTop(param));

        if(res.getData().size() == 0 ) {
            res.setReason(String.valueOf(param.getYear()) + "년도의 데이터는 없습니다.");
        }

        return ResponseEntity.ok(res);
    }

    @PostMapping("/banks/finance/avg")
    public ResponseEntity supportFinanceAvgMaxMin(@RequestBody RequestVO param) throws Exception {
        ApiResponseVO<List<ResultTypeVO>> res = new ApiResponseVO<>();
        res.setBankResultOK(param.getBankName(), bankHousingFinanceService.getSupportFinanceAvgMaxMin(param));
        res.setData(bankHousingFinanceService.getSupportFinanceAvgMaxMin(param));
        return ResponseEntity.ok(res);
    }

    @PostMapping("/banks/prediction")
    public ResponseEntity financePrediction(@RequestBody RequestVO param) throws Exception {
        ApiResponseVO<Map<String, Object>> res = new ApiResponseVO<>();
        if(param.getMonth() > 12) {
            res.setResult("FAIL");
            res.setReason("입력한 월을 확인해 주세요.");
            return ResponseEntity.ok(res);
        }
        Map<String, Object> result = bankHousingFinanceService.getSupportFinancePredict(param);
        res.setTitle("2018년도 기관별 주택금융 지원금액 예측");
        res.setData(result);
        return ResponseEntity.ok(res);
    }

}
