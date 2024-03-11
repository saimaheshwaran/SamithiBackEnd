package com.sai.samithi.faq;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FaqService {
	@Autowired
    FaqRepository faqRepository;
    
    @Autowired
    ModelMapper mapper;

    public FaqResponse add(FaqRequest faqRequest) {
    	
    	Faq faqDb = Faq.builder()
    	.question(faqRequest.question())
    	.answer(faqRequest.answer())
    	.build();
    	
    	Faq faq = faqRepository.save(faqDb);
        return mapper.map(faq, FaqResponse.class);
    }

	public List<FaqResponse> getAll() {
	 	List<Faq> faqs = faqRepository.findAll();
	 	List<FaqResponse> faqResponses = faqs
	 			.stream()
	 			.map( faq -> mapper.map(faq, FaqResponse.class))
	 			.collect(Collectors.toList());
		return faqResponses;
	}

}
