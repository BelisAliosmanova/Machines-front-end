package com.machines.machines_front_end.clients;

import com.machines.machines_front_end.config.FeignClientConfiguration;
import com.machines.machines_front_end.dtos.request.OfferRequestDTO;
import com.machines.machines_front_end.dtos.response.OfferAdminResponseDTO;
import com.machines.machines_front_end.dtos.response.OfferResponseDTO;
import com.machines.machines_front_end.dtos.response.OfferSingleAdminResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@FeignClient(name = "machines-api-offer", url = "${backend.base-url}/offers", configuration = FeignClientConfiguration.class)
public interface OfferClient {
    @GetMapping("/all")
    Page<OfferResponseDTO> getAll(@RequestParam int page, @RequestParam int size);

    @GetMapping("/all/admin")
    Page<OfferAdminResponseDTO> getAllAdmin(@RequestParam int page, @RequestParam int size);

    @GetMapping("/all/user")
    Page<OfferAdminResponseDTO> getAllForLoggedUser(@RequestParam int page, @RequestParam int size);

    @GetMapping("/{id}")
    OfferResponseDTO getById(@PathVariable UUID id);

    @GetMapping("/{id}/admin")
    OfferSingleAdminResponseDTO getByIdAdmin(@PathVariable UUID id);

    @PostMapping("/create")
    OfferResponseDTO create(@RequestBody OfferRequestDTO offerRequestDTO);

    @PutMapping("/{id}")
    OfferResponseDTO update(@PathVariable UUID id, @Valid @RequestBody OfferRequestDTO offerRequestDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id);
}
