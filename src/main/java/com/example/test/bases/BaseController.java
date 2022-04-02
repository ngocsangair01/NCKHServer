package com.example.test.bases;

import com.example.test.constant.ResponseMessageEnum;
import com.example.test.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public class BaseController<T> {
    public ResponseEntity<?> resSuccess(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO<T>(HttpStatus.OK.value(), ResponseMessageEnum.SUCCESS, data)
        );
    }

    public ResponseEntity<?> resListSuccess(List<T> list) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO<>(HttpStatus.OK.value(), ResponseMessageEnum.SUCCESS, list)
        );
    }

    public ResponseEntity<?> resSetSuccess(Set<T> set) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO<>(HttpStatus.OK.value(), ResponseMessageEnum.SUCCESS, set)
        );
    }

//    public ResponseEntity<?> resPagination(PaginateDTO<T> paginateDTO) {
//        PaginationDTO<List<T>> paginationDTO = new PaginationDTO<>(
//                paginateDTO.getPageData().getContent(),
//                paginateDTO.getPagination()
//        );
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new PaginationResponseDTO<>(HttpStatus.OK.value(), ResponseMessageEnum.SUCCESS, paginationDTO)
//        );
//    }

    public ResponseEntity<?> resFailed() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), ResponseMessageEnum.ERROR, "Failed")
        );
    }
}