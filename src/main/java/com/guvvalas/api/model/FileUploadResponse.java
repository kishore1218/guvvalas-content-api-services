package com.guvvalas.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileUploadResponse {
    String fileName;
}
