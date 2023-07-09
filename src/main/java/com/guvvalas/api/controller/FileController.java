package com.guvvalas.api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FileController {

    @PostMapping("/fileToUpload")
    public Mono<Void> upload(@RequestPart("file") Mono<FilePart> filePartMono){
        return  filePartMono
                .doOnNext(fp -> System.out.println("Received File : " + fp.filename()))
                .then();
    }
}
