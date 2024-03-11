package com.sai.samithi.faq;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record FaqRequest(	
	@NonNull
	String question, 
	
	@NonNull
	String answer
) 
{

}
