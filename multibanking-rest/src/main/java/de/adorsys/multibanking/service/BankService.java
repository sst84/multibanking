package de.adorsys.multibanking.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.adorsys.docusafe.business.types.complex.DSDocument;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import de.adorsys.multibanking.domain.BankEntity;
import de.adorsys.multibanking.service.base.BaseSystemIdService;
import de.adorsys.multibanking.utils.FQNUtils;

@Service
public class BankService extends BaseSystemIdService {

	private final YAMLFactory ymlFactory = new YAMLFactory();
	private final ObjectMapper ymlObjectMapper = new ObjectMapper(ymlFactory);

	public Optional<BankEntity> findByBankCode(String bankCode) {
		return find(bankCode, BankEntity.class, listType(), FQNUtils.banksFQN());
	}
	
	public List<BankEntity> load(){
		return load(FQNUtils.banksFQN(), listType())
				.orElse(Collections.emptyList());
	}

	public DSDocument search(String string) {
		return loadDocument(FQNUtils.banksFQN());
	}
	
    public void importBanks(InputStream inputStream) throws IOException {
    	// InputStream inputStream = this.getClass().getClassLoader().getResource("catalogue/banks/bank-catalogue.yml").openStream()
    	List<BankEntity> banks = ymlObjectMapper.readValue(inputStream, new TypeReference<List<BankEntity>>() {});
    	// Copy bank code to id.
    	banks.stream().forEach(b -> { b.setId(b.getBankCode());});
    	store(FQNUtils.banksFQN(), listType(), banks);
    }

	private static TypeReference<List<BankEntity>> listType(){
		return new TypeReference<List<BankEntity>>() {};
	}
}
