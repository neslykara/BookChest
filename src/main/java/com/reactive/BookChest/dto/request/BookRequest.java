package com.reactive.BookChest.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

    @NotBlank(message = "Title is mandatory")
    @Size(min = 1, max = 255, message = "Title should be between 1 and 255 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(min = 1, max = 255, message = "Author should be between 1 and 255 characters")
    private String author;

    @NotNull(message = "Published year is mandatory")
    @Min(value = 1450, message = "Published year must be greater than or equal to 1450")
    private int publishedYear;

    @NotNull(message = "Page count is mandatory")
    @Min(value = 1, message = "Page count must be greater than or equal to 1")
    private int pageCount;

    @AssertTrue(message = "Published year cannot be in the future")
    private boolean isPublishedYearValid() {
        return publishedYear <= LocalDate.now().getYear();
    }
}
