package com.sai.samithi.faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.samithi.contact.ContactRequest;
import com.sai.samithi.contact.ContactResponse;
import com.sai.samithi.contact.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/faq")
public class FaqController {

	@Autowired
    FaqService faqService;

    @PostMapping
    public FaqResponse saveContact(@RequestBody @Valid FaqRequest faqRequest) {
        return faqService.add(faqRequest);
    }

    @GetMapping
    public List<FaqResponse> getAll() {
        return faqService.getAll();
    }

}
