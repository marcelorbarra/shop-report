package br.com.marcelorbarra.controller;

import br.com.marcelorbarra.dto.ShopReportDTO;
import br.com.marcelorbarra.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop_report")
@RequiredArgsConstructor
public class ShopController {

    private final ReportRepository reportRepository;

    @GetMapping
    public List<ShopReportDTO> getShopReport() {
        return reportRepository.findAll()
                .stream()
                .map(shop -> ShopReportDTO.convert(shop))
                .collect(Collectors.toList());
    }

}
